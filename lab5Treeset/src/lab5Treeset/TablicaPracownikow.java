package lab5Treeset;

import lab5Treeset.Pracownik;
import lab5Treeset.Robotnicy;
import lab5Treeset.Urzednicy;

import java.util.*;

public class TablicaPracownikow {
	
		private int n;
	
		TreeSet<Pracownik> lista = new TreeSet<Pracownik>();
		
		Iterator<Pracownik> itr = lista.iterator();
		
		public void zatrudnieniePracownika(Pracownik p) {
				lista.add(p);
				System.out.println(p.getNazwisko() + " zostal zatrudniony");
			}
		
		public void zwolnijPracownika(String nazwisko) {
			boolean czy = false;
			while(itr.hasNext())
				if(itr.next()!=null) {
					if(itr.next().getNazwisko().equals(nazwisko)) {
						lista.remove(itr.next());
						czy = true;
						System.out.println(nazwisko + " zostal zwolniony"+"\n");
					}
				}
			if(!czy) {
			System.out.println("Nie ma takiego pracownika ---> " + nazwisko + "\n");
			}
		}
		
		public void ilePracownikow() {
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
			while(itr.hasNext()) {
				int n = 0;
				if(itr.next()!= null) {
					if (itr.next()instanceof Urzednicy) {
						System.out.printf(n +"   Urzednik"+ "\t" + itr.next().getNazwisko() + "\t");
						System.out.printf("%-5.2f", itr.next().getEtat());
						System.out.println();
					}
					else if(itr.next() instanceof Robotnicy) {
						System.out.printf(n +"   Robotnik"+ "\t" + itr.next().getNazwisko() + "\t");
						System.out.printf("%-5.2f", itr.next().getEtat());
						System.out.println();
					}
				}
				n++;
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
			int n = 0;
			while(itr.hasNext()) {
				if(itr.next()!= null && itr.next() instanceof Urzednicy) {
					System.out.printf("  "+ n + "\t" + itr.next().getNazwisko() +"\t ");
					System.out.printf("%-5.2f", itr.next().getEtat());
					System.out.println();
				}
				n++;
			}
			System.out.println();
		}
		
		public void ileUrzednikow() {
			int suma1 = 0;
			while(itr.hasNext()) {
				if (itr.next()!=null && itr.next() instanceof Urzednicy) {
					suma1 = suma1 + 1;
				}
				
			}
			System.out.println("Liczba urzednikow = " + suma1 + "\n");
		}
		
		public void ileRobotnikow() {
			int suma2 = 0;
			while(itr.hasNext()) {
				if (itr.next()!=null && itr.next() instanceof Robotnicy) {
					suma2 = suma2 + 1;
				}
				
			}
			System.out.println("Liczba robotnikow = " + suma2 + "\n");
		}
		
		public void listaRobotnikow() {
			System.out.println("Lista robotnikow:");
			System.out.println("Indeks" + "\t" + "Nazwisko" + "\t" + "Etat");
			int n=0;
			while(itr.hasNext()) {
				if(itr.next()!= null && itr.next() instanceof Robotnicy) {
					System.out.printf("  "+ n + "\t" + itr.next().getNazwisko() + "\t ");
					System.out.printf("%-5.2f", itr.next().getEtat());
					System.out.println();
				}
				n++;
			}
			System.out.println();
		}
		
		public void sumaPlac() {
			double place = 0.0;
			while(itr.hasNext()) {
				if(itr.next()!=null) {
					place = place + itr.next().setPensja();
				}
			}
			System.out.printf("Suma wszystkich plac = ");
			System.out.printf("%-8.2f", place);
			System.out.println();
		}
		
		public void sumaPlacUrzednikow (){
			double place = 0.0;
			while(itr.hasNext()) {
				if(itr.next()!=null && itr.next() instanceof Urzednicy) {
					place = place + itr.next().setPensja();
				}
			}
			System.out.printf("Suma plac urzednikow = ");
			System.out.printf("%-8.2f", place);
			System.out.println();
		}
		
		public void sumaPlacRobotnikow() {
			double place = 0.0;
			while(itr.hasNext()) {
				if(itr.next()!=null && itr.next() instanceof Robotnicy) {
					place = place + itr.next().setPensja();
				}
			}
			System.out.printf("Suma plac robotnikow = ");
			System.out.printf("%-8.2f", place);
			System.out.println();
		}
		
}