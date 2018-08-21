public class Main {

    public static void main(String[] args) {

        String wyr1 = "((2+3)*2+2)%5";
        String wyr2 = "((10+2)*(2+3))/10";
        String wyr3 = "(2+2)/(2-2)";

        InfixtoPostfix infixtoPostfix = new InfixtoPostfix();
        try {
            System.out.println(wyr1);
            String wyrazenie = infixtoPostfix.convert(wyr1);
            System.out.println(wyrazenie);
            System.out.println(infixtoPostfix.calculate(wyrazenie));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(wyr2);
            String wyrazenie = infixtoPostfix.convert(wyr2);
            System.out.println(wyrazenie);
            System.out.println(infixtoPostfix.calculate(wyrazenie));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(wyr3);
            String wyrazenie = infixtoPostfix.convert(wyr3);
            System.out.println(wyrazenie);
            System.out.println(infixtoPostfix.calculate(wyrazenie));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
