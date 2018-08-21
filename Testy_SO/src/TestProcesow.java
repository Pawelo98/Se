import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class TestProcesow {

    public static void main(String [] args) throws FileNotFoundException{

        double czasNadejscia = 0.0;

        double SJF1 = 0.0;
        double SJF2 = 0.0;

        File file1 = new File("najlepszy_bez_nadejscia.txt");
        Scanner in1 = new Scanner(file1);

        File file2 = new File("najgorszy_bez_nadejscia.txt");
        Scanner in2 = new Scanner(file2);

        ArrayList<Proces> lista1 = new ArrayList<>();
        ArrayList<Proces> lista2 = new ArrayList<>();

        for(int i=0; i<210; i++){

            int numerIdentyfikacyjny1 = in1.nextInt();
            double czasTrwania1 = in1.nextDouble();

            int numerIdentyfikacyjny2 = in2.nextInt();
            double czasTrwania2 = in2.nextDouble();

            Proces proces1 = new Proces(numerIdentyfikacyjny1, czasTrwania1);
            Proces proces2 = new Proces(numerIdentyfikacyjny2, czasTrwania2);

            lista1.add(proces1);
            lista2.add(proces2);
        }

        for(int j=0; j<210; j++){

            Proces proces1 = lista1.get(j);
            Proces proces2 = lista1.get(j);

            czasNadejscia += proces1.czasTrwania;
            czasNadejscia += proces2.czasTrwania;

            SJF1 += czasNadejscia;
            SJF2 += czasNadejscia;
        }

        SJF1 = SJF1/210;
        SJF2 = SJF2/210;

        System.out.println("SJF najlepszy: " + SJF1);
        System.out.println("SJF najgorszy: " + SJF2);
    }
}
