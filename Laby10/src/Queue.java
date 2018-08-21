public interface Queue<E> {
    void insert(E element);
    void remove();
    boolean isEmpty();
    boolean isFull();
}