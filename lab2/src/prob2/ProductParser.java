package prob2;

public class ProductParser {
    public static Produs Parse(String textToParse){
        String[] arr = textToParse.split(";");
        return new Produs(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
    }
}
