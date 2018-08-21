public class Laczenia {

    private String skad;
    private String dokad;
    private double odleglosc;

    public Laczenia(String skad, String dokad, double odleglosc) {
        this.skad = skad;
        this.dokad = dokad;
        this.odleglosc = odleglosc;
    }

    public String getSkad() {
        return skad;
    }

    public void setSkad(String skad) {
        this.skad = skad;
    }

    public String getDokad() {
        return dokad;
    }

    public void setDokad(String dokad) {
        this.dokad = dokad;
    }

    public double getOdleglosc() {
        return odleglosc;
    }

    public void setOdleglosc(double odleglosc) {
        this.odleglosc = odleglosc;
    }

    @Override
    public String toString() {
        return "\nLaczenia{" +
                "skad=" + skad +
                ", dokad=" + dokad +
                ", odleglosc=" + odleglosc +
                '}';
    }
}
