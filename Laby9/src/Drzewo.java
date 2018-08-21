public class Drzewo {

    private Wezel korzen;

    public Drzewo() {
        this.korzen = null;
    }

    public Wezel getKorzen() {
        return korzen;
    }

    public void setKorzen(Wezel wezel) {
        this.korzen = wezel;
    }

    public boolean isOperator(char op) {
        char[] operatorsArray = {'+', '-', '*', '/', '%', '(', ')'};
        for (char c : operatorsArray) {
            if (c == op) return true;
        }

        return false;
    }

    public boolean stworz(String operation) {
        Stack<Wezel> stack = new Stos<>();
        for (int i = 0; i < operation.length(); i++) {
            String klucz = "" + operation.charAt(i);
            while (!klucz.contains(" ") && i < operation.length() - 1) {
                i++;
                klucz += operation.charAt(i);
            }

            if (klucz.contains(" ")) {
                klucz = klucz.trim();
            }

            Wezel wezel = new Wezel(klucz);
            if (klucz.length() == 1 && isOperator(klucz.charAt(0))) {
                wezel.setRight(stack.pop());
                wezel.setLeft(stack.pop());
            }

            stack.push(wezel);
        }

        this.setKorzen(stack.pop());

        return true;
    }

    void inorder() {
        inorderRec(korzen);
    }

    void inorderRec(Wezel korzen) {
        if (korzen != null) {
            System.out.print("(");
            inorderRec(korzen.left);
            System.out.print(korzen.key);
            inorderRec(korzen.right);
            System.out.print(")");
        }
    }

    int wysokosc(Wezel wezel) {
        if (wezel == null)
            return 0;
        else {
            int lDepth = wysokosc(wezel.left);
            int rDepth = wysokosc(wezel.right);

            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    int iloscLisci() {
        return iloscLisci(korzen);
    }

    int iloscLisci(Wezel wezel) {
        if (wezel == null)
            return 0;
        if (wezel.left == null && wezel.right == null)
            return 1;
        else
            return iloscLisci(wezel.left) + iloscLisci(wezel.right);
    }

    public int iloscWezlow() {
        return iloscWezlow(korzen);
    }

    private int iloscWezlow(Wezel current) {
        if (current == null) return 0;
        return 1 + iloscWezlow(current.left) + iloscWezlow(current.right);
    }

}