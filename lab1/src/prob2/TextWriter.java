package prob2;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TextWriter {
    private String outputFileName;
    private PrintStream ps;

    public TextWriter(String outputFileName) throws FileNotFoundException {
        this.outputFileName = outputFileName;
        ps = new PrintStream(this.outputFileName);
    }

    public void writeLine(String output){
        ps.println(output);
    }
}
