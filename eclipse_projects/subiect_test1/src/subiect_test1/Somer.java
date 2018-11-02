package subiect_test1;

import java.util.Date;

public class Somer extends Persoana {

	private Date data_somaj;
	
	public Somer(String nume, int varsta, Date data_somaj) {
		super(nume, varsta);
		this.data_somaj = data_somaj;
	}

	public Date getData_somaj() {
		return data_somaj;
	}

	public void setData_somaj(Date data_somaj) {
		this.data_somaj = data_somaj;
	}

	@Override
	public String toString() {
		return super.toString() + "data_somaj=" + data_somaj + "\n";
	}
}
