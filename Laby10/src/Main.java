public class Main {

    public static void main(String[] args) {

        Drzewo drzewo = new Drzewo();

        try {
            drzewo.stworz("wiersz2.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Drzewo 1 alfabetycznie:");
        drzewo.inorder();
        System.out.println();

        System.out.println("Drzewo 1 wszerz:");
        drzewo.przejscieWszerz();
        System.out.println();

        drzewo.delete("godziny");
        System.out.println("Drzewo 1 alfabetycznie bez godziny:");
        drzewo.inorder();
    }
}
