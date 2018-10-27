package prob1;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws Exception {
        Calendar today = Calendar.getInstance();
        Banca ing = new Banca("ING", new ArrayList<Client>());
        Client Ion = new Client("Ion", "Adresa lui Ion",
                new ArrayList<Cont>(){
            {
                add( new Cont("RO123123123",0,"RON", today, today));
            }
        });
        ing.getClienti().add(Ion);

        Ion.getConturi().get(0).depunere(15);

        System.out.println(Ion);
    }
}
