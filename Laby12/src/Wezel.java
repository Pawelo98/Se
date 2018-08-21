import java.util.ArrayList;

public class Wezel {

    private String nazwa;
    private ArrayList<Laczenia> listaKrawedzi;

    public Wezel(String nazwa) {
        this.nazwa = nazwa;
        listaKrawedzi = new ArrayList<Laczenia>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public ArrayList<Laczenia> getListaKrawedzi() {
        return listaKrawedzi;
    }

    public void setListaKrawedzi(ArrayList<Laczenia> listaKrawedzi) {
        this.listaKrawedzi = listaKrawedzi;
    }

    public void addKrawedz(Laczenia laczenia){
        listaKrawedzi.add(laczenia);
    }

    public void getNeighbourhoodList(){
        for(Laczenia laczenia : listaKrawedzi){
            System.out.println("-polaczenie do: " + laczenia.getDokad() + " o odleglosci " + laczenia.getOdleglosc());
        }
    }

    @Override
    public String toString() {
        return "\nWezel{" +
                "nazwa='" + nazwa + '\'' +
                ", listaKrawedzi=" + listaKrawedzi +
                '}';
    }
}
