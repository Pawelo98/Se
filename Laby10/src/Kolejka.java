import java.util.AbstractList;

public class Kolejka<E> extends AbstractList<E> implements Queue<E>  {
    private class Element {
        private E value;
        private Element next;

        public Element(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
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

    @Override
    public void insert(E element) {
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


    @Override
    public void remove() {
        if(head!=null) {
            head = head.getNext();
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public E get(int index) {
        Element current = head;
        while (index>0 && current!=null) {
            index--;
            current = current.getNext();
        }

        return current.getValue();
    }

    public E get() {
        return null;
    }

    public E getFirst() {
        return head.getValue();
    }
}
