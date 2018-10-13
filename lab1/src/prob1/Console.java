package prob1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    private BufferedReader reader;

    public Console(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }
}
