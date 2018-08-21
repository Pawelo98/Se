package lab;

import java.io.Serializable;

public class Pracownik implements Serializable {

    private int pesel;
    private String imie;
    private String nazwisko;
    private String dataUrodzenia;
    private String stanowisko;
    private double pensja;
    private int staz;
    private double premia;

    public Pracownik(int pesel, String imie, String nazwisko, String dataUrodzenia, String stanowisko,
                     double pensja, int staz) {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.stanowisko = stanowisko;
        this.pensja = pensja;
        this.staz = staz;
        if (staz >= 20) this.premia = pensja * 0.2;
        else if (staz < 10) this.premia = 0;
        else this.premia = pensja * 0.1;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public int getStaz() {
        return staz;
    }

    public void setStaz(int staz) {
        this.staz = staz;
    }

    public double getPremia() {
        return premia;
    }

    public void setPremia() {
        if (staz >= 20) premia = pensja * 0.2;
        else if (staz < 10) premia = 0;
        else premia = pensja * 0.1;
    }

    @Override
    public String toString() {
        return "lab.Pracownik{" +
                "pesel='" + pesel + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", stanowisko='" + stanowisko + '\'' +
                ", pensja=" + pensja +
                ", staz=" + staz +
                ", premia=" + premia +
                '}';
    }
}
