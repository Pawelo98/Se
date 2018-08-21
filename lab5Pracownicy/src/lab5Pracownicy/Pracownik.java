package lab5Pracownicy;

import lab5Pracownicy.Pracownik;

abstract public class Pracownik {
	
	String nazwisko;
	double etat;
	
	public Pracownik(String nazwisko, double etat)
	{
		this.nazwisko = nazwisko;
		this.etat = etat;
	}
	
	abstract public double setPensja();
	
	public String getNazwisko()
	{
		return nazwisko;
	}
	
	public double getEtat()
	{
		return etat;
	}
	
	public void getStan() {
		System.out.print(getNazwisko() + " " + getEtat());
	}
	
	public boolean equals (Pracownik p) {
		Pracownik p1 = (Pracownik) p;
		return (getNazwisko().equals(p1.getNazwisko()));
	}
	
	public String toString() {
		return (this.nazwisko+ "\t" + this.etat + "\t" + setPensja());
	}
	
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public void setEtat(double etat) {
		this.etat = etat;
	}
	
	public int compareTo(Pracownik p) {
		int porownanienazwiska = nazwisko.compareTo(p.nazwisko);
		return porownanienazwiska;
	}

}
