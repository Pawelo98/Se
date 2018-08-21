public class WezelHuffmana {
    private int data;
    private char c;
    private WezelHuffmana left;
    private WezelHuffmana right;

    public WezelHuffmana() {
    }

    public WezelHuffmana(char c, int data) {
        this.c = c;
        this.data = data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public WezelHuffmana getLeft() {
        return left;
    }

    public void setLeft(WezelHuffmana left) {
        this.left = left;
    }

    public WezelHuffmana getRight() {
        return right;
    }

    public void setRight(WezelHuffmana right) {
        this.right = right;

    }

    @Override
    public String toString() {
        return this.c + " - " + this.data;
    }
}
