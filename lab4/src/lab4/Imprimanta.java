package lab4;

public class Imprimanta extends Echipament {
	public Imprimanta(String denumire, int nr_inventar, double pret,
			String zona_mag, stare st, double ppm, String dpi, int p_car, mod_scriere ms) {
		super(denumire, nr_inventar, pret, zona_mag, st);
		this.ppm = ppm;
		this.dpi = dpi;
		this.p_car = p_car;
		this.ms = ms;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "Imprimanta [ppm=" + ppm + ", dpi=" + dpi + ", p_car=" + p_car
				+ ", ms=" + ms + "]";
	}


	public double getPpm() {
		return ppm;
	}
	public void setPpm(double ppm) {
		this.ppm = ppm;
	}
	public String getDpi() {
		return dpi;
	}
	public void setDpi(String dpi) {
		this.dpi = dpi;
	}
	public int getP_car() {
		return p_car;
	}
	public void setP_car(int p_car) {
		this.p_car = p_car;
	}

	public mod_scriere getMs() {
		return ms;
	}


	public void setMs(mod_scriere ms) {
		this.ms = ms;
	}

	private double ppm;
	private String dpi;
	private int p_car;
	private mod_scriere ms;
	
}
