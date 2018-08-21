
public class Szybkie_potegowanie {
	
	double potega(double podstawa, int wykladnik)
	{
		if(wykladnik==0) return 1.0;
		if(wykladnik%2==1) return podstawa*potega(podstawa,(wykladnik-1)/2);
		else return potega(podstawa,wykladnik/2)*potega(podstawa,wykladnik/2);
	}
	
	int fibRek(int n)
	{
		if(n==0) return 0;
		if(n==1) return 1;
		else return fibRek(n-1)+fibRek(n-2);
	}
	
	double fibWzo(int n)
	{
		return 1/(Math.sqrt(5))*(Math.pow(((1+Math.sqrt(5))/2),n)-Math.pow(((1-Math.sqrt(5))/2),n));
	}
	
	int ackermann(int a, int b)
	{
		if(a==0) return b+1;
		if(b==0 && a!=0) return ackermann(a-1, 1);
		else return ackermann(a-1,ackermann(a, b-1));
	}

	public static void main(String[] args) {
		
		Szybkie_potegowanie s = new Szybkie_potegowanie();
		
		System.out.printf("%s %.2f", "Wynik szybkiego potegowania: ", s.potega(3.4, 5));
		System.out.println("\n");
		System.out.println("Wynik dla ciagu Fibbonacciego rekurencyjnie: " + s.fibRek(7) + "\n");
		
		System.out.printf("%s %.2f", "Wynik dla ciagu Fibbonacciego wzorem: ", s.fibWzo(7));
		System.out.println("\n");
		System.out.println("Wynik funkcji Ackermanna: " + s.ackermann(3, 5) + "\n");

	}

}
