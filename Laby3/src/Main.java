import java.util.*;

public class Main {

    public static void stworzListe(Lista<Karta> list){

        int wartosc = 1;
        int kolor = 0;
        Random random = new Random();

        Karta kartaAsKier = new Karta(1, 0, true);

        list.dodaj(znajdzIndex(list, kartaAsKier), kartaAsKier);
        list.dodaj(znajdzIndex(list, kartaAsKier), kartaAsKier);
        list.dodaj(znajdzIndex(list, kartaAsKier), kartaAsKier);

        while(wartosc!=0){
            wartosc = random.nextInt(15);
            kolor = random.nextInt(4);
            if(wartosc!=0) {
                if(wartosc!=14) {
                    Karta karta = new Karta(wartosc, kolor, true);
                    list.dodaj(znajdzIndex(list, karta), karta);
                }
                else {
                    Karta karta = new Karta(wartosc, kolor, false);
                    list.dodaj(znajdzIndex(list, karta), karta);
                }
            }
        }
    }

    public static void usunPowtorzenie(Lista<Karta> list){

        for(int i=0; i<list.ilosc()-1; i++){
            if(list.get(i).getKolor() == list.get(i+1).getKolor()){
                if(list.get(i).getWartosc() == list.get(i+1).getWartosc()) {
                        list.usun(i+1);
                        i--;
                }
            }
        }
    }

    public static void usunZakryte(Lista<Karta> list){
        for(int i=0; i<list.ilosc(); i++){
            if(list.get(i).getZnacznik() == false){
                list.usun(i);
            }
        }
    }

    public static void wyczysc(Lista<Karta> list){
        list.wyczysc();
    }

    public static int znajdzIndex(Lista<Karta> list, Karta karta){

        for(int i=0; i<list.ilosc(); i++){
            if(list.get(i).compareTo(karta)==1) return i;
        }
        return list.ilosc();
    }

    public static void wyswietlListe(Lista<Karta> list){

        Iterator<Karta> itr = list.iterator();
        String kol = "";
        String num = "";

        while (itr.hasNext()) {
            Karta karta = itr.next();
            if(karta.getKolor()==0) kol = "kier";
            if(karta.getKolor()==1) kol = "karo";
            if(karta.getKolor()==2) kol = "trefl";
            if(karta.getKolor()==3) kol = "pik";

            if(karta.getWartosc()==1) num = "as";
            if(karta.getWartosc()==2) num = "2";
            if(karta.getWartosc()==3) num = "3";
            if(karta.getWartosc()==4) num = "4";
            if(karta.getWartosc()==5) num = "5";
            if(karta.getWartosc()==6) num = "6";
            if(karta.getWartosc()==7) num = "7";
            if(karta.getWartosc()==8) num = "8";
            if(karta.getWartosc()==9) num = "9";
            if(karta.getWartosc()==10) num = "10";
            if(karta.getWartosc()==11) num = "walet";
            if(karta.getWartosc()==12) num = "dama";
            if(karta.getWartosc()==13) num = "krol";
            if(karta.getWartosc()==14) {
                num = "karta";
                kol = "zakryta";
            }
            System.out.print("[" + num + " " + kol + "] ");
        }
        System.out.println();
    }

    public static int iloscKart(Lista<Karta> list){
        return list.ilosc();
    }

    public static int iloscZakrytych(Lista <Karta> list){
        int ilosc = 0;

        for(int i = 0; i<list.ilosc(); i++){
            if(list.get(i).getZnacznik()==false){
                ilosc++;
            }
        }
        return ilosc;
    }

    public static int iloscOdkrytych(Lista <Karta> list){
        int ilosc = 0;

        for(int i = 0; i<list.ilosc(); i++){
            if(list.get(i).getZnacznik()==true){
                ilosc++;
            }
        }
        return ilosc;
    }

    public static void kartyOWartosci(Lista<Karta> list, String wartosc){
        String kol = "";
        String num = "";
        boolean obecnosc = false;

        for(int i=0; i<list.ilosc(); i++){
            Karta karta = list.get(i);

            if(karta.getKolor()==0) kol = "kier";
            if(karta.getKolor()==1) kol = "karo";
            if(karta.getKolor()==2) kol = "trefl";
            if(karta.getKolor()==3) kol = "pik";

            if(karta.getWartosc()==1) num = "as";
            if(karta.getWartosc()==2) num = "2";
            if(karta.getWartosc()==3) num = "3";
            if(karta.getWartosc()==4) num = "4";
            if(karta.getWartosc()==5) num = "5";
            if(karta.getWartosc()==6) num = "6";
            if(karta.getWartosc()==7) num = "7";
            if(karta.getWartosc()==8) num = "8";
            if(karta.getWartosc()==9) num = "9";
            if(karta.getWartosc()==10) num = "10";
            if(karta.getWartosc()==11) num = "walet";
            if(karta.getWartosc()==12) num = "dama";
            if(karta.getWartosc()==13) num = "krol";
            if(karta.getWartosc()==14) {
                num = "karta";
                kol = "zakryta";
            }

            if(wartosc.equals(num)){
                System.out.print("[" + num + " " + kol + "] ");
                obecnosc = true;
            }
        }
        if(obecnosc == false){
            System.out.println("Nie ma kart o wartosci " + wartosc);
        }
        System.out.println();
    }

    public static void kartyOKolorze(Lista<Karta> list, String kolor){

        String kol = "";
        String num = "";
        boolean obecnosc = false;

        for(int i=0; i<list.ilosc(); i++){
            Karta karta = list.get(i);

            if(karta.getKolor()==0) kol = "kier";
            if(karta.getKolor()==1) kol = "karo";
            if(karta.getKolor()==2) kol = "trefl";
            if(karta.getKolor()==3) kol = "pik";

            if(karta.getWartosc()==1) num = "as";
            if(karta.getWartosc()==2) num = "2";
            if(karta.getWartosc()==3) num = "3";
            if(karta.getWartosc()==4) num = "4";
            if(karta.getWartosc()==5) num = "5";
            if(karta.getWartosc()==6) num = "6";
            if(karta.getWartosc()==7) num = "7";
            if(karta.getWartosc()==8) num = "8";
            if(karta.getWartosc()==9) num = "9";
            if(karta.getWartosc()==10) num = "10";
            if(karta.getWartosc()==11) num = "walet";
            if(karta.getWartosc()==12) num = "dama";
            if(karta.getWartosc()==13) num = "krol";
            if(karta.getWartosc()==14) {
                num = "karta";
                kol = "zakryta";
            }

            if(kolor.equals(kol)){
                System.out.print("[" + num + " " + kol + "] ");
                obecnosc = true;
            }
        }
        if(obecnosc == false){
            System.out.println("Nie ma kart o kolorze " + kolor);
        }
        System.out.println();
    }

    public static void main(String [] args){

        Lista<Karta> list = new Lista<Karta>();

        System.out.println("Lista instrukcji:");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Jezeli chcesz stworzyc nowa kolekcje kart, napisz stworz");
        System.out.println("Jezeli chcesz wyswietlic swoja kolekcje kart, napisz wyswietl");
        System.out.println("Jezeli chcesz wyswietlic ilosc kart w swojej kolekcji, napisz ilosc");
        System.out.println("Jezeli chcesz wyswietlic ilosc kart zakrytych w swojej kolekcji, napisz iloscZakrytych");
        System.out.println("Jezeli chcesz wyswietlic ilosc kart odkrytych w swojej kolekcji, napisz iloscOdkrytych");
        System.out.println("Jezeli chcesz wyswietlic karty o danej wartosci, napisz ta wartosc");
        System.out.println("Jezeli chcesz wyswietlic karty o danym kolorze, napisz ten kolor");
        System.out.println("Jezeli chcesz zakonczyc dzialanie programu, napisz zakoncz");
        System.out.println("Jezeli chcesz usunac powtorzenia kart, napisz usun");
        System.out.println("Jezeli chcesz usunac karty zakryte, napisz usunZakryte");
        System.out.println("-------------------------------------------------------------------");

        Scanner in = new Scanner(System.in);

        String instrukcja = "";

        while(!instrukcja.equals("zakoncz")){
            System.out.println("Podaj instrukcje: ");
            instrukcja = in.nextLine();
            if(instrukcja.equals("stworz")){
                stworzListe(list);
                wyswietlListe(list);
            }
            else if(instrukcja.equals("wyswietl")){
                wyswietlListe(list);
            }
            else if(instrukcja.equals("ilosc")){
                System.out.println("Ilosc kart w liscie: " + iloscKart(list));
            }
            else if(instrukcja.equals("iloscZakrytych")){
                System.out.println("Ilosc kart zakrytych w liscie: " + iloscZakrytych(list));
            }
            else if(instrukcja.equals("iloscOdkrytych")){
                System.out.println("Ilosc kart odkrytych w liscie: " + iloscOdkrytych(list));
            }
            else if(instrukcja.equals("as") || instrukcja.equals("2") || instrukcja.equals("3") || instrukcja.equals("4")
                    || instrukcja.equals("5") || instrukcja.equals("6") || instrukcja.equals("7") || instrukcja.equals("8")
                    || instrukcja.equals("9") || instrukcja.equals("10") || instrukcja.equals("walet") || instrukcja.equals("dama")
                    || instrukcja.equals("krol")){
                kartyOWartosci(list, instrukcja);
            }
            else if(instrukcja.equals("karo") || instrukcja.equals("trefl") || instrukcja.equals("kier") || instrukcja.equals("pik")){
                kartyOKolorze(list, instrukcja);
            }
            else if(instrukcja.equals("usun")){
                usunPowtorzenie(list);
                wyswietlListe(list);
            }
            else if(instrukcja.equals("usunZakryte")){
                usunZakryte(list);
                wyswietlListe(list);
            }
            else if(instrukcja.equals("wyczysc")){
                wyczysc(list);
                System.out.println("Wyczyszczono Twoja kolekcje kart");
            }
            else if(instrukcja.equals("")) instrukcja = instrukcja;
            else System.out.println("Podales niepoprawna instrukcje, sprobuj ponownie");
        }
    }
}
