public class Wezel {

    int key;
    Wezel left, right, parent = null;
    int ilosc = 0;

    Wezel(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Wezel getLeft() {
        return left;
    }

    public void setLeft(Wezel left) {
        this.left = left;
    }

    public Wezel getRight() {
        return right;
    }

    public void setRight(Wezel right) {
        this.right = right;
    }

    public Wezel getParent() {
        return parent;
    }

    public void setParent(Wezel parent) {
        this.parent = parent;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    @Override
    public String toString() {
        return "Wezel{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                ", parent=" + parent +
                ", ilosc=" + ilosc +
                '}';
    }
}