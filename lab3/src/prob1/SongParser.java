package prob1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongParser {
    public static String parse(String input){
        String[] words = input.split("\\W+");
        int vowelsCount = 0;
        boolean starFlag = false;
        boolean randMatcher = false;
        double randNumber = Math.random();

        if(input.length() > 0){
            Pattern vowelPattern = Pattern.compile("[aeiou]");
            Matcher vowelMatcher = vowelPattern.matcher(input);

            while (vowelMatcher.find())
                vowelsCount++;
        }

        if(words[words.length - 1].endsWith("ne")){
            starFlag = true;
        }

        if(randNumber <= 0.1){
            randMatcher = true;
        }

        return (randMatcher ? input.toUpperCase() : input) +
                (starFlag ? "*" : "") +
                " -->WordCount: " + words.length +
                " -->VowelsNumber: " + vowelsCount +
                " -->RandNumber: " + randNumber;
    }
}
