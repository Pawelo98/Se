import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
public static void main(String[] args) {
	Woda w1 = new Woda();

	System.out.println("Wybierz p³eæ: ");
	Scanner klawiatura = new Scanner(System.in);
	w1.setPleæ( klawiatura.nextLine());
	w1.getPleæ();

	
	System.out.println("Wpisz wiek: ");
	Scanner klawiatura1 = new Scanner(System.in);
	w1.setWiek(klawiatura1.nextInt());
	w1.getWiek();

	
	System.out.println("Wpisz waga w kg: ");
	Scanner klawiatura2 = new Scanner(System.in);
	w1.setWaga(klawiatura2.nextDouble());
	w1.getWaga();
	
	System.out.println("Wpisz wzrost w cm: ");
	Scanner klawiatura3 = new Scanner(System.in);
	w1.setWzrost (klawiatura3.nextDouble());
	w1.getWzrost();

	System.out.println("Podaj aktywnosc w dniu dzisiejszym w minutach :");
	Scanner klawiatura4 = new Scanner(System.in);
	w1.setAktywnoœæ( klawiatura4.nextDouble());
	w1.getAktywnoœæ();
	w1.przelicznik();

	System.out.format("Iloœæ zapotrzebowania wody na dziœ w litrach " + "%.2f%n",w1.getWysilek());
	
	ArrayList<Napoje> listaNapojow = w1.getListaNapojow();
	for(int i=0; i<5; i++) {
	Napoje n1 = new Napoje();
	
	

	System.out.println("Dostêpne napoje do wpisania: \n 1. Woda \n 2.Kawa \n 3. Herbata \n 4. Wódka \n 5. Piwo \n 6. Wino \n 7. Soki \n 8. Cola \n 9. Napoje gazowanie \n 10. Mleko  ");
	System.out.println("Wpisz numer napoju: ");
	Scanner klawiatura5 = new Scanner(System.in);
	n1.setNapój (klawiatura5.nextDouble());
	n1.getNapój();

	
	System.out.println("Iloœæ wypitego napoju w mililitrach: ");
	Scanner klawiatura6 = new Scanner(System.in);
	n1.setWoda(klawiatura6.nextDouble());
	n1.getWoda();
	
	

	listaNapojow.add(n1);
	}
	double sumaW = 0;
	double sumaKa = 0;
	double sumaKo = 0;
	
	for(Napoje n:listaNapojow) {
		//System.out.println(n.getNapój());
		//System.out.println(n.getWoda());
		n.przeliczanieNapoju();
		//n.printInfo();
		sumaW+=n.getIloscWody();
		sumaKa+=n.getIloœæKalorii();
		sumaKo+=n.getIloœæKofeiny();
		
		
		//n.printInfo();
		
	}
	
	System.out.println("Iloœæ wypitych napojów " + sumaW/1000 + " l");
	System.out.println("Iloœæ spo¿ytych kalorii " + sumaKa + "kcl");
	System.out.println("Iloœæ spo¿ytej kofeiny " + sumaKo + "mg");
}
}
