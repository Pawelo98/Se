import java.util.ArrayList;

public class Wezel {

    Wezel left, right, parent = null;
    ArrayList<Integer> nrWiersza = null;
    String klucz;

    public Wezel(int nrWiersza, String klucz) {
        this.klucz = klucz;
        this.nrWiersza = new ArrayList<>();
        this.nrWiersza.add(nrWiersza);
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

    public ArrayList<Integer> getNrWiersza() {
        return nrWiersza;
    }

    public void setNrWiersza(ArrayList<Integer> nrWiersza) {
        this.nrWiersza = nrWiersza;
    }

    public String getKlucz() {
        return klucz;
    }

    public void setKlucz(String klucz) {
        this.klucz = klucz;
    }

    @Override
    public String toString() {
        return
//               "Wezel{" +
//                "left=" + left +
//                ", right=" + right +
//                ", parent=" + parent +
//                ", nrWiersza=" + nrWiersza +
                "Klucz=" + klucz;
//                '}';
    }

}
