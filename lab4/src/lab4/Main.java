package lab4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<Echipament> inventar = new ArrayList<Echipament>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("echipamente.txt")));
		String line;
		
		while((line = reader.readLine()) != null){
			String[] lineArgs = line.split(";");
			if(lineArgs[5].toLowerCase().equals("imprimanta")){
				inventar.add(new Imprimanta(
						lineArgs[0], 
						Integer.parseInt(lineArgs[1]), 
						Double.parseDouble(lineArgs[2]),
								lineArgs[3],
								stare.valueOf(lineArgs[4]), 
								Double.parseDouble(lineArgs[6].toLowerCase()), 
								lineArgs[7], 
								Integer.parseInt(lineArgs[8]),
								mod_scriere.valueOf(lineArgs[9].toLowerCase())
								));
			}
			
			if(lineArgs[5].toLowerCase().equals("copiator")){
				inventar.add(new Copiator(
						lineArgs[0], 
						Integer.parseInt(lineArgs[1]), 
						Double.parseDouble(lineArgs[2]),
								lineArgs[3],
								stare.valueOf(lineArgs[4]), 
								Double.parseDouble(lineArgs[6]), 
								Double.parseDouble(lineArgs[7]), 
								format_copiere.valueOf(lineArgs[8])
								));
			}
			
			if(lineArgs[5].toLowerCase().equals("sistem de calcul")){
				inventar.add(new EchipamentCalcul(
						lineArgs[0], 
						Integer.parseInt(lineArgs[1]), 
						Double.parseDouble(lineArgs[2]),
								lineArgs[3],
								stare.valueOf(lineArgs[4]), 
								lineArgs[6], 
								Double.parseDouble(lineArgs[7]), 
								Double.parseDouble(lineArgs[8]),
								sis_operare.valueOf(lineArgs[9].toLowerCase())
								));
			}
		}
		reader.close();
		
		System.out.println("Alege o optiune: ");
		System.out.println("1.Afisare imprimante.");
		System.out.println("2.Afisare copiatoare.");
		System.out.println("3.Afisare sisteme calcul.");
		System.out.println("4.Modificare stare echipament.");
		System.out.println("5.Setare mod scriere imprimanta.");
		System.out.println("6.Setare mod copiere copiatoare.");
		System.out.println("7.Instalare sis. operare.");
		System.out.println("8.Afisare echipamente vandute.");
		
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Optiune: ");
		int opt = Integer.parseInt(reader1.readLine());
		switch(opt){
		case 1: 
			for(Echipament ech : inventar){
				if(ech instanceof Imprimanta){
					System.out.println(ech);
				}
			}
			break;
		case 2:
			for(Echipament ech : inventar){
				if(ech.getClass() == Copiator.class){
					System.out.println(ech);
				}
			}
			break;
		case 3: 
			for(Echipament ech : inventar){
				if(ech instanceof EchipamentCalcul){
					System.out.println(ech);
				}
			}
			break;
		case 4:
			System.out.print("Introduceti nr inventar: ");
			int nr = Integer.parseInt(reader1.readLine());
			for(Echipament ech : inventar){
				if(ech.getNr_inventar() == nr){
					System.out.println("Stare curenta: " + ech.getSt().toString());
					System.out.print("Stare Noua: (achizitionat, vandut, expus) : ");
					String newState = reader1.readLine();
					ech.setSt(stare.valueOf(newState.toLowerCase()));
				}
				else {
					System.out.println("Not found.");
				}
			}
			break;
		case 5:
			System.out.print("Introduceti nr inventar: ");
			int nr1 = Integer.parseInt(reader1.readLine());
			for(Echipament ech : inventar){
				if(ech.getNr_inventar() == nr1 && ech instanceof Imprimanta){
					Imprimanta im = (Imprimanta)ech;
					System.out.println("Mod scriere curent: " + im.getMs().toString());
					System.out.print("Mod scriere Nou: (color, albnegru) : ");
					String newState = reader1.readLine();
					im.setMs(mod_scriere.valueOf(newState.toLowerCase()));
				}
				else {
					System.out.println("Not found.");
				}
			}
			break;
		case 6:
			System.out.print("Introduceti nr inventar: ");
			int nr2 = Integer.parseInt(reader1.readLine());
			for(Echipament ech : inventar){
				if(ech.getNr_inventar() == nr2 && ech instanceof Copiator){
					Copiator cp = (Copiator)ech;
					System.out.println("Mod copiere curent: " + cp.getFc().toString());
					System.out.print("Mod copiere Nou: (A4, A3) : ");
					String newState = reader1.readLine();
					cp.setFc(format_copiere.valueOf(newState.toUpperCase()));
				}
				else {
					System.out.println("Not found.");
				}
			}
			break;
		case 7:
			System.out.print("Introduceti nr inventar: ");
			int nr3 = Integer.parseInt(reader1.readLine());
			for(Echipament ech : inventar){
				if(ech.getNr_inventar() == nr3 && ech instanceof EchipamentCalcul){
					EchipamentCalcul ec = (EchipamentCalcul)ech;
					System.out.println("Sis instalat: " + ec.getSo().toString());
					System.out.print("Sis Nou: (windows, linux) : ");
					String newState = reader1.readLine();
					ec.setSo(sis_operare.valueOf(newState.toLowerCase()));
				}
				else {
					System.out.println("Not found.");
				}
			}
			break;
		case 8:
			for(Echipament ech : inventar){
				if(ech.getSt().equals("vandut")){
					System.out.println(ech);
				}
			}
		}
	}

}
