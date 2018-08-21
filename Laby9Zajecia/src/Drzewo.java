import static java.lang.Integer.parseInt;

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
        for (int i = 0; i < operation.length(); i++) {
            String kluczS = "" + operation.charAt(i);
            int klucz = 0;
            while (!kluczS.contains(" ") && i < operation.length() - 1) {
                i++;
                kluczS += operation.charAt(i);
            }

            if (kluczS.contains(" ")) {
                if(kluczS.trim()!="")
                klucz = parseInt(kluczS.trim());
            }

            Wezel wezel = new Wezel(klucz);

            if(korzen==null) setKorzen(wezel);
            else{
                while(korzen.getLeft()!=null && korzen.getRight()!=null){
                    if(korzen.getKey()<=wezel.getKey()){
                        korzen = korzen.getLeft();
                    }
                    else if(korzen.getKey()>wezel.getKey()){
                        korzen = korzen.getRight();
                    }
                }
                korzen = wezel;
            }
        }

        return true;
    }

    void insert(int key) {
        korzen = insertRec(korzen, key);
    }

    Wezel insertRec(Wezel root, int key) {
        if (root == null) {
            root = new Wezel(key);
            return root;
        }

        if (key <= root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
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

    public int sumaKluczy() {
        return sumaKluczy(korzen);
    }

    private int sumaKluczy(Wezel current) {
        if (current == null) return 0;
        return current.key + sumaKluczy(current.left) + sumaKluczy(current.right);
    }

}