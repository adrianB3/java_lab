package prob1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        TextFileReader reader = new TextFileReader("song.txt");
        TextFileWriter writer = new TextFileWriter("analysedSong.txt");

        String line;

        while((line = reader.readLine()) != null){
            writer.writeLine(SongParser.parse(line));
        }
    }
}
