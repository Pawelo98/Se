import java.util.NoSuchElementException;

public class Firma<Pracownik> implements Iterator<Pracownik> {

    private Pracownik tab[];
    private int poz = 0;

    public Firma(Pracownik tablica[]) {
        tab = tablica;
    }

    @Override
    public boolean jestWZakresie() {
        return (poz<tab.length)&&(poz>=0);
    }

    @Override
    public void nastepny() throws NoSuchElementException {
        if (jestWZakresie())
            poz++;
        else
            throw new NoSuchElementException();
    }

    @Override
    public void poprzedni() throws NoSuchElementException {
        if (jestWZakresie())
            poz--;
        else
            throw new NoSuchElementException();
    }

    @Override
    public void pierwszy(){
        poz = 0;
    }

    @Override
    public void ostatni(){
        poz = tab.length-1;
    }

    @Override
    public Pracownik elementBiezacy() {
        return tab[poz];
    }
}
