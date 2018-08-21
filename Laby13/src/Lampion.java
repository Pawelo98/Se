import java.util.ArrayList;

public class Lampion {

    private int nazwa;
    private boolean color;
    private ArrayList<Laczenie> listaKrawedzi;

    public Lampion(int nazwa, Laczenie laczenie) {
        this.nazwa = nazwa;
        this.listaKrawedzi.add(laczenie);
        this.color = false;
    }

    public Lampion(int nazwa) {
        this.nazwa = nazwa;
        this.listaKrawedzi = new ArrayList<>();
        this.color = false;
    }

    public int getNazwa() {
        return nazwa;
    }

    public void setNazwa(int nazwa) {
        this.nazwa = nazwa;
    }

    public ArrayList<Laczenie> getListaKrawedzi() {
        return listaKrawedzi;
    }

    public void setListaKrawedzi(ArrayList<Laczenie> listaKrawedzi) {
        this.listaKrawedzi = listaKrawedzi;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public void addLaczenie(Laczenie laczenie){
        listaKrawedzi.add(laczenie);
    }

    @Override
    public String toString() {
        return "Lampion{" +
                "nazwa=" + nazwa +
                ", listaKrawedzi=" + listaKrawedzi +
                '}';
    }
}
