package lab6;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab6Plikiv2 {

    public double [] [] tab;
    public int szerokosc;
    public int wysokosc;

    private Lab6Plikiv2() {
    }

    public void wypelnijMacierz(){
        int losowanie;
        Random rand = new Random();

        System.out.println("Podaj szerokosc swojej tablicy: ");
        Scanner odczyt = new Scanner(System.in);
        szerokosc = odczyt.nextInt();
        while(szerokosc<=0) {
            System.out.println("Podaj prawidlowa wartosc szerokosci tablicy! ");
            szerokosc = odczyt.nextInt();
        }
        System.out.println("Podaj wysokosc swojej tablicy: ");
        wysokosc = odczyt.nextInt();
        while(wysokosc<=0) {
            System.out.println("Podaj prawidlowa wartosc wysokosci tablicy! ");
            wysokosc = odczyt.nextInt();
        }
        System.out.println("Podaj zakres losowania dla elementow swojej tablicy: ");
        losowanie = odczyt.nextInt();

        tab = new double[szerokosc][wysokosc];

        for(int i=0; i<szerokosc; i++) {
            for(int j=0; j<wysokosc; j++) {
                try {
                    tab[i][j] = rand.nextDouble()*losowanie;
                }
                catch(NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
        odczyt.close();
    }

    public void wyswietlMacierz()
    {
        try {
            for(int i=0; i<szerokosc; i++) {
                for(int j=0; j<wysokosc; j++) {
                    System.out.printf("%-6.2f", tab[i][j]);
                    System.out.print("\t");
                }
                System.out.println();
            }
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void zapiszDoPliku(String nazwaPliku) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(nazwaPliku);
        zapis.println("Macierz: ");
        zapis.println(szerokosc);
        zapis.println(wysokosc);
        for(int i=0; i<szerokosc; i++) {
            for(int j=0; j<wysokosc; j++) {
            	zapis.printf("%-6.2f", tab[i][j]);
                zapis.print("\t");
            }
            zapis.println("\n");
        }
        System.out.println("Macierz zapisano do pliku: " + nazwaPliku);
        zapis.close();
    }

    public void czytanieZPliku(String nazwaPliku) throws IOException
    {
    	System.out.println("Macierz z pliku " + nazwaPliku);
        FileReader fileReader = new FileReader(nazwaPliku);
        BufferedReader br = new BufferedReader(fileReader);
        String textLine = "cos";
        int licz = 0;
        while(textLine != null) {
        	if(0==licz)
            {
                textLine = br.readLine();
            }
            if(1==licz)
            {
                textLine = br.readLine();
                szerokosc = Integer.parseInt(textLine);
            }
            if(2==licz)
            {
                textLine = br.readLine();
                wysokosc = Integer.parseInt(textLine);
                tab = new double [szerokosc][wysokosc];
            }
            if(2<licz)
            {
            	textLine = br.readLine();
                if(textLine!=null) 
                {
                	String[] podzial = textLine.split("\t");
                	for(int i = 0; i<podzial.length; i++)
                	{
                		tab[licz-3][i] = Double.parseDouble(podzial[i].replace(',', '.')); 
                	}
                	for(int j=0; j<wysokosc; j++)
            		{
            			System.out.print(tab[licz-3][j] + "\t");
            		}
            		System.out.println();
            	}
            }
            licz++;
        }

        br.close();
        fileReader.close();
    }
    public double wartoscSrednia() {
        double suma = 0.0;
        for(int i=0; i<szerokosc; i++) {
            for(int j=0; j<wysokosc; j++) {
                suma += tab[i][j];
            }
        }
        System.out.println();
        System.out.print("Wartosc srednia elementow macierzy wynosi: ");
        if(suma==0) {
            return 0.0;
        }
        else return (suma/(szerokosc*wysokosc));
    }

    public static void main(String []args)throws FileNotFoundException{

        Lab6Plikiv2 tab1 = new Lab6Plikiv2();
        tab1.wypelnijMacierz();
        System.out.println();
        tab1.wyswietlMacierz();
        System.out.printf("%5.2f", tab1.wartoscSrednia());
        System.out.println();
        tab1.zapiszDoPliku("Macierz.txt"); 
        System.out.println();
        Lab6Plikiv2 tab2 = new Lab6Plikiv2();
        try
        {
            tab2.czytanieZPliku("MacierzOdczyt.txt");
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.printf("%-5.2f", tab2.wartoscSrednia());
    }
}