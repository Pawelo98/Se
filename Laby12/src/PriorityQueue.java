
public class PriorityQueue {
    private class Element {
        private Laczenia value;
        private Element next;

        public Element(Laczenia value) {
            this.value = value;
        }

        public Laczenia getValue() {
            return value;
        }

        public void setValue(Laczenia value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    private Element first;

    public PriorityQueue() {
    }

    public void enqueue(Laczenia destination) {
        Element current = this.first;
        if (current == null || destination.getOdleglosc() <= current.getValue().getOdleglosc()) {
            Element newElement = new Element(destination);
            newElement.setNext(current);
            this.first = newElement;
            return;
        }

        while (current.getNext() != null && current.getNext().getValue().getOdleglosc() <= destination.getOdleglosc()) {
            current = current.getNext();
        }

        Element newElement = new Element(destination);
        newElement.setNext(current.getNext());
        current.setNext(newElement);
    }

    public void print() {
        Element current = this.first;
        while (current!=null) {
            System.out.print(current.getValue() + ", ");
            current = current.getNext();
        }
    }

    public Laczenia dequeue() {
        Laczenia destination = this.first.getValue();
        this.first = this.first.getNext();
        return destination;
    }

    public int size() {
        int count = 0;
        Element current = this.first;
        while (current!=null) {
            current = current.getNext();
            count++;
        }

        return count;
    }

}
