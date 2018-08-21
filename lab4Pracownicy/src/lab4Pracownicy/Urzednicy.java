package lab4Pracownicy;

public class Urzednicy extends Pracownik {
	
	double pensja;
	double indPremia;
	double podstawowa;
	
	public Urzednicy(String nazwisko, double etat, double indPremia, double podstawowa) 
	{
		super(nazwisko, etat);
		this.indPremia = indPremia/100.0;
		this.podstawowa = podstawowa;
	}
	
	public String toString() {
		return("Urzednik : "+"\n" +super.toString()+ "\t" +"Stawka za etat : " + podstawowa + "\t" +"Premia : "+ indPremia +"\n");
		
	}
	
	public double getPensja()
	{
		return pensja;
	}
	
	public void getStan()
	{
		System.out.print(" " + getPensja());
	}
	
	public double setPensja()
	{
		return pensja = podstawowa + (podstawowa * indPremia);
	}

}
