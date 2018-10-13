package prob2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Produs> listaProduse = new ArrayList<>();

        TextFileReader reader = new TextFileReader("produse.txt");
        String line;
        while((line = reader.readLine()) != null){
            listaProduse.add(ProductParser.Parse(line));
        }

        System.out.println("Denumire|Pret|Cantitate");
        for (Produs produs : listaProduse){
            System.out.println(produs);
        }

        TextFileWriter writer = new TextFileWriter("pretminmax.txt");
        writer.writeLine("Pret min : " + Collections.min(listaProduse));
        writer.writeLine("Pret max : " + Collections.max(listaProduse));

        double cantitate;
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Cantitate : ");
        cantitate = Double.parseDouble(reader1.readLine());

        for (Produs prod : listaProduse){
            if(prod.getCantitate() < cantitate){
                System.out.println(prod);
            }
        }
    }
}
