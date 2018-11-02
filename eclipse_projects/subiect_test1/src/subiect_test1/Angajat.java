package subiect_test1;

public class Angajat extends Persoana {

	private double salariu;
	private int vechime;
	
	public Angajat(String nume, int varsta, double salariu, int vechime) {
		super(nume, varsta);
		this.salariu = salariu;
		this.vechime = vechime;
	}

	public double getSalariu() {
		return salariu;
	}

	public void setSalariu(double salariu) {
		this.salariu = salariu;
	}

	public int getVechime() {
		return vechime;
	}

	public void setVechime(int vechime) {
		this.vechime = vechime;
	}

	@Override
	public String toString() {
		return super.toString() + "Salariu: " + salariu + "\n" + "Vechime: " + vechime + "\n";
	}
}
