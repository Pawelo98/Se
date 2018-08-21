import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){

        ArrayList<Laczenia> listaKrawedzi = new ArrayList<>();
        ArrayList<Wezel> listaWierzcholkow = new ArrayList<>();

        Wezel temp1 = new Wezel("Wroclaw");
        listaWierzcholkow.add(temp1);
        Wezel temp2 = new Wezel("Olawa");
        listaWierzcholkow.add(temp2);
        Wezel temp3 = new Wezel("Brzeg");
        listaWierzcholkow.add(temp3);
        Wezel temp4 = new Wezel("Nysa");
        listaWierzcholkow.add(temp4);
        Wezel temp5 = new Wezel("Opole");
        listaWierzcholkow.add(temp5);

        Laczenia laczenia1 = new Laczenia("Wroclaw", "Olawa", 10.00);
        listaKrawedzi.add(laczenia1);
        Laczenia laczenia2 = new Laczenia("Wroclaw", "Nysa", 30.00);
        listaKrawedzi.add(laczenia2);
        Laczenia laczenia3 = new Laczenia("Wroclaw", "Opole", 100.00);
        listaKrawedzi.add(laczenia3);
        Laczenia laczenia4 = new Laczenia("Olawa", "Brzeg", 50.00);
        listaKrawedzi.add(laczenia4);
        Laczenia laczenia5 = new Laczenia("Brzeg", "Opole", 10.00);
        listaKrawedzi.add(laczenia5);
        Laczenia laczenia6 = new Laczenia("Nysa", "Brzeg", 20.00);
        listaKrawedzi.add(laczenia6);
        Laczenia laczenia7 = new Laczenia("Nysa", "Opole", 60.00);
        listaKrawedzi.add(laczenia7);

        for(Laczenia laczenia : listaKrawedzi) {
            for (Wezel wezel : listaWierzcholkow) {
                if (wezel.getNazwa() == laczenia.getSkad()) {
                    try {
                        wezel.addKrawedz(laczenia);
                    }catch(NullPointerException e){ e.printStackTrace(); }
                }
            }
        }

        for(Wezel wezel : listaWierzcholkow) {
            System.out.println("Polaczenia z miasta " + wezel.getNazwa() + ":");
            wezel.getNeighbourhoodList();
        }

        //printCities(temp1, listaWierzcholkow, listaKrawedzi);

    }

    public static void printCities(Wezel wezel, ArrayList <Wezel> listaWierzcholkow, ArrayList <Laczenia> listaKrawedzi) {
        PriorityQueue minHeap = new PriorityQueue();
        HashMap<Wezel, Double> localMap = new HashMap();
        for (Wezel w : listaWierzcholkow) {
            localMap.put(w, Double.MAX_VALUE);
        }

        localMap.put(wezel, 0.0);
        minHeap.enqueue(new Laczenia("", wezel.getNazwa(), 0));

        while (minHeap.size() > 0) {
            Laczenia u = minHeap.dequeue();
            PriorityQueue uQueue = getQueue(u.getDokad(), listaKrawedzi);
            while (uQueue.size() > 0) {
                Laczenia v = uQueue.dequeue();
                Wezel temp = null;
                for(Wezel wezel2 : listaWierzcholkow) {
                    if(wezel.getNazwa().equals(v.getDokad()))
                    {
                        temp=wezel;
                    }
                }
                if (localMap.get(v.getDokad()) > localMap.get(u.getDokad()) + v.getOdleglosc()) {
                    localMap.put(temp, localMap.get(u.getDokad()) + v.getOdleglosc());
                    minHeap.enqueue(v);
                }
            }
        }

        System.out.println("\nMozliwe cele do osiagniecia: " + wezel.getNazwa() + ":");
        for (int i=0; i<localMap.size(); i++) {
            if (0 < localMap.get(wezel.getNazwa()) && localMap.get(wezel.getNazwa()) < Integer.MAX_VALUE) {
                System.out.println(wezel.getNazwa() + " - " + localMap.get(wezel.getNazwa()));
            }
        }
    }

    private static PriorityQueue getQueue(String city, ArrayList <Laczenia> listaKrawedzi) {
        PriorityQueue queue = new PriorityQueue();
        for (Laczenia l : listaKrawedzi) {
            queue.enqueue(l);
        }

        return queue;
    }

}
