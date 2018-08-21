import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String[] nazwaKlienta = {"Kowalski", "Nowak", "Dabrowski", "Wisniewski", "Polak", "Wojcik", "Janic", "Boman"};
        double[] cenaProduktu = {12.49, 4.99, 6.29, 12.79, 2.99, 3.49, 25.49};
        String[] nazwaProduktu = {"kawa", "czekolada", "maka", "ryz", "chleb", "mleko", "herbata"};
        String[] nazwaMagazynu = {"Kamienna Gora", "Wroclaw", "Jelenia Gora"};
        String nazwaFirmy = "Sprzedajemy!";

        Firma firma = new Firma();

        firma.setNazwaFirmy(nazwaFirmy);

        for (int k = 0; k < nazwaMagazynu.length; k++) {

            Magazyn magazyn = new Magazyn();

            Random rand = new Random();
            int klientow = rand.nextInt(5);

            for (int i = 0; i < klientow + 1; i++) {

                Random random = new Random();
                int ilosc = random.nextInt(5);
                int index1 = random.nextInt(nazwaKlienta.length);

                Klient klient = new Klient(nazwaKlienta[index1]);

                for (int j = 0; j < ilosc + 1; j++) {
                    int index = random.nextInt(nazwaProduktu.length);
                    klient.dodajKlienta(nazwaProduktu[index], random.nextInt(5) + 1, cenaProduktu[index]);
                }

                magazyn.dodajKlienta(klient);
            }
            firma.dodaj(magazyn);

            System.out.println();
        }

        firma.liczKwote();
    }
}