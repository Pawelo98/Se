import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Drzewo {

    private Wezel korzen;

    public Drzewo() {
        this.korzen = null;
    }

    public Wezel getKorzen() {
        return korzen;
    }

    public void setKorzen(Wezel wezel) {
        this.korzen = wezel;
    }

    public boolean stworz(String plikTekstowy) throws Exception {

        FileReader fileReader = new FileReader(plikTekstowy);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String operation;
        int iter = 0;

        while ((operation = bufferedReader.readLine()) != null) {

            iter++;

            operation = operation.replace(".", "");
            operation = operation.replace(",", "");
            operation = operation.replace("-", "");

            StringTokenizer st = new StringTokenizer(operation);
            while (st.hasMoreTokens()) {
                String klucz = st.nextToken();
                insert(klucz, iter);
            }
        }

        bufferedReader.close();
        return true;
    }

    public boolean insert(String klucz, int iter) {

        if (this.korzen == null) {
            this.korzen = new Wezel(iter, klucz);
        } else

        {
            Wezel pomocniczy = search(klucz);
            if (pomocniczy != null) {
                pomocniczy.getNrWiersza().add(iter);
            } else {
                Wezel obecny = this.korzen;
                while (obecny != null) {
                    if (klucz.compareTo(obecny.getKlucz()) > 0) {
                        if (obecny.getRight() != null) {
                            obecny = obecny.getRight();
                        } else {
                            Wezel nastepny = new Wezel(iter, klucz);
                            obecny.setRight(nastepny);
                            nastepny.setParent(obecny);
                            return true;
                        }
                    } else if (klucz.compareTo(obecny.getKlucz()) < 0) {
                        if (obecny.getLeft() != null) {
                            obecny = obecny.getLeft();
                        } else {
                            Wezel nastepny = new Wezel(iter, klucz);
                            obecny.setLeft(nastepny);
                            nastepny.setParent(obecny);
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean delete(String klucz) {
        Wezel wezel = search(klucz);
        if (wezel != null) {
            if (wezel.getLeft() == null && wezel.getRight() == null) {
                if (wezel.getParent().getLeft() == wezel) {
                    wezel.getParent().setLeft(null);
                    return true;
                } else wezel.getParent().setRight(null);
                return true;
            } else if (wezel.getLeft() == null || wezel.getRight() == null) {
                if (wezel.getLeft() == null && wezel.getParent().getLeft() == wezel) {
                    wezel.getParent().setLeft(wezel.getRight());
                    return true;
                } else if (wezel.getRight() == null && wezel.getParent().getLeft() == wezel) {
                    wezel.getParent().setLeft(wezel.getLeft());
                    return true;
                } else if (wezel.getLeft() == null && wezel.getParent().getRight() == wezel) {
                    wezel.getParent().setRight(wezel.getRight());
                    return true;
                } else {
                    wezel.getParent().setRight(wezel.getLeft());
                    return true;
                }
            } else {
                Wezel pomocniczy = successor(wezel);
                pomocniczy.setParent(wezel.getParent());
                pomocniczy.setLeft(wezel.getLeft());
                pomocniczy.setRight(wezel.getRight());
                if (wezel.getParent().getLeft() == wezel) {
                    wezel.getParent().setLeft(pomocniczy);
                    return true;
                } else wezel.getParent().setRight(pomocniczy);
                return true;
            }
        }
        return false;
    }
    public Wezel successor(Wezel wezel) {

        if (wezel.right != null) {
            return minValue(wezel.right);
        }

        Wezel p = wezel.parent;
        while (p != null && wezel == p.right) {
            wezel = p;
            p = p.parent;
        }
        return p;
    }

    public Wezel minValue(Wezel wezel) {
        Wezel current = wezel;

        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Wezel search(String klucz)
    {
        Wezel wezel = this.korzen;
        while (wezel!=null) {
            if(wezel.getKlucz().equals(klucz)) {
                return wezel;
            } else {
                if(klucz.compareTo(wezel.getKlucz())<0) {
                    wezel = wezel.getLeft();
                } else {
                    wezel = wezel.getRight();
                }
            }
        }

        return null;
    }

    void inorder() {
        inorderRec(korzen);
    }

    void inorderRec(Wezel korzen) {
        if (korzen != null) {
            inorderRec(korzen.getLeft());
            System.out.println(korzen.getKlucz() + "\t" + korzen.getNrWiersza());
            inorderRec(korzen.getRight());
        }
    }

    void przejscieWszerz() {
        Kolejka<Wezel> queue = new Kolejka<>();
        queue.insert(this.korzen);
        while (!queue.isEmpty()) {
            Wezel wezel = queue.getFirst();
            queue.remove();
            System.out.println(wezel.getKlucz());
            if (wezel.getLeft() != null) {
                queue.insert(wezel.getLeft());
            }
            if (wezel.getRight() != null) {
                queue.insert(wezel.getRight());
            }
        }
    }

    int wysokosc(Wezel wezel) {
        if (wezel == null)
            return 0;
        else {
            int lDepth = wysokosc(wezel.left);
            int rDepth = wysokosc(wezel.right);

            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    int iloscLisci() {
        return iloscLisci(korzen);
    }

    int iloscLisci(Wezel wezel) {
        if (wezel == null)
            return 0;
        if (wezel.left == null && wezel.right == null)
            return 1;
        else
            return iloscLisci(wezel.left) + iloscLisci(wezel.right);
    }

    public int iloscWezlow() {
        return iloscWezlow(korzen);
    }

    private int iloscWezlow(Wezel current) {
        if (current == null) return 0;
        return 1 + iloscWezlow(current.left) + iloscWezlow(current.right);
    }

}
