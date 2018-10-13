package prob2;

import java.io.*;

public class TextFileReader {
    private BufferedReader reader;

    public TextFileReader(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }
}
