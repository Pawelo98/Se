package lab5Pracownicy;

import lab5Pracownicy.Pracownik;
import lab5Pracownicy.Robotnicy;
import lab5Pracownicy.Urzednicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TablicaPracownikow {
	
		private int n;
	
		List<Pracownik> lista = new ArrayList<Pracownik>();
		
		public void zatrudnieniePracownika(Pracownik p) {
			boolean wystapienie = false;
			for(int i=0; i<lista.size(); i++)
			{
				if(lista.get(i).getNazwisko().equals(p.nazwisko))
				{
					wystapienie = true;
				}
			}
					if(wystapienie==false)
					{
						lista.add(p);
						System.out.println(p.getNazwisko() + " zostal zatrudniony");
					}
					else System.out.println("Pracownik o tym nazwisku jest juz zatrudniony");
			}
		
		public void zwolnijPracownika(String nazwisko) {
			boolean czy = false;
			for (int i=0;i<lista.size();i++) {
				if(lista.get(i)!=null ) {
					if (lista.get(i).getNazwisko().equals(nazwisko)) {
						lista.remove(i);
						czy = true;
						System.out.println(nazwisko + " zostal zwolniony"+"\n");
					}
				}
			}
			if(!czy) {
			System.out.println("Nie ma takiego pracownika ---> " + nazwisko + "\n");
			}
		}
		
		public void ilePracownikow() {
			Iterator<Pracownik> itr = lista.iterator();
			int suma = 0;
			while(itr.hasNext())
			{
				if(itr.next()!=null)
					suma = suma + 1;
			}
			System.out.println("Liczba pracownikow = " + suma + "\n");
		}
		
		public void listaPracownikow() {
			System.out.println("Lista pracownikow :");
			System.out.println("Indeks" + "\tGrupa\t" + "Nazwisko" + "\t" + "Etat");
			for (int i=0;i<lista.size();i++) {
				if(lista.get(i)!= null) {
					if (lista.get(i) instanceof Urzednicy) {
						System.out.printf(i +"   Urzednik"+ "\t" + lista.get(i).getNazwisko() + "\t");
						System.out.printf("%-5.2f", lista.get(i).getEtat());
						System.out.println();
					}
					else if(lista.get(i) instanceof Robotnicy) {
						System.out.printf(i +"   Robotnik"+ "\t" + lista.get(i).getNazwisko() + "\t");
						System.out.printf("%-5.2f", lista.get(i).getEtat());
						System.out.println();
					}
				}
			}
		}
		
		private int licz(int n)
		{
			this.n = n+1;
			return n;
		}
				
		public void listaPlac() {
			System.out.println("Lista plac :");
			System.out.println("Lp.    " +  "\tGrupa    " + "Nazwisko " + "\t" + "Etat" + "\t" + "Pensja");
			lista.forEach(lista->System.out.println(licz(n) + ".\t" + lista.toString()));
			System.out.println();
			}
		
		public void listaUrzednikow() {
			System.out.println("Lista urzednikow:");
			System.out.println("Indeks" + "\t" + "Nazwisko" + "\t" + "Etat");
			for (int i=0;i<lista.size();i++) {
				if(lista.get(i)!= null && lista.get(i) instanceof Urzednicy) {
					System.out.printf("  "+i+ "\t" + lista.get(i).getNazwisko() +"\t ");
					System.out.printf("%-5.2f", lista.get(i).getEtat());
					System.out.println();
				}
			}
			System.out.println();
		}
		
		public void ileUrzednikow() {
			int suma1 = 0;
			for (int j=0;j<lista.size();j++) {
				if (lista.get(j)!=null && lista.get(j) instanceof Urzednicy) {
					suma1 = suma1 + 1;
				}
				
			}
			System.out.println("Liczba urzednikow = " + suma1 + "\n");
		}
		
		public void ileRobotnikow() {
			int suma2 = 0;
			for (int j=0;j<lista.size();j++) {
				if (lista.get(j)!=null && lista.get(j) instanceof Robotnicy) {
					suma2 = suma2 + 1;
				}
				
			}
			System.out.println("Liczba robotnikow = " + suma2 + "\n");
		}
		
		public void listaRobotnikow() {
			System.out.println("Lista robotnikow:");
			System.out.println("Indeks" + "\t" + "Nazwisko" + "\t" + "Etat");
			for (int i=0;i<lista.size();i++) {
				if(lista.get(i)!= null && lista.get(i) instanceof Robotnicy) {
					System.out.printf("  "+ i + "\t" + lista.get(i).getNazwisko() + "\t ");
					System.out.printf("%-5.2f", lista.get(i).getEtat());
					System.out.println();
				}
			}
			System.out.println();
		}
		
		public void sumaPlac() {
			double place = 0.0;
			for(int i=0;i<lista.size();i++) {
				if(lista.get(i)!=null) {
					place = place + lista.get(i).setPensja();
				}
			}
			System.out.printf("Suma wszystkich plac = ");
			System.out.printf("%-8.2f", place);
			System.out.println();
		}
		
		public void sumaPlacUrzednikow (){
			double place = 0.0;
			for(int i = 0; i<lista.size(); i++) {
				if(lista.get(i)!=null && lista.get(i) instanceof Urzednicy) {
					place = place + lista.get(i).setPensja();
				}
			}
			System.out.printf("Suma plac urzednikow = ");
			System.out.printf("%-8.2f", place);
			System.out.println();
		}
		
		public void sumaPlacRobotnikow() {
			double place = 0.0;
			for(int i=0;i<lista.size();i++) {
				if(lista.get(i)!=null && lista.get(i) instanceof Robotnicy) {
					place = place + lista.get(i).setPensja();
				}
			}
			System.out.printf("Suma plac robotnikow = ");
			System.out.printf("%-8.2f", place);
			System.out.println();
		}
		
}
