public class Wezel {

    String key;
    Wezel left, right, parent = null;

    Wezel(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
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

    @Override
    public String toString() {
        return "Wezel{" +
                "key='" + key + '\'' +
                ", left=" + left +
                ", right=" + right +
                ", parent=" + parent +
                '}';
    }
}