package lab6;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab6Pliki {
	
	private double [] [] tab;
	private int szerokosc;
	private int wysokosc;
	
	public Lab6Pliki()
	{
		int losowanie = 1;
		Random rand = new Random();
		
		System.out.println("Podaj szerokosc swojej tablicy: ");
		Scanner odczyt = new Scanner(System.in);
		wysokosc = odczyt.nextInt();
		while(wysokosc<=0)
		{
			System.out.println("Podaj prawidlowa wartosc szerokosci tablicy! ");
			wysokosc = odczyt.nextInt();
		}
		System.out.println("Podaj wysokosc swojej tablicy: ");
		szerokosc = odczyt.nextInt();
		while(szerokosc<=0)
		{
			System.out.println("Podaj prawidlowa wartosc wysokosci tablicy! ");
			szerokosc = odczyt.nextInt();
		}
		System.out.println("Podaj zakres losowania dla elementow swojej tablicy: ");
		losowanie = odczyt.nextInt();
		
		tab = new double[szerokosc][wysokosc];
		
		for(int i=0; i<szerokosc; i++)
		{
			for(int j=0; j<wysokosc; j++)
			{
				try {
					tab[i][j] = rand.nextDouble()*losowanie;
				}
				catch(NullPointerException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void wyswietlMacierz()
	{
		try {
		for(int i=0; i<szerokosc; i++)
		{
			for(int j=0; j<wysokosc; j++)
			{
				System.out.printf("%6.3f", tab[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
	}
	
	public void zapiszDoPliku(String nazwaPliku) throws FileNotFoundException
	{
		PrintWriter zapis = new PrintWriter(nazwaPliku);
	    zapis.println("Macierz: ");
	    zapis.println(szerokosc);
	    zapis.println(wysokosc);
	    for(int i=0; i<szerokosc; i++)
	    {
	    	for(int j=0; j<wysokosc; j++)
	    	{
	    		zapis.printf("%6.3f", tab[i][j]);
				zapis.print("\t");
	    	}
	    	zapis.println();
	    }
	    zapis.close();
	    System.out.println("Zapisano macierz do pliku o nazwie: " + nazwaPliku);
	}
	
	public void czytanieZPliku(String nazwaPliku) throws IOException
	{
		  FileReader fileReader = new FileReader(nazwaPliku);
		  BufferedReader br = new BufferedReader(fileReader);			  
		  String textLine = br.readLine();
		  double [][] tablica;
		  int licz = 0;
		  do {
			licz++;
			if(2==licz)
			{
				textLine = br.readLine();
				szerokosc = Integer.parseInt(textLine);
			}
			if(3<=licz)
			{
				if(3==licz)
				{
					textLine = br.readLine();
					wysokosc = Integer.parseInt(textLine);
					tablica = new double[szerokosc][wysokosc];
				}
				if(3<licz)
				{
					for(int i=0; i<szerokosc; i++)
					{
						double textNumber = br.read();
						tablica [licz-4][i] = textNumber;
					}
				}
			}
			} while(textLine != null);
		  
		  try {
				for(int i=0; i<szerokosc; i++)
				{
					for(int j=0; j<wysokosc; j++)
					{
						System.out.printf("%6.3f", tablica[i][j]);
						System.out.print("\t");
					}
					System.out.println();
				}
				}
				catch(NullPointerException e)
				{
					e.printStackTrace();
				}
		  
		  double suma = 0.0;
			for(int i=0; i<szerokosc; i++)
		    {
		    	for(int j=0; j<wysokosc; j++)
		    	{
		    		suma += tablica[i][j];
		    	}
		    }
			System.out.println("Wartosc srednia elementow macierzy wynosi: ");
			if(suma==0)
			{
				System.out.println("Wartosc srednia elementow macierzy wynosi: 0.0 ");
			}
			else System.out.println("Wartosc srednia elementow macierzy wynosi: " + (suma/(szerokosc*wysokosc)));

		  br.close();
		  fileReader.close();
	}
	
	double wartoscSrednia()
	{
		double suma = 0.0;
		for(int i=0; i<szerokosc; i++)
	    {
	    	for(int j=0; j<wysokosc; j++)
	    	{
	    		suma += tab[i][j];
	    	}
	    }
		System.out.println("Wartosc srednia elementow macierzy wynosi: ");
		if(suma==0)
		{
			return 0.0;
		}
		else return (suma/(szerokosc*wysokosc));
	}
	
	public static void main(String []args)throws FileNotFoundException{
		
		Lab6Pliki tab1 = new Lab6Pliki();
		tab1.wyswietlMacierz();
		System.out.printf("%5.2f", tab1.wartoscSrednia());
		System.out.println();
		tab1.zapiszDoPliku("Macierz.txt");
		Lab6Pliki tab2 = new Lab6Pliki.czytanieZPliku("MacierzOdczyt.txt");
		System.out.printf("%5.2f", tab2.wartoscSrednia());
	}

}
