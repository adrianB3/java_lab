package lab4;

public class EchipamentCalcul extends Echipament {

	public EchipamentCalcul(String denumire, int nr_inventar, double pret,
			String zona_mag, stare st, String tip_monitor, double vit_proc, double c_hdd, sis_operare so) {
		super(denumire, nr_inventar, pret, zona_mag, st);
		this.tip_monitor = tip_monitor;
		this.vit_proc = vit_proc;
		this.c_hdd = c_hdd;
		this.so = so;
	}

	
	
	@Override
	public String toString() {
		return super.toString() + "EchipamentCalcul [tip_monitor=" + tip_monitor + ", vit_proc="
				+ vit_proc + ", c_hdd=" + c_hdd + ", so=" + so + "]";
	}



	public String getTip_monitor() {
		return tip_monitor;
	}
	public void setTip_monitor(String tip_monitor) {
		this.tip_monitor = tip_monitor;
	}
	public double getVit_proc() {
		return vit_proc;
	}
	public void setVit_proc(double vit_proc) {
		this.vit_proc = vit_proc;
	}
	public double getC_hdd() {
		return c_hdd;
	}
	public void setC_hdd(double c_hdd) {
		this.c_hdd = c_hdd;
	}
	public sis_operare getSo() {
		return so;
	}
	public void setSo(sis_operare so) {
		this.so = so;
	}

	private String tip_monitor;
	private double vit_proc;
	private double c_hdd;
	private sis_operare so;
}
