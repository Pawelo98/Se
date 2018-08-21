public class Laczenie {

    private int skad;
    private int dokad;
    private int odleglosc;

    public Laczenie(int skad, int dokad, int odleglosc) {
        this.skad = skad;
        this.dokad = dokad;
        this.odleglosc = odleglosc;
    }

    public int getSkad() {
        return skad;
    }

    public void setSkad(int skad) {
        this.skad = skad;
    }

    public int getDokad() {
        return dokad;
    }

    public void setDokad(int dokad) {
        this.dokad = dokad;
    }

    public int getOdleglosc() {
        return odleglosc;
    }

    public void setOdleglosc(int odleglosc) {
        this.odleglosc = odleglosc;
    }

    @Override
    public String toString() {
        return "Laczenie{" +
                "skad=" + skad +
                ", dokad=" + dokad +
                ", odleglosc=" + odleglosc +
                '}';
    }
}
