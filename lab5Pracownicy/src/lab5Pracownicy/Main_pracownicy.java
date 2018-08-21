package lab5Pracownicy;

import lab5Pracownicy.Pracownik;
import lab5Pracownicy.Robotnicy;
import lab5Pracownicy.TablicaPracownikow;
import lab5Pracownicy.Urzednicy;

public class Main_pracownicy {
	
public static void main(String[] args) {
	
		TablicaPracownikow lista1 = new TablicaPracownikow();
		
		Pracownik urz1 = new Urzednicy("Adamczyk", 1.0, 10.0, 2500);
		Pracownik urz2 = new Urzednicy("Adamiakowa", 1.5, 5.0, 2300);
		Pracownik urz3 = new Urzednicy("Adamkowski", 0.75, 25.0, 3200);
		
		Pracownik rob1 = new Robotnicy("Adamczynski", 1.0, 14.0, 164.0);
		
		lista1.zatrudnieniePracownika(urz1);
		lista1.zatrudnieniePracownika(urz2);
		lista1.zatrudnieniePracownika(urz3);
		lista1.zatrudnieniePracownika(rob1);
		System.out.println();
		lista1.listaPlac();
		lista1.listaPracownikow();
		System.out.println();
		lista1.ileRobotnikow();
		lista1.ileUrzednikow();
		lista1.ilePracownikow();
		lista1.listaUrzednikow();
		lista1.listaRobotnikow();
		lista1.sumaPlac();
		lista1.sumaPlacUrzednikow();
		lista1.sumaPlacRobotnikow();
		System.out.println();
		lista1.zwolnijPracownika("Adamski");
		lista1.zwolnijPracownika("Adamkowski");
		lista1.zwolnijPracownika("Janic");
		
}

}
