class Data {
	
	private int dzien;
	private int miesiac;
	private int rok;
	//private double wyr;
	
public Data() {
		
		dzien = 1;
		miesiac = 1;
		rok = 1582;
	}

public Data(int Dzien, int Miesiac, int Rok)
{
	dzien=Dzien;
	miesiac=Miesiac;
	rok=Rok;
}

public boolean isEarlier(Data data1)
{
	if(rok < data1.rok)
	{
		return true;
	}
	else if(miesiac < data1.miesiac && rok == data1.rok) return true;
	else if(dzien < data1.dzien && rok == data1.rok && miesiac == data1.miesiac) return true;
	else return false;
}

public boolean Przestepnosc() {
	
	if ((rok%4==0 && rok%100!=0)||(rok%400==0)) return true;
	else return false;
}

public int LiczbaDniMiesiaca() {
	if(miesiac%2==1 || miesiac%12==8) return 31;
	else if(miesiac%12==2 && ((rok%4==0 && rok%100!=0)||(rok%400==0))) return 28;
	else if(miesiac%12==2 && !((rok%4==0 && rok%100!=0)||(rok%400==0))) return 29;
	else return 30;
}

public boolean PoprawnoscDaty() {
	if(rok!=0)
	{
		if(0<miesiac && miesiac<13)
		{
			if(0<dzien && dzien<=LiczbaDniMiesiaca())
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	else return false;
}

public String DzienTygodnia() {
	double wyr = (Math.floor(2.6*(miesiac)-0.2)+dzien+(rok%100)+Math.floor((rok%100)/4)+Math.floor(rok/100)-2*(rok/100))%7;
	int i_wyr = (int)wyr;
	if(i_wyr<0)
	{
		i_wyr=i_wyr+7;
	}
	if(wyr==1)
	{
		return "Tego dnia byla niedziela";
	}
	else if(wyr==2)
	{
		return "Tego dnia byla poniedzialek";
	}
	else if(wyr==3)
	{
		return "Tego dnia byla wtorek";
	}
	else if(wyr==4)
	{
		return "Tego dnia byla sroda";
	}
	else if(wyr==5)
	{
		return "Tego dnia byla czwartek";
	}
	else if(wyr==6)
	{
		return "Tego dnia byla piatek";
	}
	else if(wyr==0)
	{
		return "Tego dnia byla sobota";
	}
	else return "Formula jest bledna cepie";
}
	
public int getDzien() {
	return dzien;
}

public int getMiesiac() {
	return miesiac;
}

public int getRok() {
	return rok;
}

public void setDzien(int dzien) {
	this.dzien = dzien;
}

public void setMiesiac(int miesiac) {
	this.miesiac = miesiac;
}

public void setRok(int rok) {
	this.rok = rok;
}

public void getStan() {
	System.out.println("Dzien : " + getDzien() + "\t" + "Miesiac : " 
+ getMiesiac() + "\t" + "Rok : " + getRok());
}

public void zmienDzien(int dzien, int n) {
	this.dzien=dzien + n;
}

public void zmienMiesiac(int miesiac, int n) {
	this.miesiac = miesiac + n;
}

public void zmienRok(int rok, int n) {
	this.rok = rok + n;
}

}
	
	public class Projekt_Daty {
		
		

	public static void main(String[] args) {
		
		Data data_domyslna = new Data();
		Data data1 = new Data(16, 5, 2016);
		
		data_domyslna.getStan();
		
		data_domyslna.zmienDzien(data_domyslna.getDzien(), 23);
		data_domyslna.zmienMiesiac(data_domyslna.getMiesiac(), 7);
		data_domyslna.zmienRok(data_domyslna.getRok(), 435);
		
		data_domyslna.getStan();
		
		System.out.println(data_domyslna.Przestepnosc());
		System.out.println(data_domyslna.LiczbaDniMiesiaca());
		System.out.println(data_domyslna.PoprawnoscDaty());
		System.out.println(data_domyslna.DzienTygodnia());
		System.out.println(data_domyslna.isEarlier(data1));
		
	}
	
}

