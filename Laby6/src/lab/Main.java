package lab;

import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void zapiszDoPliku(ListaDwukierunkowa<Pracownik> list, String nazwaPliku){
        try {
            FileOutputStream file = new FileOutputStream(nazwaPliku);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(list.length());

            list.get(0);
            for(int i=0; i<list.length(); i++){
                output.writeObject(list.get(i));
            }
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ListaDwukierunkowa<Pracownik> odczytZPliku(ListaDwukierunkowa<Pracownik> list, String nazwaPliku){
        list.clear();
        try {
            FileInputStream file = new FileInputStream("baza.txt");
            ObjectInputStream output = new ObjectInputStream(file);
            int rozmiar = (int)output.readObject();
            for(int i=0; i<rozmiar; i++) {
                Pracownik pracownik = (Pracownik) output.readObject();
                list.add(pracownik);
            }
            output.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        list.wyswietl();
        return list;
    }

    public static void main(String[] args) {

        System.out.println("Lista instrukcji:");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Jezeli chcesz stworzyc nowa baze danych pracownikow, napisz stworz");
        System.out.println("Jezeli chcesz odczytać bazę danych z pliku, napisz odczyt");
        System.out.println("Jezeli chcesz wyswietlic wszystkie elementy bazy danych, napisz pokaz");
        System.out.println("Jezeli chcesz dodac nowego pracownika, napisz dodaj");
        System.out.println("Jezeli chcesz usunac danego pracownika, napisz usunNrIndeksu");
        System.out.println("Jezeli chcesz zaktualizowac dane danego pracownika, napisz aktNrIndeksu");
        System.out.println("Jezeli chcesz wyswietlic element bazy danych o danym indeksie, napisz wysNrIndeksu");
        System.out.println("Jezeli chcesz zapisac swoja baze danych, napisz zapisz");
        System.out.println("Jezeli chcesz zakonczyc dzialanie programu, napisz zakoncz");
        System.out.println("-------------------------------------------------------------------");

        Scanner in = new Scanner(System.in);

        String instrukcja = "";

        ListaDwukierunkowa<Pracownik> list = new ListaDwukierunkowa<>();

        Pracownik prac1 = new Pracownik(1932045, "Pawel", "Janic", "19.06.1998", "kierownik", 5000, 4);
        Pracownik prac2 = new Pracownik(1931045, "Kamil", "Olszanski", "10.04.1998", "pomywacz", 2000, 1);
        Pracownik prac3 = new Pracownik(1942045, "Jakub", "Litkowski", "12.09.1998", "programista", 3500, 6);
        Pracownik prac4 = new Pracownik(1972045, "Michal", "Dabrowski", "24.11.1998", "pomywacz", 2000, 2);

        list.add(prac1);
        list.add(prac2);
        list.add(prac3);
        list.add(prac4);

        while (!instrukcja.equals("zakoncz")) {

            System.out.println("Podaj instrukcje: ");
            instrukcja = in.nextLine();

            if (instrukcja.equals("stworz")) {
                list.clear();
                list.wyswietl();
            } else if (instrukcja.equals("pokaz")) {
                list.wyswietl();
            } else if (instrukcja.equals("odczyt")) {
                odczytZPliku(list, "baza.ser");
            } else if (instrukcja.equals("zapisz")) {
                zapiszDoPliku(list,"baza.ser");
            } else if (instrukcja.equals("dodaj")) {
                System.out.println("Podaj imie nowego pracownika: ");
                String imie = in.next();
                System.out.println("Podaj nazwisko nowego pracownika: ");
                String nazwisko = in.next();
                System.out.println("Podaj pesel nowego pracownika: ");
                int pesel = in.nextInt();
                System.out.println("Podaj date urodzenia nowego pracownika: ");
                String dataUrodzenia = in.next();
                System.out.println("Podaj stanowisko nowego pracownika: ");
                String stanowisko = in.next();
                System.out.println("Podaj pensje nowego pracownika: ");
                double pensja = in.nextDouble();
                System.out.println("Podaj staz nowego pracownika: ");
                int staz = in.nextInt();

                Pracownik pracownik = new Pracownik(pesel, imie, nazwisko, dataUrodzenia, stanowisko, pensja, staz);
                list.add(pracownik);
            } else if (instrukcja.charAt(0) == 'u' && instrukcja.charAt(1) == 's' && instrukcja.charAt(2) == 'u' && instrukcja.charAt(3) == 'n') {
                String pesel = instrukcja.substring(4);
                list.usun(pesel);
                list.wyswietl();
            } else if (instrukcja.charAt(0) == 'a' && instrukcja.charAt(1) == 'k' && instrukcja.charAt(2) == 't') {
                int index = parseInt(instrukcja.substring(3));
                Pracownik pracownik = list.get(index);

                System.out.println("Podaj zmienione imie pracownika: ");
                String imie = in.next();
                pracownik.setImie(imie);
                System.out.println("Podaj zmienione nazwisko pracownika: ");
                String nazwisko = in.next();
                pracownik.setNazwisko(nazwisko);
                System.out.println("Podaj zmienione stanowisko pracownika: ");
                String stanowisko = in.next();
                pracownik.setStanowisko(stanowisko);
                System.out.println("Podaj zmieniona pensje pracownika: ");
                double pensja = in.nextDouble();
                pracownik.setPensja(pensja);
                System.out.println("Podaj zmieniony staz pracownika: ");
                int staz = in.nextInt();
                pracownik.setStaz(staz);

                list.wyswietl(index);

            } else if (instrukcja.charAt(0) == 'w' && instrukcja.charAt(1) == 'y' && instrukcja.charAt(2) == 's') {
                int index = parseInt(instrukcja.substring(3));
                if(index<=list.length() && index>-1) {
                    list.wyswietl(index);
                }
                else System.out.println("Wprowadzaony indeks jest niepoprawny");
            } else if (instrukcja.equals("")) instrukcja = instrukcja;
            else System.out.println("Podales niepoprawna instrukcje, sprobuj ponownie");
        }

    }

}
