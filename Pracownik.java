import java.io.Serializable;

public class Pracownik implements Serializable {

    String imie;
    String nazwisko;
    int staz;
    String pesel;
    double pensja;

    public Pracownik()
    {
        this.imie = "brak";
        this.nazwisko = "brak";
        this.staz = 0;
        this.pesel = "00000000000";
        this.pensja = 0.00;
    }

    public Pracownik(String imie, String nazwisko, int staz, String pesel, double pensja)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.staz = staz;
        this.pesel = pesel;
        this.pensja = pensja;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getStaz() {
        return staz;
    }

    public String getPesel() {
        return pesel;
    }

    public double getPensja() {
        return pensja;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setStaz(int staz) {
        this.staz = staz;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public void wyswietl()
    {
        System.out.printf("%15s %15s %-10d %11d %-10.2f", this.nazwisko, this.imie, this.staz, this.pesel, this.pensja);
    }

    @Override
    public String toString()
    {
        return String.format("%-15s %-15s %10d %11s %10.2f",
                this.nazwisko, this.imie, this.staz, this.pesel, this.pensja);
    }
}
