import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Drzewo drzewo = new Drzewo();

        for(int i=0; i<20; i++){
            int tab [] = new int[20];
            tab[i] = random.nextInt(20);
            System.out.print(tab[i] + " ");
            drzewo.insert(tab[i]);
        }
        System.out.println();

        System.out.println("Ilosc wezlow drzewa wynosi: " + drzewo.iloscWezlow());
        System.out.println("Suma kluczy drzewa wynosi: " + drzewo.sumaKluczy());

    }
}
