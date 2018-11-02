package subiect_test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) throws IOException {
		Angajat Ionel = new Angajat("Ionel",22, 2200.5,3);
		System.out.println(Ionel);
		Somer Daniel = new Somer("Daniel", 30, Calendar.getInstance().getTime());
		System.out.println(Daniel);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
		String vechime = reader.readLine();
		if(vechime != (int)vechime) {
			throw new InvalidInputforVechime();
		}
		}
		catch(InvalidInputforVechime v) {
			System.out.println(v);
		}
	}
}
