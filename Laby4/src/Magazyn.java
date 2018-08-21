import java.util.Queue;

public class Magazyn<E> {

    public Kolejka<Klient> kolejkaKlientow = new Kolejka<>();

    public Magazyn() {
    }

    public Kolejka<Klient> getKolejkaKlientow() {
        return kolejkaKlientow;
    }

    public void dodajKlienta(Klient klient) {
        kolejkaKlientow.insert(klient);
    }

    public double liczKwote() {
        String nazwisko = "";
        double kwota = 0;
        double sumaKwot = 0.0;

        while(!kolejkaKlientow.isEmpty()) {

            nazwisko = kolejkaKlientow.getFirst().getNazwaKlienta();
            Kolejka<Zamowienie> kolejkaZamowien = kolejkaKlientow.getFirst().getKolejkaZamowien();

            while (!kolejkaZamowien.isEmpty()) {
                Zamowienie zamowienie = kolejkaZamowien.getFirst();
                kwota += zamowienie.getCenaJednostkowa()*zamowienie.getLiczbaSztuk();
                System.out.println(zamowienie);
                kolejkaZamowien.remove();
            }

            System.out.println();
            System.out.printf("%s%s%s%.2f%s", "Zlecenie zrealizowane dla klienta ", nazwisko, ", kwota do zaplaty = ", kwota, "\n");
            System.out.println();
            kolejkaKlientow.remove();
            sumaKwot += kwota;
            kwota = 0;
        }

        return sumaKwot;
    }

    @Override
    public String toString() {
        return "Magazyn{" +
                "kolejkaMagazynu = " + kolejkaKlientow +
                '}';
    }
}
