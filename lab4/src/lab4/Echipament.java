package lab4;

public class Echipament {
	
	public Echipament(String denumire, int nr_inventar, double pret, String zona_mag, stare st){
		this.denumire = denumire;
		this.nr_inventar = nr_inventar;
		this.pret = pret;
		this.zona_mag = zona_mag;
		this.st = st;
	}
	
	
	
	@Override
	public String toString() {
		return "Echipament [denumire=" + denumire + ", nr_inventar="
				+ nr_inventar + ", pret=" + pret + ", zona_mag=" + zona_mag
				+ ", st=" + st + "]";
	}



	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public int getNr_inventar() {
		return nr_inventar;
	}
	public void setNr_inventar(int nr_inventar) {
		this.nr_inventar = nr_inventar;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}
	public String getZona_mag() {
		return zona_mag;
	}
	public void setZona_mag(String zona_mag) {
		this.zona_mag = zona_mag;
	}
	public stare getSt() {
		return st;
	}
	public void setSt(stare st) {
		this.st = st;
	}
	private String denumire;
	private int nr_inventar;
	private double pret;
	private String zona_mag;
	private stare st;
}
