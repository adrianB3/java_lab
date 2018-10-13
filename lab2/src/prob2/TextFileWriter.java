package prob2;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TextFileWriter {
    private PrintStream writer;

    public TextFileWriter(String outputFileName) throws FileNotFoundException {
        writer = new PrintStream(outputFileName);
    }

    public void writeLine(String textToWrite){
        writer.println(textToWrite);
    }
}
