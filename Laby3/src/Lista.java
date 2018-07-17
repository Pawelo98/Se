import java.util.AbstractList;
import java.util.Iterator;

public class Lista<Karta> implements Iterable<Karta> {

    private Element pierwszy = null;

    public Lista(Element pierwszy) {
        this.pierwszy = pierwszy;
    }

    public Lista() {
    }

    private class WewIterator implements Iterator<Karta> {
        Element curElem;

        public WewIterator() {
            curElem = pierwszy;
        }

        @Override
        public boolean hasNext() {
            return curElem != null;
        }

        @Override
        public Karta next() {
            Karta karta = curElem.getKarta();
            curElem = curElem.getElement();
            return karta;
        }
    }

    public Iterator<Karta> iterator() {
        return new WewIterator();
    }

    private class Element {

        public Karta karta;
        public Element nastepnik;

        public Karta getKarta() {
            return karta;
        }

        public void setKarta(Karta karta) {
            this.karta = karta;
        }

        public Element getElement() {
            return nastepnik;
        }

        public void setElement(Element nastepnik) {
            this.nastepnik = nastepnik;
        }

        public Element(Karta karta) {
            this.karta = karta;
        }

        @Override
        public String toString() {
            return karta.toString();
        }
    }

    public boolean usun(Karta karta) {
        if (pierwszy == null) {
            return false;
        }

        if (pierwszy.getKarta().equals(karta)) {
            pierwszy = pierwszy.getElement();
            return true;
        }

        Element curElem = pierwszy;
        while (curElem.getElement() != null && !curElem.getElement().getKarta().equals(karta)) {
            curElem = curElem.getElement();
        }

        if (curElem.getElement() == null) {
            return false;
        }

        curElem.setElement(curElem.getElement().getElement());
        return true;
    }

    public int ilosc() {
        int pos = 0;
        Element actElem = pierwszy;
        while (actElem != null) {
            pos++;
            actElem = actElem.getElement();
        }
        return pos;
    }

    public boolean pusta() {
        return this.pierwszy == null;
    }

    public void wyczysc() {
        pierwszy = null;
    }


    public Element getElement(int index) {
        Element curElem = pierwszy;
        while (index > 0 && curElem != null) {
            index--;
            curElem = curElem.getElement();
        }

        return curElem;
    }

    public boolean dodaj(int index, Karta karta) {
        if (index < 0) {
            return false;
        }

        Element newElem = new Element(karta);
        if (index == 0) {
            newElem.setElement(pierwszy);
            pierwszy = newElem;
            return true;
        }

        Element curElem = this.getElement(index - 1);
        if (curElem == null) {
            return false;
        }

        newElem.setElement(curElem.getElement());
        curElem.setElement(newElem);
        return true;
    }

    public Karta get(int index) {
        Element curElem = getElement(index);
        return curElem == null ? null : curElem.getKarta();
    }

    public Karta usun(int index) {
        if (pierwszy == null) {
            return null;
        }

        if (index == 0) {
            Karta retValue = pierwszy.getKarta();
            pierwszy = pierwszy.getElement();
            return retValue;
        }

        Element curElem = getElement(index - 1);
        if (curElem == null || curElem.getElement() == null) {
            return null;
        }

        Karta retValue = curElem.getElement().getKarta();
        curElem.setElement(curElem.getElement().getElement());
        return retValue;
    }
}


