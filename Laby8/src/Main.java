import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int rozmiar = 1000;

        Random random = new Random();

        for (int i = 0; i < 4; i++) {

            if (i == 0) rozmiar = 5000;
            if (i == 1) rozmiar = 10000;
            if (i == 2) rozmiar = 50000;
            if (i == 3) rozmiar = 100000;

            int[] ciagFibo = new int[rozmiar];
            int[] ciagA = new int[rozmiar];
            int[] ciagB = new int[rozmiar];
            int[] ciagH = new int[rozmiar];
            int[] ciagI = new int[rozmiar];

            ArrayList<Integer> gapsFibo = new ArrayList<>();
            ArrayList<Integer> gapsA = new ArrayList<>();
            ArrayList<Integer> gapsB = new ArrayList<>();
            ArrayList<Integer> gapsH = new ArrayList<>();
            ArrayList<Integer> gapsI = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    int f1 = 1;
                    int f2 = 1;
                    gapsFibo.add(f1);
                    gapsFibo.add(f2);

                    while (f1 < rozmiar && f2 < rozmiar) {
                        if (f1 >= f2) {
                            f2 += f1;
                            gapsFibo.add(f2);
                        } else {
                            f1 += f2;
                            gapsFibo.add(f1);
                        }
                    }
                    Collections.reverse(gapsFibo);
                } else if (j == 1) {

                    int a = 1;
                    int iter = 1;
                    gapsA.add(a);
                    while (a < rozmiar) {
                        a = (int) Math.pow(2, iter) - 1;
                        iter++;
                        gapsA.add(a);
                    }
                    Collections.reverse(gapsA);
                } else if (j == 2) {

                    int b = 1;
                    int iter = 1;
                    gapsB.add(b);
                    while (b < rozmiar) {
                        b = (int) Math.pow(2, iter) + 1;
                        iter++;
                        gapsB.add(b);
                    }
                    Collections.reverse(gapsB);
                } else if (j == 3) {
                    int h = 1;
                    gapsH.add(h);
                    while (h < rozmiar) {
                        h = 3 * h + 1;
                        gapsH.add(h);
                    }

                    Collections.reverse(gapsH);
                } else if (j == 4) {
                    int ii = rozmiar / 2;
                    gapsI.add(ii);
                    while (ii >= 1) {
                        ii = (ii * 3) / 4;
                        gapsI.add(ii);
                    }
                }

            }

            for (int j = 0; j < rozmiar; j++) {
                int temp = random.nextInt();
                ciagFibo[j] = temp;
                ciagA[j] = temp;
                ciagB[j] = temp;
                ciagH[j] = temp;
                ciagI[j] = temp;
            }

            for (int s = 0; s < 3; s++) {
                for (int g = 0; g < 5; g++) {
                    if (s == 0 && g == 0) {
                        System.out.println("Shellbab" + " rozmiaru:" + rozmiar + ", gap: A");
                        System.out.println(shellbab(ciagA, gapsA));
                    }
                    if (s == 1 && g == 0) {
                        System.out.println("ShellInsert" + " rozmiaru:" + rozmiar + ", gap: A");
                        System.out.println(shellInsert(ciagA, gapsA));
                    }
                    if (s == 2 && g == 0) {
                        System.out.println("ShellAllInsert" + " rozmiaru:" + rozmiar + ", gap: A");
                        System.out.println(shellAllInsert(ciagA, gapsA));
                    }
                    if (s == 0 && g == 1) {
                        System.out.println("Shellbab" + " rozmiaru:" + rozmiar + ", gap: B");
                        System.out.println(shellbab(ciagB, gapsB));
                    }
                    if (s == 1 && g == 1) {
                        System.out.println("ShellInsert" + " rozmiaru:" + rozmiar + ", gap: B");
                        System.out.println(shellInsert(ciagB, gapsB));
                    }
                    if (s == 2 && g == 1) {
                        System.out.println("ShellAllInsert" + " rozmiaru:" + rozmiar + ", gap: B");
                        System.out.println(shellAllInsert(ciagB, gapsB));
                    }
                    if (s == 0 && g == 2) {
                        System.out.println("Shellbab" + " rozmiaru:" + rozmiar + ", gap: H");
                        System.out.println(shellbab(ciagH, gapsH));
                    }
                    if (s == 1 && g == 2) {
                        System.out.println("ShellInsert" + " rozmiaru:" + rozmiar + ", gap: H");
                        System.out.println(shellInsert(ciagH, gapsH));
                    }
                    if (s == 2 && g == 2) {
                        System.out.println("ShellAllInsert" + " rozmiaru:" + rozmiar + ", gap: H");
                        System.out.println(shellAllInsert(ciagH, gapsH));
                    }
                    if (s == 0 && g == 3) {
                        System.out.println("Shellbab" + " rozmiaru:" + rozmiar + ", gap: Fibo");
                        System.out.println(shellbab(ciagFibo, gapsFibo));
                    }
                    if (s == 1 && g == 3) {
                        System.out.println("ShellInsert" + " rozmiaru:" + rozmiar + ", gap: Fibo");
                        System.out.println(shellInsert(ciagFibo, gapsFibo));
                    }
                    if (s == 2 && g == 3) {
                        System.out.println("ShellAllInsert" + " rozmiaru:" + rozmiar + ", gap: Fibo");
                        System.out.println(shellAllInsert(ciagFibo, gapsFibo));
                    }
                    if (s == 0 && g == 4) {
                        System.out.println("Shellbab" + " rozmiaru:" + rozmiar + ", gap: I");
                        System.out.println(shellbab(ciagI, gapsI));
                    }
                    if (s == 1 && g == 4) {
                        System.out.println("ShellInsert" + " rozmiaru:" + rozmiar + ", gap: I");
                        System.out.println(shellInsert(ciagI, gapsI));
                    }
                    if (s == 2 && g == 4) {
                        System.out.println("ShellAllInsert" + " rozmiaru:" + rozmiar + ", gap: I");
                        System.out.println(shellAllInsert(ciagI, gapsI));
                    }
                }
            }

        }
    }

    public static int[] insertSort(int[] tab, int gap) {

        int curr = 0;
        while (curr < gap) {
            for (int i = curr + gap; i < tab.length; i = i + gap) {
                int j = i - gap;
                int klucz = tab[i];

                while (j >= 0 && tab[j] > klucz) {
                    tab[j + gap] = tab[j];
                    j = j - gap;
                }
                tab[j + gap] = klucz;
            }
            curr++;
        }

        return tab;
    }

    public static int[] bubbleSort(int[] tab, int gap) {

        int curr = 0;
        while (curr < gap) {
            for (int i = curr; i < tab.length - gap; i = i + gap) {
                for (int j = curr; j < (tab.length - gap); j = j + gap) {
                    if (tab[j] > tab[j + gap]) {
                        int temp = tab[j];
                        tab[j] = tab[j + gap];
                        tab[j + gap] = temp;
                    }
                }
            }
            curr++;
        }

        return tab;
    }

    public static double shellAllInsert(int[] tab, ArrayList<Integer> gapsFibo) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < gapsFibo.size(); i++) {
            int gap = gapsFibo.get(i);
            insertSort(tab, gap);
        }

        long czasTrwania = System.currentTimeMillis() - start;

        return czasTrwania;
    }

    public static double shellInsert(int[] tab, ArrayList<Integer> gapsA) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < gapsA.size(); i++) {
            if (gapsA.get(i) > 1) {
                insertSort(tab, gapsA.get(i));
            } else {
                bubbleSort(tab, gapsA.get(i));
            }
        }

        long czasTrwania = System.currentTimeMillis() - start;

        return czasTrwania;
    }

    public static double shellbab(int[] tab, ArrayList<Integer> gapsA) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < gapsA.size(); i++) {
            if (gapsA.get(i) > 1) {
                bubbleSort(tab, gapsA.get(i));
            } else {
                insertSort(tab, gapsA.get(i));
            }
        }

        long czasTrwania = System.currentTimeMillis() - start;

        return czasTrwania;
    }
}
