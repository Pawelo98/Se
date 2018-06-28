import java.io.*;
import java.util.Scanner;

public class Main {

    public static void wypiszPracownikow(Pracownik [] tab){

        Iterator<Pracownik> iter = new Firma<Pracownik>(tab);

        System.out.println("Nazwisko       " + " Imie          " + "  Staz      " + " Pesel       "
                + "Pensja        ");

//        for(Pracownik p: tab) {
//            System.out.println(p.toString());
//        }
        iter.pierwszy();
        while(iter.jestWZakresie()){
            System.out.println(iter.elementBiezacy());
            iter.nastepny();
        }
    }

    public static void zapiszDoPliku(Pracownik [] tab, String nazwaPliku){
        try {
            Iterator<Pracownik> iter = new Firma<Pracownik>(tab);

            FileOutputStream file = new FileOutputStream(nazwaPliku);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(tab.length);

            iter.pierwszy();
            while(iter.jestWZakresie()){
                output.writeObject(iter.elementBiezacy());
                iter.nastepny();
            }
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Pracownik[] czytanieZPliku(String nazwaPliku){
        Pracownik[] tab = null;
        try {
            FileInputStream file = new FileInputStream("pracownicy.txt");
            ObjectInputStream output = new ObjectInputStream(file);
            int rozmiar = (int)output.readObject();
            tab = new Pracownik [rozmiar];
            for(int i=0; i<rozmiar; i++) {
                tab[i] = (Pracownik) output.readObject();
            }
            output.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return tab;
    }


    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj rozmiar tablicy pracownikow: ");
        int rozmiar = in.nextInt();
        Pracownik[] tab = new Pracownik[rozmiar];

        for (int i = 0; i < rozmiar; i++)
        {
            System.out.println("Podaj dane pracownika o indeksie " + i + ": ");
            System.out.print("Imie: ");
            String imie = in.next();
            System.out.print("Nazwisko: ");
            String nazwisko = in.next();
            System.out.print("Staz(liczba naturalna): ");
            int staz = in.nextInt();
            System.out.print("Pesel(wpisz 11 cyfr): ");
            String pesel = in.next();
            System.out.print("Pensja: ");
            double pensja = in.nextDouble();

            tab[i] = new Pracownik(imie, nazwisko, staz, pesel, pensja);
            System.out.println();
        }

        in.close();

        zapiszDoPliku(tab, "pracownicy.txt");
        System.out.println("Tablica zapisana do pliku: ");
        wypiszPracownikow(tab);
        Pracownik [] pracownicy2 = czytanieZPliku("pracownicy.txt");
        System.out.println("Przeczytana tablica z pliku: ");
        wypiszPracownikow(pracownicy2);
    }
}
