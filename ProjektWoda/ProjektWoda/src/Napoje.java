import java.util.ArrayList;
import java.util.Scanner;

public class Napoje extends Woda {
private double woda;
private double kofeina;
private double kalorie;
private int nap�j;
private String nazwa;
private double iloscWody;
private double ilo��Kalorii;
private double ilo��Kofeiny;
public Napoje() {
	super();
	this.woda = woda;
	this.kofeina = kofeina;
	this.kalorie = kalorie;
	this.nap�j = nap�j;
}
public double getWoda() {
	return woda;
}
public void setWoda(double woda) {
	this.woda = woda;
}
public double getKofeina() {
	return kofeina;
}
public void setKofeina(double kofeina) {
	this.kofeina = kofeina;
}
public double getKalorie() {
	return kalorie;
}
public void setKalorie(double kalorie) {
	this.kalorie = kalorie;
}
public double getNap�j() {
	return nap�j;
}
public void setNap�j(double nap�j) {
	this.nap�j = (int) nap�j;
}
public double getIloscWody() {
	return iloscWody;
}
public void setIloscWody(double iloscWody) {
	this.iloscWody = iloscWody;
}
public double getIlo��Kalorii() {
	return ilo��Kalorii;
}
public void setIlo��Kalorii(double ilo��Kalorii) {
	this.ilo��Kalorii = ilo��Kalorii;
}
public double getIlo��Kofeiny() {
	return ilo��Kofeiny;
}
public void setIlo��Kofeiny(double ilo��Kofeiny) {
	this.ilo��Kofeiny = ilo��Kofeiny;
}
public String getNazwa() {
	return nazwa;
}
public void setNazwa(String nazwa) {
	this.nazwa = nazwa;
}
public void printInfo() {
	System.out.println("Nazwa: " + nazwa );
	System.out.println("ilo��: "+ woda);
	System.out.println("Ilo�� kalorii: " + ilo��Kalorii );
}
/*private ArrayList<String> napoje = new ArrayList<>();
private ArrayList<Double> ilosc = new ArrayList<>();

public void dodajNapoj(String nap�j, double ilo��) {
	napoje.add(nap�j);
	ilosc.add(ilo��);
}
	public void drukujNapoje() {
		for (int i = 0; i < napoje.size(); i++) {
		System.out.println("napoje: " + napoje.get(i) + " ilo��: " +
		ilosc.get(i));
*/	
public void przeliczanieNapoju() {

	if(nap�j == 1) {
	 nazwa = "woda";
	 iloscWody = woda;
	 ilo��Kalorii = 0;
	 ilo��Kofeiny = 0;
	
	}
	
	if(nap�j == 2) {
		 nazwa = "kawa";
		 iloscWody = woda*0.985;
		 ilo��Kalorii = (woda*2)/100;
		ilo��Kofeiny = (woda*40)/100;
		}	
	if(nap�j == 3) {
		nazwa = "herbata";
		 iloscWody = woda*0.985;
		 ilo��Kalorii = (woda*4)/100;
		 ilo��Kofeiny = (woda*11)/100;
		
	}
	if(nap�j == 4) {
		nazwa = "w�dka";
		 iloscWody = -2*woda*0.6;
		 ilo��Kalorii = (woda*231)/100;
		 ilo��Kofeiny = 0;
		
	}
	if(nap�j == 5) {
		nazwa = "piwo";
		 iloscWody = -0.5*woda*0.9;
		 ilo��Kalorii = (woda*58)/100;
		 ilo��Kofeiny = 0;
	}
	if(nap�j == 6) {
		nazwa = "wino";
		 iloscWody = -0.5*woda*0.82;
		 ilo��Kalorii = (woda*83)/100;
		 ilo��Kofeiny = 0;
	}
	if(nap�j == 7) {
		nazwa = "sok";
		 iloscWody = woda*0.82;
		 ilo��Kalorii = (woda*48)/100;
		 ilo��Kofeiny = 0;
	}
	if(nap�j == 8) {
		nazwa = "cola";
		 iloscWody = woda*0.89;
		 ilo��Kalorii = (woda*37)/100;
		 ilo��Kofeiny = (woda*12)/100;
	}
	if(nap�j == 9) {
		nazwa = "nap�j gazowany";
		 iloscWody = woda*0.89;
		 ilo��Kalorii = (woda*44)/100;
		 ilo��Kofeiny = 0;	
		}
	if(nap�j == 10) {
		nazwa = "mleko";
		 iloscWody = woda*0.85;
		 ilo��Kalorii = (woda*53)/100;
		 ilo��Kofeiny = 0;	
		}
	
}


}


