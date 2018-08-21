public class Klient {

    private String nazwaKlienta;
    private Kolejka<Zamowienie> kolejkaZamowien = new Kolejka<>();

    public Klient(String nazwaKlienta) {
        this.nazwaKlienta = nazwaKlienta;
    }

    public String getNazwaKlienta() {
        return nazwaKlienta;
    }

    public void setNazwaKlienta(String nazwaKlienta) {
        this.nazwaKlienta = nazwaKlienta;
    }

    public Kolejka<Zamowienie> getKolejkaZamowien() {
        return kolejkaZamowien;
    }

    public void setKolejkaZamowien(Kolejka<Zamowienie> kolejkaZamowien) {
        this.kolejkaZamowien = kolejkaZamowien;
    }

    public void dodajKlienta(String nazwa, int ilosc, double cena) {
        kolejkaZamowien.insert(new Zamowienie(nazwa, ilosc, cena));
    }

    @Override
    public String toString() {
        return "Klient{" +
                "nazwaKlienta='" + nazwaKlienta + '\'' +
                ", kolejkaZamowien=" + kolejkaZamowien +
                '}';
    }
}
