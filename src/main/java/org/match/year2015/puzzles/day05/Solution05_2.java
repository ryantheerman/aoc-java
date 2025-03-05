package org.match.year2015.puzzles.day05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution05_2 {

    /**
     *  Rules:
     *      - must contain 3 vowel of any type in any sequence. they do not need to be sequential.
     *      - AND must contain at least one double
     *      - AND must NOT contain the string ab, cd, pq, or xy
     */

    public static void main(String[] args) {

        List<String> input = new ArrayList<>();

        File file = new File("src/main/java/org/match/year2015/inputs/input05");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        int answer = countNiceStrings(input);

        System.out.println("# of nice lines: " + answer);


    }

    private static int countNiceStrings(List<String> input) {

        // initialize count
        int niceCount = 0;

        // set up regex patterns
        Pattern patternOmissions = Pattern.compile("(ab|cd|pq|xy)");
        Pattern patternDoubles = Pattern.compile(".*(.)\\1.*");
        Pattern patternVowels = Pattern.compile("[aeiou]");

        for (String line : input) {

            // set up matchers
            Matcher matchDoubles = patternDoubles.matcher(line);
            Matcher matchOmissions = patternOmissions.matcher(line);
            Matcher matchVowels = patternVowels.matcher(line);

            // stop processing line if ab, cd, pq, or xy  occur in the string
            if (matchOmissions.find()) {
                continue;
            }

            // debugging the regex pattern
//            int matchDoublesCount = 0;
//            if (matchDoubles.find()) {
//                matchDoublesCount = matchDoubles.groupCount();
//                for (int i = 1; i <= matchDoubles.groupCount(); i++) {
//                    System.out.println(matchDoubles.group(i));
//                    niceCount++;
//                }
//            }

            // figure out if there are any doubles
            if (matchDoubles.find()) {
                // increment niceCount if 3 vowels exist in string
                int vowelCount = 0;
                for (char ch : line.toCharArray()) {
                    if (matchVowels.find()) {
                        vowelCount++;
                        if (vowelCount == 3) {
                            niceCount++;
                            break;
                        }
                    }
                }
            }
        }
        return niceCount;
    }
}
