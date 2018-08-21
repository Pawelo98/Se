public class Firma {

    private String nazwaFirmy;
    private Kolejka<Magazyn> kolejkaMagazynu = new Kolejka<>();

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    public Kolejka<Magazyn> getKolejkaMagazynu() {
        return kolejkaMagazynu;
    }

    public void setKolejkaMagazynu(Kolejka<Magazyn> kolejkaMagazynu) {
        this.kolejkaMagazynu = kolejkaMagazynu;
    }

    public void dodaj(Magazyn magazyn){
        kolejkaMagazynu.insert(magazyn);
    }

    public void liczKwote(){

        double kwotaFirmy = 0.0;

        while(!kolejkaMagazynu.isEmpty()) {

            kwotaFirmy += kolejkaMagazynu.get(0).liczKwote();
            kolejkaMagazynu.remove();
        }

        System.out.printf("%s%s%s%.2f%s", "Zlecenie zrealizowane dla firmy ", nazwaFirmy, ", przychody firmy = ", kwotaFirmy, "\n");
    }
}
