import java.util.ArrayList;

public class Woda {
private int wiek;
private double waga;
private double wzrost;
private String ple�;
private double aktywno��;
private double wysilek;
ArrayList<Napoje> listaNapojow = new ArrayList<>();	

	public ArrayList<Napoje> getListaNapojow() {
	return listaNapojow;
}

public void setListaNapojow(ArrayList<Napoje> listaNapojow) {
	this.listaNapojow = listaNapojow;
}

	public int getWiek() {
	return wiek;
}

public double getWysilek() {
		return wysilek;
	}

	public void setWysilek(double wysilek) {
		this.wysilek = wysilek;
	}

public void setWiek(int wiek) {
	this.wiek = wiek;
}

public double getWaga() {
	return waga;
}

public void setWaga(double waga) {
	this.waga = waga;
}

public double getWzrost() {
	return wzrost;
}

public void setWzrost(double wzrost) {
	this.wzrost = wzrost;
}

public String getPle�() {
	return ple�;
}

public void setPle�(String ple�) {
	this.ple� = ple�;
}

public double getAktywno��() {
	return aktywno��;
}

public void setAktywno��(double aktywno��) {
	this.aktywno�� = aktywno��;
}

	public Woda() {
	super();
	this.wiek = wiek;
	this.waga = waga;
	this.wzrost = wzrost;
	this.ple� = ple�;
	this.aktywno�� = aktywno��;
}

	public void przelicznik() {
	
		if (getPle�().equalsIgnoreCase("kobieta")) {
			if(wiek<=30) {
				
			double woda = ((waga*40)/28.3)*0.0284;
		setWysilek( (woda + (aktywno��/30)*12*0.0284));
			
			}
			
			if(wiek>30&&wiek<50) {
				double woda = ((waga*35)/28.3)*0.0284;
				setWysilek( (woda + (aktywno��/30)*12*0.0284));
					

			}
			if(wiek<=50) {
				double woda = ((waga*30)/28.3)*0.0284;
				setWysilek( (woda + (aktywno��/30)*12*0.0284));
					
				
				
			}
			
				} //koniec if z kobieta
		
		else if (getPle�().equalsIgnoreCase("m�czyzna")) {
			
			if(wiek<=30) {
				
				double woda = ((waga*40)/28.3)*0.0284;
			setWysilek( (woda + (aktywno��/30)*12*0.0284));
				
				}
				
				if(wiek>30&&wiek<50) {
					double woda = ((waga*35)/28.3)*0.0284;
					setWysilek( (woda + (aktywno��/30)*12*0.0284));
						
					
					
					
				}
				if(wiek<=50) {
					double woda = ((waga*30)/28.3)*0.0284;
					setWysilek( (woda + (aktywno��/30)*12*0.0284));
					
				}
			
		} //koniec if z m�czyzn�
			
		
		else {
			
			System.out.println("Prosze wprowadzi� poprawn� p�e�");
		}
		
	
	
		
	} // koniec metody
	
	public Woda(double wysilek) {
		super();
		this.wysilek = wysilek;
	}

} //koniec klasy


