package lab4;

public class Copiator extends Echipament {

	public Copiator(String denumire, int nr_inventar, double pret,
			String zona_mag, stare st, double ppm, double p_ton, format_copiere fc) {
		super(denumire, nr_inventar, pret, zona_mag, st);
		this.ppm = ppm;
		this.p_ton = p_ton;
		this.fc = fc;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "Copiator [ppm=" + ppm + ", p_ton=" + p_ton + ", fc=" + fc + "]";
	}


	public double getPpm() {
		return ppm;
	}
	public void setPpm(double ppm) {
		this.ppm = ppm;
	}
	public double getP_ton() {
		return p_ton;
	}
	public void setP_ton(double p_ton) {
		this.p_ton = p_ton;
	}
	public format_copiere getFc() {
		return fc;
	}
	public void setFc(format_copiere fc) {
		this.fc = fc;
	}

	private double ppm;
	private double p_ton;
	private format_copiere fc;

}
