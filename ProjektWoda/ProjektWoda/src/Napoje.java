import java.util.ArrayList;
import java.util.Scanner;

public class Napoje extends Woda {
private double woda;
private double kofeina;
private double kalorie;
private int napój;
private String nazwa;
private double iloscWody;
private double iloœæKalorii;
private double iloœæKofeiny;
public Napoje() {
	super();
	this.woda = woda;
	this.kofeina = kofeina;
	this.kalorie = kalorie;
	this.napój = napój;
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
public double getNapój() {
	return napój;
}
public void setNapój(double napój) {
	this.napój = (int) napój;
}
public double getIloscWody() {
	return iloscWody;
}
public void setIloscWody(double iloscWody) {
	this.iloscWody = iloscWody;
}
public double getIloœæKalorii() {
	return iloœæKalorii;
}
public void setIloœæKalorii(double iloœæKalorii) {
	this.iloœæKalorii = iloœæKalorii;
}
public double getIloœæKofeiny() {
	return iloœæKofeiny;
}
public void setIloœæKofeiny(double iloœæKofeiny) {
	this.iloœæKofeiny = iloœæKofeiny;
}
public String getNazwa() {
	return nazwa;
}
public void setNazwa(String nazwa) {
	this.nazwa = nazwa;
}
public void printInfo() {
	System.out.println("Nazwa: " + nazwa );
	System.out.println("iloœæ: "+ woda);
	System.out.println("Iloœæ kalorii: " + iloœæKalorii );
}
/*private ArrayList<String> napoje = new ArrayList<>();
private ArrayList<Double> ilosc = new ArrayList<>();

public void dodajNapoj(String napój, double iloœæ) {
	napoje.add(napój);
	ilosc.add(iloœæ);
}
	public void drukujNapoje() {
		for (int i = 0; i < napoje.size(); i++) {
		System.out.println("napoje: " + napoje.get(i) + " iloœæ: " +
		ilosc.get(i));
*/	
public void przeliczanieNapoju() {

	if(napój == 1) {
	 nazwa = "woda";
	 iloscWody = woda;
	 iloœæKalorii = 0;
	 iloœæKofeiny = 0;
	
	}
	
	if(napój == 2) {
		 nazwa = "kawa";
		 iloscWody = woda*0.985;
		 iloœæKalorii = (woda*2)/100;
		iloœæKofeiny = (woda*40)/100;
		}	
	if(napój == 3) {
		nazwa = "herbata";
		 iloscWody = woda*0.985;
		 iloœæKalorii = (woda*4)/100;
		 iloœæKofeiny = (woda*11)/100;
		
	}
	if(napój == 4) {
		nazwa = "wódka";
		 iloscWody = -2*woda*0.6;
		 iloœæKalorii = (woda*231)/100;
		 iloœæKofeiny = 0;
		
	}
	if(napój == 5) {
		nazwa = "piwo";
		 iloscWody = -0.5*woda*0.9;
		 iloœæKalorii = (woda*58)/100;
		 iloœæKofeiny = 0;
	}
	if(napój == 6) {
		nazwa = "wino";
		 iloscWody = -0.5*woda*0.82;
		 iloœæKalorii = (woda*83)/100;
		 iloœæKofeiny = 0;
	}
	if(napój == 7) {
		nazwa = "sok";
		 iloscWody = woda*0.82;
		 iloœæKalorii = (woda*48)/100;
		 iloœæKofeiny = 0;
	}
	if(napój == 8) {
		nazwa = "cola";
		 iloscWody = woda*0.89;
		 iloœæKalorii = (woda*37)/100;
		 iloœæKofeiny = (woda*12)/100;
	}
	if(napój == 9) {
		nazwa = "napój gazowany";
		 iloscWody = woda*0.89;
		 iloœæKalorii = (woda*44)/100;
		 iloœæKofeiny = 0;	
		}
	if(napój == 10) {
		nazwa = "mleko";
		 iloscWody = woda*0.85;
		 iloœæKalorii = (woda*53)/100;
		 iloœæKofeiny = 0;	
		}
	
}


}


