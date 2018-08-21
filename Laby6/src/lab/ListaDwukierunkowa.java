package lab;

public class ListaDwukierunkowa<Pracownik> {

    private class Element {
        private Pracownik pracownik;
        private Element next;
        private Element previous;

        public Element(Pracownik pracownik) {
            this.pracownik = pracownik;
        }

        public Pracownik getPracownik() {
            return this.pracownik;
        }

        public void setPracownik(Pracownik pracownik) {
            this.pracownik = pracownik;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element getPrevious() {
            return previous;
        }

        public void setPrevious(Element previous) {
            this.previous = previous;
        }

        public void insertAfter(Element elem){
            elem.setNext(this.getNext());
            elem.setPrevious(this);
            this.getNext().setPrevious(elem);
            this.setNext(elem);
        }

        public void insertBefore(Element elem){
            elem.setNext(this);
            elem.setPrevious(this.getPrevious());
            this.getPrevious().setNext(elem);
            this.setPrevious(elem);
        }

        public void remove(){
            this.getNext().setPrevious(this.getPrevious());
            this.getPrevious().setNext(this.getNext());
        }
    }

    Element sentinel;

    public ListaDwukierunkowa() {
        sentinel = new Element(null);
        sentinel.setNext(sentinel);
        sentinel.setPrevious(sentinel);
    }

    public boolean isEmpty() {
        return sentinel.getNext() == null;
    }

    public void clear() {
        sentinel.setNext(null);
        sentinel.setPrevious(null);
    }

    public void wyswietl() {
        Element temp = sentinel.getNext();
        boolean exists = false;
        System.out.println("Lista pracownikow: ");
        while (temp != null) {
            System.out.println(temp.getPracownik());
            temp = temp.getNext();
            exists = true;
        }
        if(!exists) System.out.println("Baza pracownikow jest pusta");
    }

    public void wyswietl(int index) {
        Element temp = sentinel.getNext();
        int iter = 0;
        System.out.println("lab.Pracownik o indeksie " + index + ": ");
        while (temp != null) {
            if(index==iter) System.out.println(temp.getPracownik());
            temp = temp.getNext();
            iter++;
        }
    }

    public Pracownik get(int index) {
        Element temp = sentinel.getNext();
        int iter = 0;
        while (temp != null) {
            if(index==iter) return temp.getPracownik();
            temp = temp.getNext();
            iter++;
        }
        return null;
    }

    public int length() {
        Element temp = sentinel.getNext();
        int i = 0;
        while (temp != null) {
            i++;
            temp = temp.getNext();
        }
        return i;
    }

    public boolean add(Pracownik pracownik) {

        Element curElem = sentinel.getNext();

        while (curElem != sentinel && curElem.getPracownik().getPesel().compareTo(pracownik.getPesel()) < 0) {
            curElem = curElem.getNext();
        }

        if (curElem == sentinel) {
            curElem.insertBefore(new Element(pracownik));
            return true;
        }

        if (curElem.getPracownik().getPesel() == pracownik.getPesel()) {
            System.out.println("Osoba o takim numerze PESEL już istnieje.");
            return false;
        } else {
            curElem.insertBefore(new Element(pracownik));
        }

        return true;

    }

    public Element getElement(String pesel) {
        Element curElem = sentinel.getNext();
        while ((curElem != sentinel) && (!pesel.equals(curElem.getPracownik().getPesel()))) {
            curElem = curElem.getNext();
        }

        return curElem;
    }

    public boolean usun(String pesel){

        Element elem = getElement(pesel);

        if(elem==null) {
            return false;
        }

        elem.remove();
        return true;

    }


}
