public class Stos<E> implements Stack<E> {

    private class Element<E> {

        private E wartosc;
        private Element next;

        public Element(E wartosc, Element next) {
            this.wartosc = wartosc;
            this.next = next;
        }

        public Element(E wartosc) {
            this.wartosc = wartosc;
            this.next = next;
        }

        public E getWartosc() {
            return wartosc;
        }

        public void setWartosc(E value) {
            this.wartosc = wartosc;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return this.wartosc.toString();
        }
    }

    private Element head = null;

    public Stos() {
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public E pop() {

        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            E retValue = (E) head.getWartosc();
            head = null;
            return retValue;
        }

        Element current = head;
        Element last = head.next;
        E retValue;
        while (last.getNext() != null) {
            current = current.getNext();
            last = last.getNext();
        }
        retValue = (E) last.getWartosc();

        current.setNext(null);
        return retValue;
    }

    @Override
    public E peek() {

        if (empty()) {
            return null;
        }

        Element temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        return (E) temp.getWartosc();
    }

    @Override
    public E push(E element) {

        Element newElem = new Element(element);
        if (head == null) {
            head = newElem;
            return element;
        }

        Element temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(newElem);
        return element;
    }

}

