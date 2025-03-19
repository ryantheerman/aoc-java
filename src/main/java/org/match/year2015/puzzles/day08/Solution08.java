package org.match.year2015.puzzles.day08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        System.out.println("answer = " + answer);

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
     */

    private static int calculate(List<String> inputList) {
        int totalChars = 0;
        int inMemoryChars = 0;






        return totalChars - inMemoryChars;
    }


}
