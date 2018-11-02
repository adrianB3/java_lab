package prob1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("width: ");
		double width = Double.parseDouble(reader.readLine());
		System.out.print("height: ");
		double height = Double.parseDouble(reader.readLine());
		
		Dreptunghi d = new Dreptunghi(width, height);
		
		System.out.printf("Perimeter: %.2f \n", d.Perimetru());
        System.out.printf("Area: %.2f \n", d.Aria());
	}
}
