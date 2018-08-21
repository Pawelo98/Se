import java.util.ArrayList;

public class Woda {
private int wiek;
private double waga;
private double wzrost;
private String pleæ;
private double aktywnoœæ;
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

public String getPleæ() {
	return pleæ;
}

public void setPleæ(String pleæ) {
	this.pleæ = pleæ;
}

public double getAktywnoœæ() {
	return aktywnoœæ;
}

public void setAktywnoœæ(double aktywnoœæ) {
	this.aktywnoœæ = aktywnoœæ;
}

	public Woda() {
	super();
	this.wiek = wiek;
	this.waga = waga;
	this.wzrost = wzrost;
	this.pleæ = pleæ;
	this.aktywnoœæ = aktywnoœæ;
}

	public void przelicznik() {
	
		if (getPleæ().equalsIgnoreCase("kobieta")) {
			if(wiek<=30) {
				
			double woda = ((waga*40)/28.3)*0.0284;
		setWysilek( (woda + (aktywnoœæ/30)*12*0.0284));
			
			}
			
			if(wiek>30&&wiek<50) {
				double woda = ((waga*35)/28.3)*0.0284;
				setWysilek( (woda + (aktywnoœæ/30)*12*0.0284));
					

			}
			if(wiek<=50) {
				double woda = ((waga*30)/28.3)*0.0284;
				setWysilek( (woda + (aktywnoœæ/30)*12*0.0284));
					
				
				
			}
			
				} //koniec if z kobieta
		
		else if (getPleæ().equalsIgnoreCase("mê¿czyzna")) {
			
			if(wiek<=30) {
				
				double woda = ((waga*40)/28.3)*0.0284;
			setWysilek( (woda + (aktywnoœæ/30)*12*0.0284));
				
				}
				
				if(wiek>30&&wiek<50) {
					double woda = ((waga*35)/28.3)*0.0284;
					setWysilek( (woda + (aktywnoœæ/30)*12*0.0284));
						
					
					
					
				}
				if(wiek<=50) {
					double woda = ((waga*30)/28.3)*0.0284;
					setWysilek( (woda + (aktywnoœæ/30)*12*0.0284));
					
				}
			
		} //koniec if z mê¿czyzn¹
			
		
		else {
			
			System.out.println("Prosze wprowadziæ poprawn¹ p³eæ");
		}
		
	
	
		
	} // koniec metody
	
	public Woda(double wysilek) {
		super();
		this.wysilek = wysilek;
	}

} //koniec klasy


