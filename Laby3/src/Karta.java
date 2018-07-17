public class Karta implements Comparable<Karta>{

    private int wartosc;
    private int kolor;
    private boolean znacznik;

    public Karta(int wartosc, int kolor, boolean znacznik) {
        this.wartosc = wartosc;
        this.kolor = kolor;
        this.znacznik = znacznik;
    }

    public Karta(){
        this.wartosc = 1;
        this.kolor = 0;
        this.znacznik = true;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public boolean getZnacznik(){
        return znacznik;
    }

    public void setZnacznik(boolean znacznik){
        this.znacznik = znacznik;
    }

    public int getKolor() {
        return kolor;
    }

    public void setKolor(int kolor) {
        this.kolor = kolor;
    }

    @Override
    public int compareTo(Karta karta) {

        if(wartosc == karta.wartosc) {
            if(kolor > karta.kolor) return 1;
            else if(kolor == karta.kolor) return 0;
            else return -1;
        }
        else if(wartosc > karta.wartosc) return 1;
        else return -1;
    }

    @Override
    public String toString() {
        return "Karta{" +
                "wartosc=" + wartosc +
                ", kolor=" + kolor +
                '}';
    }
}
