package org.match.year2015.puzzles.day08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution08 {

    public static void main(String[] args) {

        // pull input file
        File file = new File("src/main/java/org/match/year2015/inputs/input08");

        // convert to list of strings
        List<String> inputList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                inputList.add(line);
            }
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        // calculate and print answer
        int answer = calculate(inputList);

        System.out.println("first answer = " + answer);

        answer = calculate2(inputList);

        System.out.println("second answer = " + answer);
    }

    /**
     *  how to solve this one?
     *  the ask is to determine the difference between the number of total characters
     *  in the input file, and the number of character in the in memory string from the
     *  input file.
     *  clumsy summation that.
     *
     *  each line of the input is a double quoted string.
     *  some line contain escaped characters, denoted with \
     *  the starting and ending quotes and the escape symbols do not count
     *  as in memory string
     *  if the characters after the escape symbol are a hexadecimal string,
     *  the in memory part consists of what that hexadecimal string resolves to,
     *  while the number of total characters is 4 -> \x27
     *                                               1234
     *
     *  I need check each line and maintain 2 counts
     *  first count will just get the length of the line
     *  second count will get the length of the in memory string
     *      - not including starting and ending double quotes
     *      - not including the escape characters themselves
     *      - resolving hexadecimal and counting the character value, not the hex string
     *
     *  easy to ignore the starting and ending quotes
     *  can use regex to find the escape characters and handle appropriately
     *
     *  for hexadecimal, need to ensure the character following the \x are valid
     *  hex digits
     *      if yes, look up the char in the ascii table
     *      if not, just count the escaped x?
     *
     *
     *  need to account for...
     *      - escaped backslashes (with no overlap)
     *          - "\\" is an escaped backslash
     *          - "\\\\" is 2 escaped backslashes, but sloppy regex would find 3 matches
     *          - "\\\"" is 1 escaped backslash, 1 escaped double quote, but sloppy regex
     *            would find 2 escaped backslash matches
     *      - hex strings. got the pattern for this handled.
     *      - escaped quote characters
     */


    private static Pattern hexPattern = Pattern.compile("\\\\x[a-f][a-f]|\\\\x[0-9][0-9]|\\\\x[a-f][0-9]|\\\\x[0-9][a-f]");
    private static Pattern anythingElsePattern = Pattern.compile("\\\\.");

    private static int calculate(List<String> inputList) {
        int totalChars = 0;
        int inMemoryChars = 0;



        for (String line : inputList) {

            // add line length to total literal count
            totalChars += line.length();

//            System.out.println("starting line: " + line);

            // strip leading and ending double quotes
            String unquotedLine = line.substring(1,line.length()-1);
//            System.out.println("without quotes: " + unquotedLine);

            // match and replace hex
            Matcher matchHex = hexPattern.matcher(unquotedLine);
            String noHexLine = matchHex.replaceAll("4");
//            System.out.println("without hex: " + noHexLine);

            // match and replace any other escaped characters
            Matcher matchAnythingElse = anythingElsePattern.matcher(noHexLine);
            String finalLine = matchAnythingElse.replaceAll("1");
//            System.out.println("final line: " + finalLine);

            // add reduced line length to total in memory count
            inMemoryChars += finalLine.length();

        }
        return totalChars - inMemoryChars;
    }

    private static int calculate2(List<String> inputList) {
        int literalLength = 0;
        int encodedLiteralLength = 0;

        for (String line : inputList) {
            // add starting line length to literalLength
            literalLength += line.length();

            System.out.println("starting line: " + line);

            // find hex and replace with number of replacement chars
            Matcher matchHex = hexPattern.matcher(line);
            String augmentedHex = matchHex.replaceAll("55555");
            System.out.println("augmentedHex:  " + augmentedHex);

            // replace everything else needed between the starting and ending quotes
            Matcher matchEverythingElse = anythingElsePattern.matcher(augmentedHex);
            String augmentedEverythingElse = matchEverythingElse.replaceAll("4444");
            System.out.println("everything else :" + augmentedEverythingElse);

            // replace starting and ending quotes
            String finalLine = augmentedEverythingElse.replaceAll("\"", "333");
            System.out.println("finalLine: " + finalLine);


            encodedLiteralLength += finalLine.length();


        }




        return encodedLiteralLength - literalLength;
    }


}
