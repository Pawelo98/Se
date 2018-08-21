package lab5Treeset;

import lab5Treeset.Pracownik;

public class Robotnicy extends Pracownik {
	
	double stawka;
	double przepracowanych;
	double pensja;
	double limit = 168.0;
	
	public Robotnicy(String nazwisko, double etat, double stawka, double przepracowanych) {
		super(nazwisko, etat);
		this.stawka = stawka;
		this.przepracowanych = przepracowanych;
	}
	
	public double getPensja() {
		return pensja;
	}
	
	public void getStan() {
		getStan();
		System.out.print(" "+ getPensja());
	}
	
	public double setPensja() {
		if (limit<przepracowanych) {
			return this.pensja = limit*stawka + (przepracowanych-limit)*stawka*1.5;
		}
		else 
			return this.pensja = przepracowanych *stawka;
	}
	
	public String toString() {
		return("Robotnik " + super.toString() + "\n" );
	}
}

