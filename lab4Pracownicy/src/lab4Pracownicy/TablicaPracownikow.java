package lab4Pracownicy;

public class TablicaPracownikow {
		Pracownik [] tab;
		
		public TablicaPracownikow(int a) {
			tab = new Pracownik [a];
		}
		
		public boolean zatrudnijPracownika(Pracownik p) {
			for(int i=0;i<tab.length;i++) {
				if(tab[i]==null) {
					tab[i]= p;
					return true;
					}
				
			}return false;
		}
		public void zatrudnieniePracownika(Pracownik p) {
			
			 	if(zatrudnijPracownika(p)) {
					System.out.println(p.getNazwisko()+" zosta³ zatrudniony");
				}
				else System.out.println(p.getNazwisko()+" - nie udalo sie zatrudnic");
		}
		
		public void zwolnijPracownika(String nazwisko) {
			boolean czy = false;
			for (int i=0;i<tab.length;i++) {
				if(tab[i]!=null ) {
					if (tab[i].getNazwisko().equals(nazwisko)) {
						tab[i] = null;
						czy = true;
						System.out.println(nazwisko + " zosta³ zwolniony"+"\n");
					}
					
				}
				
				
			}
			if(!czy) {
			System.out.println("Nie ma takiego pracownika ---> " + nazwisko+"\n");
			}
		}
		
		public void ilePracownikow() {
			int suma = 0;
			for (int j=0;j<tab.length;j++) {
				if (tab[j]!=null) {
					suma = suma+1;
				}
				
			}
			System.out.println("Liczba pracowników = "+ suma +"\n");
		}
		
		public void listaPracownikow() {
			System.out.println("Lista pracowników :");
			for (int i=0;i<tab.length;i++) {
				if(tab[i]!= null) {
					if (tab[i] instanceof Urzednicy) {
						System.out.println("["+i+"]" +"Urzednik"+ "\t" + tab[i].getNazwisko()+"\t"+"Etat :"+ tab[i].getEtat());
					}
					else if(tab[i] instanceof Robotnicy) {
						System.out.println("["+i+"]" +"Robotnik"+ "\t" + tab[i].getNazwisko()+"\t"+"Etat :"+ tab[i].getEtat());
					}
				}
			}
		}
				
		public void listaPlac() {
			System.out.println("Lista p³ac :");
			for (int i=0;i<tab.length;i++) {
				if(tab[i]!= null) {
					System.out.println("["+i+"]"+tab[i].toString());
				}
			}System.out.println();
		}	
		public void listaUrzednikow() {
			System.out.println("Lista urzedników :");
			for (int i=0;i<tab.length;i++) {
				if(tab[i]!= null && tab[i] instanceof Urzednicy) {
					System.out.println("["+i+"]"+"\t" + tab[i].getNazwisko() +"\t " + "Etat : "+tab[i].getEtat());
				}
			}System.out.println();
		}
		public void ileUrzednikow() {
			int suma1 = 0;
			for (int j=0;j<tab.length;j++) {
				if (tab[j]!=null && tab[j] instanceof Urzednicy) {
					suma1 = suma1 + 1;
				}
				
			}
			System.out.println("Liczba urzêdników = "+suma1+"\n");
		}
		public void ileRobotnikow() {
			int suma2 = 0;
			for (int j=0;j<tab.length;j++) {
				if (tab[j]!=null && tab[j] instanceof Robotnicy) {
					suma2 = suma2 + 1;
				}
				
			}
			System.out.println("Liczba robotników = "+suma2+"\n");
		}
		public void listaRobotnikow() {
			System.out.println("Lista robotników :");
			for (int i=0;i<tab.length;i++) {
				if(tab[i]!= null && tab[i] instanceof Robotnicy) {
					System.out.println("["+i+"]"+"\t" + tab[i].getNazwisko() +"\t " + "Etat : "+tab[i].getEtat());
				}
			}System.out.println();
		}
		public void sumaPlac() {
			double place = 0.0;
			for(int i=0;i<tab.length;i++) {
				if(tab[i]!=null) {
					place = place +tab[i].setPensja();
				}
			}
			System.out.println("Suma wszystkich p³ac = " +  place +"\n");
		}
		public void sumaPlacUrzednikow (){
			double place = 0.0;
			for(int i=0;i<tab.length;i++) {
				if(tab[i]!=null && tab[i] instanceof Urzednicy) {
					place = place +tab[i].setPensja();
				}
			}
			System.out.println("Suma wszystkich p³ac urzêdników = " +  place+"\n");
		}
		public void sumaPlacRobotnikow() {
			double place = 0.0;
			for(int i=0;i<tab.length;i++) {
				if(tab[i]!=null && tab[i] instanceof Robotnicy) {
					place = place +tab[i].setPensja();
				}
			}
			System.out.println("Suma wszystkich p³ac robotników = " +  place+"\n");
			
		}
		
}
