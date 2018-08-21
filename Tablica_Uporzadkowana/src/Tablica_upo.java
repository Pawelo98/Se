
public class Tablica_upo {
	
	private int[] tab;
	private int wielkosc = 100;
	
	public Tablica_upo(int n)
	{
		tab = new int[n];
	}

	public void getStan()
	{
		for(int i=0; i<wielkosc; i++)
		{
			System.out.println("Tab[i]: " + tab[i]);
		}
	}
	
	public void setStan()
	{
		for(int i=0; i<wielkosc; i++)
		{
			this.tab[i] = (2*i)+1;
		}
	}

	//metody
	
	public void wstawElement(int msc, int war)
	{
		for(int i = wielkosc; msc<i; i--)
		{
			tab[i] = tab[i+1];
		}
		tab[msc] = war;
	}
	
	public void usunElement(int msc)
	{
		for(int i = wielkosc; msc<i; i--)
		{
			tab[i-1] = tab[i-2];
		}
		tab[msc] = tab[wielkosc-1];
		wielkosc--;
	}
	
	public void usunWartosc(int war)
	{
		for(int i=wielkosc; 0<i; i--)
		{
			if(tab[i]==war)
			{
				usunElement(i);
				break;
			}
		}
	}
	
	public void usunWszystkie(int x)
	{
		for(int i=wielkosc; 0<i; i--)
		{
			if(tab[i]==x)
			{
				usunElement(i);
			}
		}
	}
	
	// reszta w klasie Tablica
	
	public static void main(String[] args) {
		
		Tablica_upo tab1 = new Tablica_upo(100);
		
		tab1.wstawElement(3, 14);
		tab1.usunElement(5);
		tab1.usunWartosc(11);
		tab1.usunWszystkie(14);

	}

}
