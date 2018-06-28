public interface Iterator<Pracownik>{

    public void poprzedni();
    public void nastepny();
    public void pierwszy();
    public void ostatni();
    public boolean jestWZakresie();
    public Pracownik elementBiezacy();
}
