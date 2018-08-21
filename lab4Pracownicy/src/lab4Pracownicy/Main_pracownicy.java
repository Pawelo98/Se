package lab4Pracownicy;

public class Main_pracownicy {
	
public static void main(String[] args) {
		
		Pracownik urz1 = new Urzednicy("Adamczyk", 1.0, 10.0, 2500);
		Pracownik urz2 = new Urzednicy("Adamczykowski", 1.5, 5.0, 2300);
		Pracownik urz3 = new Urzednicy("Adamkowski", 0.75, 25.0, 3200);
		
		Pracownik rob1 = new Robotnicy("Adamczynski", 1.0, 14.0, 164.0);
		
		System.out.println(urz1 + " " + urz1.setPensja());
		System.out.println(urz2 + " " + urz2.setPensja());
		System.out.println(urz3 + " " + urz3.setPensja());
		System.out.println(rob1 + " " + rob1.setPensja());
		
		TablicaPracownikow tab1 = new TablicaPracownikow(10);
		
		tab1.zatrudnieniePracownika(urz1);
		tab1.zatrudnieniePracownika(urz2);
		tab1.zatrudnieniePracownika(urz3);
		tab1.zatrudnieniePracownika(rob1);
		System.out.println();
		tab1.sumaPlac();
		tab1.sumaPlacUrzednikow();
		tab1.listaPracownikow();
		tab1.listaPlac();
		tab1.ileRobotnikow();
		tab1.ileUrzednikow();
		tab1.listaUrzednikow();
		tab1.listaRobotnikow();
		tab1.zwolnijPracownika("Adamski");
		tab1.zwolnijPracownika("Adamkowski");
		tab1.zwolnijPracownika("Janic");
		
}

}
