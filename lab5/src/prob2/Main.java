package prob2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean gata = false;
        do{
            try {
                System.out.println("Primul numar: ");
                int firstNum = Integer.parseInt(reader.readLine());
                System.out.println("Al doilea numar: ");
                int secondNum = Integer.parseInt(reader.readLine());
                if(firstNum > secondNum){
                    throw new InequalityException();
                }
                else{
                    gata = true;
                    System.out.println("Yey");
                }
            } catch (InequalityException e) {
                System.out.println(e);
            }
        }while(!gata);

        // fara scriere in fisier
    }
}
