package subiect_test1;

public class Persoana {
	private String nume;
	private int varsta;
	
	public Persoana(String nume, int varsta) {
		this.nume = nume;
		this.varsta = varsta;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	@Override
	public String toString() {
		return "Nume: " + nume + "\n" + "Varsta: " + varsta + "\n";
	}
}
