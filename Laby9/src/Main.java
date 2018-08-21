import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Lista instrukcji:");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Jezeli chcesz wczytac nowe wyrazenie, napisz wczytaj");
        System.out.println("Jezeli chcesz zamienic wyrazenie na ONP i je wyswietlic, napisz zamien");
        System.out.println("Jezeli chcesz stworzyc drzewo binarne oparte na obecnym wyrazeniu, napisz stworz");
        System.out.println("Jezeli chcesz obliczyc wartosc swojego wyrazenia, napisz oblicz");
        System.out.println("Jezeli chcesz wyswietlic wyrazenie w postaci infiksowej, napisz infix");
        System.out.println("Jezeli chcesz wyswietlic wyrazenie w postaci postfiksowej, napisz postfix");
        System.out.println("Jezeli chcesz wyswietlic ilosc lisci swojego drzewa, napisz liscie");
        System.out.println("Jezeli chcesz wyswietlic wysokosc swojego drzewa, napisz wysokosc");
        System.out.println("Jezeli chcesz wyswietlic ilosc wezlow swojego drzewa, napisz wezly");
        System.out.println("-------------------------------------------------------------------");

        String operation = null;
        Drzewo drzewo = null;
        String strOperation = null;

        Scanner in = new Scanner(System.in);

        String instrukcja = "";

        while (!instrukcja.equals("zakoncz")) {
            System.out.println("Podaj instrukcje: ");
            instrukcja = in.nextLine();
            if (instrukcja.equals("wczytaj")) {
                System.out.println("Podaj operaccje: ");
                Scanner in2 = new Scanner(System.in);
                operation = in2.nextLine();
            } else if (instrukcja.equals("zamien")) {
                if (operation != null) {
                    try {
                        InfixtoPostfix infixtoPostfix = new InfixtoPostfix();
                        strOperation = infixtoPostfix.convert(operation);
                        System.out.println(strOperation);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (instrukcja.equals("stworz")) {
                drzewo = new Drzewo();
                drzewo.stworz(strOperation);
            } else if (instrukcja.equals("oblicz")) {
                InfixtoPostfix infixtoPostfix = new InfixtoPostfix();
                System.out.println("Wynik Twojego wyrazenia to: " + infixtoPostfix.calculate(strOperation));
            } else if (instrukcja.equals("infix")) {
                drzewo.inorder();
                System.out.println();
            } else if (instrukcja.equals("liscie")) {
                System.out.println("Ilosc lisci: " + drzewo.iloscLisci());
            } else if (instrukcja.equals("wysokosc")) {
                System.out.println("Wysokosc drzewa wynosi: " + drzewo.wysokosc(drzewo.getKorzen()));
            } else if (instrukcja.equals("wezly")) {
                System.out.println("Ilosc wezlow drzewa wynosi: " + drzewo.iloscWezlow());
            } else if (instrukcja.equals("postfix")) {
                System.out.println(strOperation);
            } else if (instrukcja.equals("")) instrukcja = instrukcja;
            else System.out.println("Podales niepoprawna instrukcje, sprobuj ponownie");
        }

    }
}
