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

        answer = countNicerStrings(input);

        System.out.println("# of nicer lines: " + answer);
    }

    private static int countNiceStrings(List<String> input) {

        // initialize count
        int niceCount = 0;

        // set up regex patterns
        Pattern patternOmissions = Pattern.compile("(ab|cd|pq|xy)");
        Pattern patternDoubles = Pattern.compile(".*(.)\\1.*");
        Pattern patternVowels = Pattern.compile(".*[aeiou].*[aeiou].*[aeiou].*");

        for (String line : input) {

            // set up matchers
            Matcher matchDoubles = patternDoubles.matcher(line);
            Matcher matchOmissions = patternOmissions.matcher(line);
            Matcher matchVowels = patternVowels.matcher(line);

            // check conditions
            if (!matchOmissions.find() && matchDoubles.find() && matchVowels.find()) {
                niceCount++;
            }
        }
        return niceCount;
    }

    /**
     *  PART 2 RULES...
     *      - must contain 2 pairs any 2 letters with no overlap
     *      - AND must contain 2 of the same character with another character in
     *        between (can be the same character...
     *        so efe fires, and so does aaa).
     */

    private static int countNicerStrings(List<String> input) {
        int count = 0;

        // define patterns
        Pattern patternPairs = Pattern.compile("");
        Pattern patternSandwich = Pattern.compile("");


        // iterate over input
        for (String line : input) {

            // define matchers
            Matcher matchPairs = patternPairs.matcher(line);
            Matcher matchSandwich = patternSandwich.matcher(line);

            // check conditions
            if (matchPairs.find() && matchSandwich.find()) {
                count++;
            }
        }
        return count;
    }
}
