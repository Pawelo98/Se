import java.util.ArrayList;

public class Stos<E> implements Stack<E> {

    private ArrayList<E> arrayList;
    private int index;

    public Stos() {
        arrayList = new ArrayList<>();
        index = 0;
    }

    @Override
    public boolean empty() {
        return index == 0;
    }

    @Override
    public E push(E value) {
        arrayList.add(value);
        index++;
        return value;
    }

    @Override
    public E pop() {
        if (!arrayList.isEmpty()) {
            E value = arrayList.remove(--index);
            return value;
        }

        return null;
    }

    @Override
    public E peek() {
        if (empty()) {
            return null;
        }

        return arrayList.get(index - 1);
    }

}

