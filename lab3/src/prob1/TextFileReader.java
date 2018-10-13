package prob1;

import java.io.*;

public class TextFileReader {
    private BufferedReader textReader;

    public TextFileReader(String filename) throws FileNotFoundException {
        textReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
    }

    public String readLine() throws IOException {
        return textReader.readLine();
    }
}
