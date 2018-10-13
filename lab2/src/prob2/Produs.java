package prob2;

public class Produs implements Comparable<Produs>{
    private String denumire;
    private double pret;
    private double cantitate;

    public Produs(String denumire, double pret, double cantitate){
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return new String(denumire + "| " + pret + "| " + cantitate);
    }

    @Override
    public int compareTo(Produs produs) {
        if(pret > produs.pret) return 1;
        if(pret < produs.pret) return -1;
        else
            return 0;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public double getCantitate() {
        return cantitate;
    }

    public void setCantitate(double cantitate) {
        this.cantitate = cantitate;
    }
}
