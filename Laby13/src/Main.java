import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {

        ArrayList<Laczenie> listaPolaczen = new ArrayList<>();
        ArrayList<Lampion> listaLampionow = new ArrayList<>();
        int liczbaLampionow = 0;
        int liczbaPolaczen = 0;

        ArrayList<Laczenie> listaPolaczen2 = new ArrayList<>();
        ArrayList<Lampion> listaLampionow2 = new ArrayList<>();
        int liczbaLampionow2 = 0;
        int liczbaPolaczen2 = 0;

        ArrayList<Laczenie> listaPolaczen3 = new ArrayList<>();
        ArrayList<Lampion> listaLampionow3 = new ArrayList<>();
        int liczbaLampionow3 = 0;
        int liczbaPolaczen3 = 0;

        ArrayList<Laczenie> listaPolaczen4 = new ArrayList<>();
        ArrayList<Lampion> listaLampionow4 = new ArrayList<>();
        int liczbaLampionow4 = 0;
        int liczbaPolaczen4 = 0;

        ArrayList<Laczenie> listaPolaczen5 = new ArrayList<>();
        ArrayList<Lampion> listaLampionow5 = new ArrayList<>();
        int liczbaLampionow5 = 0;
        int liczbaPolaczen5 = 0;

        ArrayList<Laczenie> listaPolaczen7 = new ArrayList<>();
        ArrayList<Lampion> listaLampionow7 = new ArrayList<>();
        int liczbaLampionow7 = 0;
        int liczbaPolaczen7 = 0;

        ArrayList<Laczenie> listaPolaczen6 = new ArrayList<>();
        ArrayList<Lampion> listaLampionow6 = new ArrayList<>();
        int liczbaLampionow6 = 0;
        int liczbaPolaczen6 = 0;

        try {
            Scanner odczyt = new Scanner(new File("da1"));
            Scanner odczyt2 = new Scanner(new File("da2"));
            Scanner odczyt3 = new Scanner(new File("da3"));
            Scanner odczyt4 = new Scanner(new File("da4"));
            Scanner odczyt5 = new Scanner(new File("da5"));
            Scanner odczyt6 = new Scanner(new File("da6"));
            Scanner odczyt7 = new Scanner(new File("da7"));

            liczbaLampionow = parseInt(odczyt.next());
            liczbaPolaczen = parseInt(odczyt.next());
            liczbaLampionow2 = parseInt(odczyt2.next());
            liczbaPolaczen2 = parseInt(odczyt2.next());
            liczbaLampionow3 = parseInt(odczyt3.next());
            liczbaPolaczen3 = parseInt(odczyt3.next());
            liczbaLampionow4 = parseInt(odczyt4.next());
            liczbaPolaczen4 = parseInt(odczyt4.next());
            liczbaLampionow5 = parseInt(odczyt5.next());
            liczbaPolaczen5 = parseInt(odczyt5.next());
            liczbaLampionow6 = parseInt(odczyt6.next());
            liczbaPolaczen6 = parseInt(odczyt6.next());
            liczbaLampionow7 = parseInt(odczyt7.next());
            liczbaPolaczen7 = parseInt(odczyt7.next());

            for (int i = 0; i < liczbaPolaczen; i++) {
                int skad = parseInt(odczyt.next());
                int dokad = parseInt(odczyt.next());
                int odleglosc = parseInt(odczyt.next());

                Laczenie tempLacz = new Laczenie(skad, dokad, odleglosc);
                Lampion tempLamp = new Lampion(skad);

                listaPolaczen.add(tempLacz);
                listaLampionow.add(tempLamp);
            }

            for (int i = 0; i < liczbaPolaczen2; i++) {
                int skad2 = parseInt(odczyt2.next());
                int dokad2 = parseInt(odczyt2.next());
                int odleglosc2 = parseInt(odczyt2.next());

                Laczenie tempLacz2 = new Laczenie(skad2, dokad2, odleglosc2);
                Lampion tempLamp2 = new Lampion(skad2);

                listaPolaczen2.add(tempLacz2);
                listaLampionow2.add(tempLamp2);
            }

            for (int i = 0; i < liczbaPolaczen3; i++) {
                int skad3 = parseInt(odczyt3.next());
                int dokad3 = parseInt(odczyt3.next());
                int odleglosc3 = parseInt(odczyt3.next());

                Laczenie tempLacz3 = new Laczenie(skad3, dokad3, odleglosc3);
                Lampion tempLamp3 = new Lampion(skad3);

                listaPolaczen3.add(tempLacz3);
                listaLampionow3.add(tempLamp3);
            }

            for (int i = 0; i < liczbaPolaczen4; i++) {
                int skad4 = parseInt(odczyt4.next());
                int dokad4 = parseInt(odczyt4.next());
                int odleglosc4 = parseInt(odczyt4.next());

                Laczenie tempLacz4 = new Laczenie(skad4, dokad4, odleglosc4);
                Lampion tempLamp4 = new Lampion(skad4);

                listaPolaczen4.add(tempLacz4);
                listaLampionow4.add(tempLamp4);
            }

            for (int i = 0; i < liczbaPolaczen5; i++) {
                int skad = parseInt(odczyt5.next());
                int dokad = parseInt(odczyt5.next());
                int odleglosc = parseInt(odczyt5.next());

                Laczenie tempLacz = new Laczenie(skad, dokad, odleglosc);
                Lampion tempLamp = new Lampion(skad);

                listaPolaczen5.add(tempLacz);
                listaLampionow5.add(tempLamp);
            }

            for (int i = 0; i < liczbaPolaczen6; i++) {
                int skad = parseInt(odczyt6.next());
                int dokad = parseInt(odczyt6.next());
                int odleglosc = parseInt(odczyt6.next());

                Laczenie tempLacz = new Laczenie(skad, dokad, odleglosc);
                Lampion tempLamp = new Lampion(skad);

                listaPolaczen6.add(tempLacz);
                listaLampionow6.add(tempLamp);
            }

            for (int i = 0; i < liczbaPolaczen7; i++) {
                int skad = parseInt(odczyt7.next());
                int dokad = parseInt(odczyt7.next());
                int odleglosc = parseInt(odczyt7.next());

                Laczenie tempLacz = new Laczenie(skad, dokad, odleglosc);
                Lampion tempLamp = new Lampion(skad);

                listaPolaczen7.add(tempLacz);
                listaLampionow7.add(tempLamp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Laczenie laczenie : listaPolaczen) {
            for (Lampion lampion : listaLampionow) {
                if (lampion.getNazwa() == laczenie.getSkad()) {
                    try {
                        lampion.addLaczenie(laczenie);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        for (Laczenie laczenie : listaPolaczen7) {
            for (Lampion lampion : listaLampionow7) {
                if (lampion.getNazwa() == laczenie.getSkad()) {
                    try {
                        lampion.addLaczenie(laczenie);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        for (Laczenie laczenie : listaPolaczen2) {
            for (Lampion lampion : listaLampionow2) {
                if (lampion.getNazwa() == laczenie.getSkad()) {
                    try {
                        lampion.addLaczenie(laczenie);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        for (Laczenie laczenie : listaPolaczen3) {
            for (Lampion lampion : listaLampionow3) {
                if (lampion.getNazwa() == laczenie.getSkad()) {
                    try {
                        lampion.addLaczenie(laczenie);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        for (Laczenie laczenie : listaPolaczen4) {
            for (Lampion lampion : listaLampionow4) {
                if (lampion.getNazwa() == laczenie.getSkad()) {
                    try {
                        lampion.addLaczenie(laczenie);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        for (Laczenie laczenie : listaPolaczen5) {
            for (Lampion lampion : listaLampionow5) {
                if (lampion.getNazwa() == laczenie.getSkad()) {
                    try {
                        lampion.addLaczenie(laczenie);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        for (Laczenie laczenie : listaPolaczen6) {
            for (Lampion lampion : listaLampionow6) {
                if (lampion.getNazwa() == laczenie.getSkad()) {
                    try {
                        lampion.addLaczenie(laczenie);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        listaPolaczen = sortuj(listaPolaczen);
        listaPolaczen2 = sortuj(listaPolaczen2);
        listaPolaczen3 = sortuj(listaPolaczen3);
        listaPolaczen4 = sortuj(listaPolaczen4);
        listaPolaczen5 = sortuj(listaPolaczen5);
        listaPolaczen6 = sortuj(listaPolaczen6);
        listaPolaczen7 = sortuj(listaPolaczen7);

        Graph graph = new Graph(liczbaLampionow, liczbaPolaczen);
        Graph graph2 = new Graph(liczbaLampionow2, liczbaPolaczen2);
        Graph graph3 = new Graph(liczbaLampionow3, liczbaPolaczen3);
        Graph graph4 = new Graph(liczbaLampionow4, liczbaPolaczen4);
        Graph graph5 = new Graph(liczbaLampionow5, liczbaPolaczen5);
        Graph graph6 = new Graph(liczbaLampionow6, liczbaPolaczen6);
        Graph graph7 = new Graph(liczbaLampionow7, liczbaPolaczen7);


        for (int i = 0; i < liczbaPolaczen; i++) {
            graph.laczenie[i].src = listaPolaczen.get(i).getSkad();
            graph.laczenie[i].dest = listaPolaczen.get(i).getDokad();
            graph.laczenie[i].weight = listaPolaczen.get(i).getOdleglosc();
        }

        for (int i = 0; i < liczbaPolaczen2; i++) {
            graph2.laczenie[i].src = listaPolaczen2.get(i).getSkad();
            graph2.laczenie[i].dest = listaPolaczen2.get(i).getDokad();
            graph2.laczenie[i].weight = listaPolaczen2.get(i).getOdleglosc();
        }

        for (int i = 0; i < liczbaPolaczen3; i++) {
            graph3.laczenie[i].src = listaPolaczen3.get(i).getSkad();
            graph3.laczenie[i].dest = listaPolaczen3.get(i).getDokad();
            graph3.laczenie[i].weight = listaPolaczen3.get(i).getOdleglosc();
        }

        for (int i = 0; i < liczbaPolaczen4; i++) {
            graph4.laczenie[i].src = listaPolaczen4.get(i).getSkad();
            graph4.laczenie[i].dest = listaPolaczen4.get(i).getDokad();
            graph4.laczenie[i].weight = listaPolaczen4.get(i).getOdleglosc();
        }
        for (int i = 0; i < liczbaPolaczen5; i++) {
            graph5.laczenie[i].src = listaPolaczen5.get(i).getSkad();
            graph5.laczenie[i].dest = listaPolaczen5.get(i).getDokad();
            graph5.laczenie[i].weight = listaPolaczen5.get(i).getOdleglosc();
        }

        for (int i = 0; i < liczbaPolaczen6; i++) {
            graph6.laczenie[i].src = listaPolaczen6.get(i).getSkad();
            graph6.laczenie[i].dest = listaPolaczen6.get(i).getDokad();
            graph6.laczenie[i].weight = listaPolaczen6.get(i).getOdleglosc();
        }

        for (int i = 0; i < liczbaPolaczen7; i++) {
            graph7.laczenie[i].src = listaPolaczen7.get(i).getSkad();
            graph7.laczenie[i].dest = listaPolaczen7.get(i).getDokad();
            graph7.laczenie[i].weight = listaPolaczen7.get(i).getOdleglosc();
        }

        int dlugoscKabla = graph.kruskal();
        int dlugoscKabla2 = graph2.kruskal();
        int dlugoscKabla3 = graph3.kruskal();
        int dlugoscKabla4 = graph4.kruskal();
        int dlugoscKabla5 = graph5.kruskal();
        int dlugoscKabla6 = graph6.kruskal();
        int dlugoscKabla7 = graph7.kruskal();

        System.out.println("Potrzebna dlugosc kabla z pliku da1 wynosi: " + dlugoscKabla);
        System.out.println("Potrzebna dlugosc kabla z pliku da2 wynosi: " + dlugoscKabla2);
        System.out.println("Potrzebna dlugosc kabla z pliku da3 wynosi: " + dlugoscKabla3);
        System.out.println("Potrzebna dlugosc kabla z pliku da4 wynosi: " + dlugoscKabla4);
        System.out.println("Potrzebna dlugosc kabla z pliku da5 wynosi: " + dlugoscKabla5);
        System.out.println("Potrzebna dlugosc kabla z pliku da6 wynosi: " + dlugoscKabla6);
        System.out.println("Potrzebna dlugosc kabla z pliku da7 wynosi: " + dlugoscKabla7);

    }

    public static ArrayList<Laczenie> sortuj(ArrayList<Laczenie> listaPolaczen) {

        Laczenie[] tab = new Laczenie[listaPolaczen.size()];
        ArrayList<Laczenie> listaPosortowana = new ArrayList<>();
        for (int k = 0; k < listaPolaczen.size(); k++) {
            tab[k] = listaPolaczen.get(k);
        }

        Laczenie temp;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 1; j < (tab.length - i); j++) {
                if (tab[j - 1].getOdleglosc() > tab[j].getOdleglosc()) {
                    temp = tab[j - 1];
                    tab[j - 1] = tab[j];
                    tab[j] = temp;
                }

            }
        }

        for (int l = 0; l < listaPolaczen.size(); l++) {
            listaPosortowana.add(tab[l]);
        }

        return listaPosortowana;
    }

    public static int prim(ArrayList<Laczenie> listaPolaczen, int liczbaLampionow) {
        int dlugoscKabla = 0;
        ArrayList<Laczenie> listaChwilowa = new ArrayList<>();
        ArrayList<Laczenie> listaDrzewa = new ArrayList<>();
        int licznik = 0;
        while (licznik < liczbaLampionow - 1) {
            for (Laczenie laczeniePolaczen : listaPolaczen) {
                boolean skad = false;
                boolean dokad = false;
                int skadPolaczen = laczeniePolaczen.getSkad();
                int dokadPolaczen = laczeniePolaczen.getDokad();

                for (Laczenie laczenieDrzewa : listaDrzewa) {
                    int skadDrzewa = laczenieDrzewa.getSkad();
                    int dokadDrzewa = laczenieDrzewa.getDokad();
                    if (skadPolaczen == skadDrzewa || skadPolaczen == dokadDrzewa) {
                        skad = true;
                    }
                    if (dokadPolaczen == skadDrzewa || dokadPolaczen == dokadDrzewa) {
                        dokad = true;
                    }

                    for (Laczenie laczenieChwilowe : listaChwilowa) {
                        boolean skad2 = false;
                        boolean dokad2 = false;
                        int skadChwilowe = laczenieChwilowe.getSkad();
                        int dokadChwilowe = laczenieChwilowe.getDokad();

                        if (skadChwilowe == skadDrzewa || skadChwilowe == dokadDrzewa) {
                            skad = true;
                        }
                        if (dokadChwilowe == skadDrzewa || dokadChwilowe == dokadDrzewa) {
                            dokad = true;
                        }

                        if (skad2 && dokad2) {
                            listaChwilowa.remove(laczenieChwilowe);
                        }
                    }

                }

                if (((skad == false || dokad == false) && (skad == true || dokad == true)) || (((skadPolaczen == 1) || (dokadPolaczen == 1)) && licznik == 0)) {
                    listaChwilowa.add(laczeniePolaczen);
                }
            }

            sortuj(listaChwilowa);
            listaDrzewa.add(listaChwilowa.get(0));
            dlugoscKabla += listaChwilowa.get(0).getOdleglosc();
            listaChwilowa.remove(0);

            licznik++;
        }

        return dlugoscKabla;
    }

    public static int kruskal(ArrayList <Laczenie> listaPolaczen) {
        int dlugoscKabla = 0;
        ArrayList<Laczenie> listaDrzewa = new ArrayList<>();

        sortuj(listaPolaczen);
        int licznik = 0;
        while (!listaPolaczen.isEmpty()) {
            Laczenie temp = listaPolaczen.get(0);
            boolean skad = false;
            boolean dokad = false;
            int skadPolaczen = temp.getSkad();
            int dokadPolaczen = temp.getDokad();

            for (Laczenie laczenieDrzewa : listaDrzewa) {
                int skadDrzewa = laczenieDrzewa.getSkad();
                int dokadDrzewa = laczenieDrzewa.getDokad();
                if (skadPolaczen == skadDrzewa || skadPolaczen == dokadDrzewa) {
                    skad = true;
                }
                if (dokadPolaczen == skadDrzewa || dokadPolaczen == dokadDrzewa) {
                    dokad = true;
                }

            }

            if ((skad == true && dokad == true)) {
                listaPolaczen.remove(temp);
            } else {
                listaDrzewa.add(temp);
                System.out.println(temp.getOdleglosc());
                dlugoscKabla += temp.getOdleglosc();
                listaPolaczen.remove(temp);
                licznik++;
            }
            sortuj(listaPolaczen);
        }

        return dlugoscKabla;
    }

}
