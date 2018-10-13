package prob2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        TextReader textReader = new TextReader("in.txt");
        TextWriter textWriter = new TextWriter("out.txt");

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String line;
        double ma;
        int sum = 0;

        while ((line = textReader.readLine()) != null){
            numbers.add(Integer.parseInt(line));
        }

        for(var i : numbers){
            sum = sum + i;
        }
        ma = (double)sum/numbers.size();

        textWriter.writeLine("Sum : " + sum);
        textWriter.writeLine("Average : " + ma);
        textWriter.writeLine("Min : " + Collections.min(numbers));
        textWriter.writeLine("Max : " + Collections.max(numbers));
    }
}
