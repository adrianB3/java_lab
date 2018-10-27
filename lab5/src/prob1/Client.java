package prob1;

import java.util.ArrayList;

public class Client {
    private String nume;
    private String adresa;
    private ArrayList<Cont> conturi;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public ArrayList<Cont> getConturi() {
        return conturi;
    }

    public void setConturi(ArrayList<Cont> conturi) {
        this.conturi = conturi;
    }

    public Client(String nume, String adresa, ArrayList<Cont> conturi) throws Exception {
        this.nume = nume;
        this.adresa = adresa;
        if (conturi.size() < 1 || conturi.size() > 5){
            throw new Exception("Nr conturi invalid");
        }
        this.conturi = conturi;
    }

    @Override
    public String toString() {
        String str = " ";
        str += "Nume client: " + nume + "\n" + "Adresa: " + adresa + "\n";
        str += "Conturi: \n";
        for(var cont : conturi){
            str += cont + "\n";
        }

        return str;
    }
}
