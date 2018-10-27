package prob1;

import java.util.Calendar;

public class Cont implements Operatiuni{
    private String numarCont;
    private float suma = 0;
    private String moneda;
    private Calendar data_deschiderii = Calendar.getInstance();
    private Calendar data_ultimei_operatiuni;

    public Cont(String numarCont, float suma, String moneda, Calendar data_deschiderii, Calendar data_ultimei_operatiuni){
        this.numarCont = numarCont;
        this.suma = suma;
        this.moneda = moneda;
        this.data_deschiderii = data_deschiderii;
        this.data_ultimei_operatiuni = data_ultimei_operatiuni;
    }

    @Override
    public float calculeaza_dobanda() {
        float dobanda = 0;
        Calendar today = Calendar.getInstance();
        int days = (int)(today.getTimeInMillis() - data_ultimei_operatiuni.getTimeInMillis())/(86400000);
        if(moneda.toUpperCase().equals("RON")){
            if(suma <= 500){
                dobanda = (float) (0.3*(days));
            }
            if(suma > 500){
                dobanda = (float) (0.8*(days));
            }
        }
        if(moneda.toUpperCase().equals("EUR")){
            dobanda = (float) (0.1*days);
        }

        return dobanda;
    }

    @Override
    public float actualizare_suma() {

        suma += calculeaza_dobanda();
        data_ultimei_operatiuni = Calendar.getInstance();
        return suma;
    }

    @Override
    public void depunere(float suma) {
        this.suma += suma;
    }

    @Override
    public void extragere(float suma) {
        this.suma -= suma;
    }

    public String getNumarCont() {
        return numarCont;
    }

    public void setNumarCont(String numarCont) {
        this.numarCont = numarCont;
    }

    public float getSuma() {
        return suma;
    }

    public void setSuma(float suma) {
        this.suma = suma;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Calendar getData_deschiderii() {
        return data_deschiderii;
    }

    public void setData_deschiderii(Calendar data_deschiderii) {
        this.data_deschiderii = data_deschiderii;
    }

    public Calendar getData_ultimei_operatiuni() {
        return data_ultimei_operatiuni;
    }

    public void setData_ultimei_operatiuni(Calendar data_ultimei_operatiuni) {
        this.data_ultimei_operatiuni = data_ultimei_operatiuni;
    }

    @Override
    public String toString() {
        return "Numar cont: " + numarCont + "\n" +
                "Suma curenta: " + this.suma + "\n" +
                "Moneda: " + moneda + "\n" +
                "Data deschidere: " + data_deschiderii.get(Calendar.DAY_OF_WEEK_IN_MONTH) + "/" + (data_deschiderii.get(Calendar.MONTH) + 1) + "/" + data_deschiderii.get(Calendar.YEAR) + "\n" +
                "Data ultimei operatiuni: " + data_ultimei_operatiuni.get(Calendar.DAY_OF_WEEK_IN_MONTH) + "/" + (data_ultimei_operatiuni.get(Calendar.MONTH) + 1) + "/" + data_ultimei_operatiuni.get(Calendar.YEAR) + "\n";
    }
}
