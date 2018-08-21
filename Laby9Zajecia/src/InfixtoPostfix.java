import java.util.Scanner;

public class InfixtoPostfix {

    Stack<Character> operators;
    String postfix;

    public InfixtoPostfix() {
    }

    public String convert(String infix) throws Exception {
        operators = new Stos<>();
        postfix = "";
        String wyrazenie = infix;
        infix = "";
        boolean poprzedni = false;
        int poprzedniPrecedence = 0;

        for (int i = 1; i < wyrazenie.length(); i++) {

            infix += wyrazenie.charAt(i - 1);

            if (isOperator(wyrazenie.charAt(i - 1)) && !isOperator(wyrazenie.charAt(i)) ||
                    !isOperator(wyrazenie.charAt(i - 1)) && isOperator(wyrazenie.charAt(i)) ||
                    isOperator(wyrazenie.charAt(i - 1)) && isOperator(wyrazenie.charAt(i))) {
                infix += " ";
            }

        }

        infix += wyrazenie.charAt(wyrazenie.length() - 1);

        Scanner sc = new Scanner(infix);

        while (sc.hasNext()) {

            String element = sc.next();
            char c = '0';

            if (element.length() == 1) {
                c = element.charAt(0);
            }

            if (element.length() > 1) {
                postfix += element + " ";
            } else if ('0' <= c && c <= '9') {
                postfix += c + " ";
            } else if (isOperator(c)) {
                processOperator(c);
            } else {
                throw new Exception("Niepoprawny format wyrazenia.");
            }

            if (isOperator(c) && poprzedni && precedence(c) > -1) {
                System.out.println("Wpisana zostala zla formula.");
                return "";
            }

            if (precedence(c) > -1 && poprzedniPrecedence > -1) {
                poprzedni = isOperator(c);
            } else poprzedni = false;

            poprzedniPrecedence = precedence(c);
        }

        while (!operators.empty()) {
            postfix += operators.pop() + " ";
        }

        return postfix;
    }

   /* public String convertBack(String ONP) throws Exception{

        operators = new Stos<>();
        String postfix = "";

        Scanner sc = new Scanner(ONP);

        while (sc.hasNext()) {

            String element = sc.next();
            char c = '0';
            int precedence;

            if (element.length() == 1) {
                c = element.charAt(0);
                if(!isOperator(c)) {
                    precedence = 5;
                    processOperator(c);
                }
                else {
                    precedence = precedence(c);
                }
            }

            else if (element.length() > 1) {
                precedence = 5;
                for(int j=0; j<element.length(); j++){

                }
            }

            else {
                throw new Exception("Niepoprawny format wyrazenia.");
            }
        }

        while (!operators.empty()) {
            postfix += operators.pop();
        }

        return postfix;
    }
    */

    public void processOperator(Character op) {
        if (operators.empty() || op == '(') {
            operators.push(op);
        } else {
            char topOp = operators.peek();
            if (precedence(op) > precedence(topOp)) {
                operators.push(op);
            } else {
                while (!operators.empty() && precedence(op) <= precedence(topOp)) {
                    operators.pop();
                    if (topOp == '(') {
                        break;
                    }
                    postfix += topOp + " ";

                    if (!operators.empty()) {
                        topOp = operators.peek();
                    }
                }
                if (op != ')') {
                    operators.push(op);
                }
            }

        }
    }

    public boolean isOperator(char op) {
        char[] operatorsArray = {'+', '-', '*', '/', '%', '(', ')'};
        for (char c : operatorsArray) {
            if (c == op) return true;
        }

        return false;
    }

    public int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/' || op == '%') {
            return 2;
        } else if (op == '(' || op == ')') {
            return -1;
        }

        return 0;
    }

    public int calculate(String postfix) {
        Stack<Integer> elements = new Stos<>();

        Scanner read = new Scanner(postfix);

        while (read.hasNext()) {

            String element = read.next();
            if (!isOperator(element.charAt(0))) {
                elements.push(Integer.parseInt(element));
            } else {
                int licz2 = elements.pop();
                int licz1 = elements.pop();
                try {
                    elements.push(kalkulator(licz1, licz2, element.charAt(0)));
                    // System.out.println("Operacja liczbowa: " + licz1 + element.charAt(0) + licz2);
                } catch (ArithmeticException ae) {
                    System.out.println("Nie dziel przez zero! ");
                    return 0;
                }

            }
        }

        return elements.pop();
    }

    public int kalkulator(int licz1, int licz2, char op) {

        if (op == '+') return licz1 + licz2;
        else if (op == '-') return licz1 - licz2;
        else if (op == '*') return licz1 * licz2;
        else if (op == '%') return licz1 % licz2;
        else if (op == '/') return licz1 / licz2;

        return 0;
    }

}
