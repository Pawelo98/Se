
public class Kolejka{
    private class Element {
        private WezelHuffmana value;
        private Element next;

        public Element(WezelHuffmana value) {
            this.value = value;
        }

        public WezelHuffmana getValue() {
            return value;
        }

        public void setValue(WezelHuffmana value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    Element head = null;

    public Kolejka() {
    }

    public void enqueue(WezelHuffmana node) {
        Element current = this.head;
        if (current == null || node.getData() <= current.getValue().getData()) {
            Element newElement = new Element(node);
            newElement.setNext(current);
            this.head = newElement;
            return;
        }

        while (current.getNext() != null && current.getNext().getValue().getData() <= node.getData()) {
            current = current.getNext();
        }

        Element newElement = new Element(node);
        newElement.setNext(current.getNext());
        current.setNext(newElement);
    }

    public WezelHuffmana dequeue() {
        WezelHuffmana node = this.head.getValue();
        this.head = this.head.getNext();
        return node;
    }

    public boolean isEmpty() {
        return head==null;
    }

    public void clear() {
        this.head = null;
    }

    public int size() {
        int pos = 0;
        Element current = head;
        while (current!=null) {
            pos++;
            current = current.getNext();
        }

        return pos;
    }


    private Element getElement(int index) {
        Element current = head;
        while (index>0 && current!=null) {
            index--;
            current = current.getNext();
        }

        return current;
    }

    public void insert(WezelHuffmana element) {
        Element newElem = new Element(element);
        if(head==null) {
            head = newElem;
        } else {
            Element current = head;
            while(current.getNext()!=null) {
                current = current.getNext();
            }
            current.setNext(newElem);
        }
    }

    public void remove() {
        if(head!=null) {
            head = head.getNext();
        }
    }

    public WezelHuffmana get(int index) {
        Element current = head;
        while (index>0 && current!=null) {
            index--;
            current = current.getNext();
        }

        return current.getValue();
    }

    public WezelHuffmana get() {
        return null;
    }

    public WezelHuffmana getFirst() {
        return head.getValue();
    }
}
