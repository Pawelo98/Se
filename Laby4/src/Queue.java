public interface Queue <E> {

    void insert(E element);
    boolean isEmpty();
    boolean isFull();
    void remove();
}
