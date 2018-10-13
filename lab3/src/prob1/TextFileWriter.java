package prob1;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TextFileWriter {
    private PrintStream textWriter;

    public TextFileWriter(String filename) throws FileNotFoundException {
        textWriter = new PrintStream(filename);
    }

    public void writeLine(String input){
        textWriter.println(input);
    }
}
