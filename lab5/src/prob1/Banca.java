package prob1;

import java.util.ArrayList;

public class Banca {
    private String denumire_banca;
    private ArrayList<Client> clienti;

    public Banca(String denumire_banca, ArrayList<Client> clienti){
        this.denumire_banca = denumire_banca;
        this.clienti = clienti;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Denumire banca: " + denumire_banca + "\n";
        str += "Clienti: \n";
        for(var client : clienti){
            str += client.toString() + "\n";
        }
        return str;
    }

    public String getDenumire_banca() {
        return denumire_banca;
    }

    public void setDenumire_banca(String denumire_banca) {
        this.denumire_banca = denumire_banca;
    }

    public ArrayList<Client> getClienti() {
        return clienti;
    }

    public void setClienti(ArrayList<Client> clienti) {
        this.clienti = clienti;
    }
}
