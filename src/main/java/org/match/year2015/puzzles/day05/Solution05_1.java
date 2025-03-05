package org.match.year2015.puzzles.day05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution05_1 {

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

        int niceCount = 0;

        for (String line : input) {

            if (line.contains("ab") || line.contains("cd") || line.contains("pq") || line.contains("xy")) {
                continue;
            }

            // figure out if there are any doubles
            if (line.matches(".*(aa|bb|cc|dd|ee|ff|gg|hh|ii|jj|kk|ll|mm|nn|oo|pp|qq|rr|ss|tt|uu|vv|ww|xx|yy|zz).*")) {
                // increment niceCount if 3 vowels exist in string
                int vowelCount = 0;
                for (char ch : line.toCharArray()) {
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
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
