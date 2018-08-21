public class Proces implements Comparable<Proces>{

    int numerIdentyfikacyjny;
    double czasTrwania;
    double czasNadejscia = 0.0;
    double czasPozostaly;

    public Proces(int numerIdentyfikacyjny, double czasTrwania) {
        this.numerIdentyfikacyjny = numerIdentyfikacyjny;
        this.czasTrwania = czasTrwania;
        this.czasNadejscia = 0.0;
        this.czasPozostaly = czasTrwania;
    }

    public int getNumerIdentyfikacyjny() {
        return numerIdentyfikacyjny;
    }

    public void setNumerIdentyfikacyjny(int numerIdentyfikacyjny) {
        this.numerIdentyfikacyjny = numerIdentyfikacyjny;
    }

    public double getCzasTrwania() {
        return czasTrwania;
    }

    public void setCzasTrwania(double czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    public double getCzasNadejscia() {
        return czasNadejscia;
    }

    public void setCzasNadejscia(double czasNadejscia) {
        this.czasNadejscia = czasNadejscia;
    }

    @Override
    public int compareTo(Proces proces) {

        if(czasTrwania == proces.czasTrwania) {
             if(numerIdentyfikacyjny > proces.numerIdentyfikacyjny) return 1;
                     else return -1;
        }
        else if(czasTrwania > proces.czasTrwania) return 1;
        else return -1;
    }
}
