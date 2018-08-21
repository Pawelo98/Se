import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

    public static int[] insertSort(int[] tab) {

        long start = System.currentTimeMillis();

        for (int i = 1; i < tab.length; i++) {
            int j = i - 1;
            int klucz = tab[i];

            while (j >= 0 && tab[j] > klucz) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = klucz;
        }

        long koniec = System.currentTimeMillis();

        long czasTrwania = koniec - start;

        System.out.println("Posortowano tablice metoda insertSort w czasie " + czasTrwania + "ms");

        try {
            PrintWriter zapis = new PrintWriter("insert.txt");
            for(int k=0; k<tab.length; k++){
                zapis.println(tab[k]);
            }
            zapis.close();
        }catch(FileNotFoundException e){ e.printStackTrace(); }

        return tab;
    }

    public static int[] bubbleSort(int[] tab) {

        long start = System.currentTimeMillis();

        int temp = 0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 1; j < (tab.length - i); j++) {
                if (tab[j - 1] > tab[j]) {
                    temp = tab[j - 1];
                    tab[j - 1] = tab[j];
                    tab[j] = temp;
                }

            }
        }

        long koniec = System.currentTimeMillis();

        long czasTrwania = koniec - start;

        System.out.println("Posortowano tablice metoda bubbleSort w czasie " + czasTrwania + "ms");

        try {
            PrintWriter zapis = new PrintWriter("bubble.txt");
            for(int k=0; k<tab.length; k++){
                zapis.println(tab[k]);
            }
            zapis.close();
        }catch(FileNotFoundException e){ e.printStackTrace(); }

        return tab;
    }

    public static int[] selectSort(int[] tab) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < tab.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < tab.length; j++)
                if (tab[j] < tab[index])
                    index = j;

            int smallerNumber = tab[index];
            tab[index] = tab[i];
            tab[i] = smallerNumber;
        }

        long koniec = System.currentTimeMillis();

        long czasTrwania = koniec - start;

        System.out.println("Posortowano tablice metoda selectSort w czasie " + czasTrwania + "ms");

        try {
            PrintWriter zapis = new PrintWriter("select.txt");
            for(int k=0; k<tab.length; k++){
                zapis.println(tab[k]);
            }
            zapis.close();
        }catch(FileNotFoundException e){ e.printStackTrace(); }

        return tab;
    }

    public static int[] quickSort(int[] tab, int pocz, int kon) {

        int i, j, v, temp;

        i = pocz;
        j = kon;
        v = tab[(pocz + kon) / 2];
        do {
            while (tab[i] < v)
                i++;
            while (v < tab[j])
                j--;
            if (i <= j) {
                temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
                i++;
                j--;
            }
        }
        while (i <= j);
        if (pocz < j)
            quickSort(tab, pocz, j);
        if (i < kon)
            quickSort(tab, i, kon);

        return tab;
    }

    public static int[] heapSort(int[] tab) {

        long start = System.currentTimeMillis();

        int n = tab.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(tab, n, i);

        for (int i=n-1; i>=0; i--)
        {
            int temp = tab[0];
            tab[0] = tab[i];
            tab[i] = temp;

            heapify(tab, i, 0);
        }

        long koniec = System.currentTimeMillis();

        long czasTrwania = koniec - start;

        System.out.println("Posortowano tablice metoda heapSort w czasie " + czasTrwania + "ms");

        try {
            PrintWriter zapis = new PrintWriter("heap.txt");
            for(int k=0; k<tab.length; k++){
                zapis.println(tab[k]);
            }
            zapis.close();
        }catch(FileNotFoundException e){ e.printStackTrace(); }

        return tab;
    }

    public static void heapify(int [] tab, int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && tab[l] > tab[largest])
            largest = l;

        if (r < n && tab[r] > tab[largest])
            largest = r;

        if (largest != i)
        {
            int swap = tab[i];
            tab[i] = tab[largest];
            tab[largest] = swap;

            heapify(tab, n, largest);
        }
    }

    public static int[] mergeSort(int[] tab, int l, int r) {

        if (l < r)
        {
            int m = (l+r)/2;

            mergeSort(tab, l, m);
            mergeSort(tab , m+1, r);

            merge(tab, l, m, r);
        }
        return tab;
    }

    public static int[] odwrocTablice(int[] tab) {

        for (int i = 0; i < tab.length / 2; i++) {
            int temp = tab[i];
            tab[i] = tab[tab.length - i - 1];
            tab[tab.length - i - 1] = temp;
        }

        return tab;
    }

    static void merge(int tab[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = tab[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = tab[m + 1+ j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                tab[k] = L[i];
                i++;
            }
            else
            {
                tab[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            tab[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            tab[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int[] tab1 = new int[50000];
        int[] tab2 = new int[50000];
        int[] tab3 = new int[50000];
        int[] tab4 = new int[50000];
        int[] tab5 = new int[50000];
        int[] tab6 = new int[50000];
        Random random = new Random();

        long start = 0;
        long koniec = 0;
        long czasTrwania = 0;

        for (int i = 0; i < 50000; i++) {
            tab1[i] = random.nextInt();
            tab2[i] = tab1[i];
            tab3[i] = tab1[i];
            tab4[i] = tab1[i];
            tab5[i] = tab1[i];
            tab6[i] = tab1[i];
        }

        insertSort(tab1);
        insertSort(tab1);
        odwrocTablice(tab1);
        insertSort(tab1);
        System.out.println();

        bubbleSort(tab2);
        bubbleSort(tab2);
        odwrocTablice(tab2);
        bubbleSort(tab2);
        System.out.println();

        selectSort(tab3);
        selectSort(tab3);
        odwrocTablice(tab3);
        selectSort(tab3);
        System.out.println();

        start = System.currentTimeMillis();
        quickSort(tab4, 0, tab4.length-1);
        koniec = System.currentTimeMillis();
        czasTrwania = koniec-start;
        System.out.println("Posortowano tablice metoda quickSort w czasie " + czasTrwania + "ms");
        start = System.currentTimeMillis();
        quickSort(tab4, 0, tab4.length-1);
        koniec = System.currentTimeMillis();
        czasTrwania = koniec-start;
        System.out.println("Posortowano tablice metoda quickSort w czasie " + czasTrwania + "ms");
        odwrocTablice(tab4);
        start = System.currentTimeMillis();
        quickSort(tab4, 0, tab4.length-1);
        koniec = System.currentTimeMillis();
        czasTrwania = koniec-start;
        System.out.println("Posortowano tablice metoda quickSort w czasie " + czasTrwania + "ms");

        try {
            PrintWriter zapis = new PrintWriter("quick.txt");
            for(int k=0; k<tab4.length; k++){
                zapis.println(tab4[k]);
            }
            zapis.close();
        }catch(FileNotFoundException e){ e.printStackTrace(); }

        System.out.println();


        start = System.currentTimeMillis();
        mergeSort(tab5, 0, tab5.length-1);
        koniec = System.currentTimeMillis();
        czasTrwania = koniec-start;
        System.out.println("Posortowano tablice metoda mergeSort w czasie " + czasTrwania + "ms");
        start = System.currentTimeMillis();
        mergeSort(tab5, 0, tab5.length-1);
        koniec = System.currentTimeMillis();
        czasTrwania = koniec-start;
        System.out.println("Posortowano tablice metoda mergeSort w czasie " + czasTrwania + "ms");
        odwrocTablice(tab5);
        start = System.currentTimeMillis();
        mergeSort(tab5, 0, tab5.length-1);
        koniec = System.currentTimeMillis();
        czasTrwania = koniec-start;
        System.out.println("Posortowano tablice metoda mergeSort w czasie " + czasTrwania + "ms");

        try {
            PrintWriter zapis = new PrintWriter("merge.txt");
            for(int k=0; k<tab5.length; k++){
                zapis.println(tab5[k]);
            }
            zapis.close();
        }catch(FileNotFoundException e){ e.printStackTrace(); }

        System.out.println();

        heapSort(tab6);
        heapSort(tab6);
        odwrocTablice(tab6);
        heapSort(tab6);
        System.out.println();
    }
}
