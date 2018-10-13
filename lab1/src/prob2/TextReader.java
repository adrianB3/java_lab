package prob2;

import java.io.*;

public class TextReader {
    private BufferedReader br;
    private String inputFileName;

    public TextReader(String inputFileName) throws FileNotFoundException {
        this.inputFileName = inputFileName;
        br = new BufferedReader(new InputStreamReader(new FileInputStream(this.inputFileName)));
    }

    public String readLine() throws IOException {
        return br.readLine();
    }
}
