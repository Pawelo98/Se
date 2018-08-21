package lab7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab7Pliki {
	
	private int znaki=0;
	private int wyrazy=0;
	private int wiersze=0;
	
	public Lab7Pliki()
	{
	}
	
	public void czytanieZPliku(String nazwaPliku) throws IOException
    {
    	System.out.println("Tekst z pliku " + nazwaPliku);
        FileReader fileReader = new FileReader(nazwaPliku);
        BufferedReader br = new BufferedReader(fileReader);
        String textLine = "";
        int max = 0;
        int temp = 0;
        int wystapienia = 0;
        
        System.out.println("Podaj slowo, ktorego ilosc wystapien chcesz sprawdzic: ");
        Scanner odczyt = new Scanner(System.in);
        
        String wyraz = odczyt.next();
        
        do
        {
        	textLine = br.readLine();
        	wiersze++;
        	
        	if(textLine!=null)
        	{
	        	String[] podzial = textLine.split(" ");
	        	for(int i=0; i<podzial.length; i++)
	        	{
	        		temp = 0;
	        		String slowo = podzial[i];
	        		
	        		if(slowo.equals(wyraz)) wystapienia++;
	        		
	        		for(int j=0; j<slowo.length(); j++)
	        		{
	        			temp++;
	        			znaki++;
	        			
	        			if(max<temp)
	        			{
	        				max = temp;
	        			}
	        		}
	        		
	        		wyrazy++;
	        	}
        	}
        	
        }while(textLine!=null);
        
        
        
        wiersze--;
        znaki = znaki-wiersze+wyrazy;
                	
        System.out.println("Ilosc wierszy: " + wiersze);
        System.out.println("Ilosc znakow: " + znaki);
        System.out.println("Ilosc wyrazow: " + wyrazy);
        System.out.println("Maksymalna dlugosc wyrazu to: " + max);
        System.out.println("Ilosc wystapien slowa " + wyraz + " wynosi " + wystapienia);

        br.close();
        fileReader.close();
        odczyt.close();
    }
	
	public void zapiszDoPliku(String nazwaPliku, String skad) throws Exception {
       
		PrintWriter zapis = new PrintWriter(nazwaPliku);
        
        System.out.println("Tekst z pliku " + skad);
        FileReader fileReader = new FileReader(skad);
        BufferedReader br = new BufferedReader(fileReader);
        String textLine = "";
        
        do
        {
        	textLine = br.readLine();
        	
        	if(textLine!=null)
        	{
	        	String[] podzial = textLine.split(" ");
	        	
	        	if(podzial[0].charAt(0)!= '/' || podzial[0].charAt(1)!= '/')
    				zapis.println(textLine);
        	}
        	
        }while(textLine!=null);
        
        System.out.println("Zapisano w pliku " + nazwaPliku);
        
        zapis.close();
        br.close();
        fileReader.close();
    }
	
	public static void main(String []args)throws FileNotFoundException{
		
		Lab7Pliki plik = new Lab7Pliki();
		
		try
        {
			plik.czytanieZPliku("PlikZapisu.txt");
        }
        catch(IOException e){
            e.printStackTrace();
        }
		
		System.out.println();
		
		try
        {
			plik.zapiszDoPliku("BezKomentarzy.txt","PlikZapisu.txt");
        }
        catch(Exception e){
            e.printStackTrace();
        }
		
		
	}

}
