import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int iloscProcesow = 1000;

        System.out.println("Podaj ilosc pracujacych procesorow: ");
        int n = scanner.nextInt();

        System.out.println("Podaj maksymalny prog procesorow w %: ");
        double p = scanner.nextDouble();

        System.out.println("Podaj minimalny prog procesorow w %: ");
        double r = scanner.nextDouble();

        System.out.println("Podaj maksymalna ilosc prob losowania procesora: ");
        int z = scanner.nextInt();

        double[] tab1 = new double[n]; //tablica obciazen procesorow
        double[] tab2 = new double[n];
        double[] tab3 = new double[n];

        for (int i = 0; i < n; i++) {
            tab1[i] = 0;
            tab2[i] = 0;
            tab3[i] = 0;
        }

        strategia1(iloscProcesow, n, p, z, tab1);
        strategia2(iloscProcesow, n, p, tab2);
    }

    public static void strategia1(int ilosc, int n, double p, int z, double[] tab) {
        for (int i = 0; i < ilosc; i++) {
            boolean wykonany = false;
            int licz = 0;
            int los;
            Random random = new Random();

            while (!wykonany && licz < z) {
                los = random.nextInt(n - 1) + 1;
                if (tab[los] < p) {
                    tab[los] += random.nextDouble() * 10;
                    wykonany = true;
                } else {
                    licz++;
                }
            }

            if (!wykonany) {
                tab[0] += random.nextDouble() * 10;
            }
        }
    }

    public static void strategia2(int ilosc, int n, double p, double[] tab) {
        for (int i = 0; i < ilosc; i++) {
            boolean wykonany = false;
            int los;
            Random random = new Random();

            if (tab[0] < p) {
                tab[0] += random.nextDouble() * 10;
            } else {
                while (!wykonany) {
                    los = random.nextInt(n - 1) + 1;
                    if (tab[los] < p) {
                        tab[los] += random.nextInt(10);
                        wykonany = true;
                    }
                }
            }
        }
    }
}
