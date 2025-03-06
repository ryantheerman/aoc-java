package org.match.year2015.puzzles.day06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution06 {

    /**
     *
     *  okay, how can we solve this problem?
     *
     *  which data structure can I use to represent a 1000x1000 grid?
     *  2d array?
     *
     *  I need something that can persist the truth value of the lights'
     *  on or offness.
     *  so maybe using a 2d array of booleans?
     *      - could have an outer array of arrays, of size 1000.
     *      - each inner array is of booleans, each of size 1000.
     *      - booleans are all initialized to false
     *      - or just use ints. 0 is false, 1 is true.
     *      - the locations of the lights correlate to the indexes of the arrays
     *          - (0) [0 1 2 3 4 5 6 7 8 9]
     *          - (1) [0 1 2 3 4 5 6 7 8 9]
     *          - (2) [0 1 2 3 4 5 6 7 8 9]
     *          - (3) [0 1 2 3 4 5 6 7 8 9]
     *          - (4) [0 1 2 3 4 5 6 7 8 9]
     *          - (5) [0 1 2 3 4 5 6 7 8 9]
     *          - (6) [0 1 2 3 4 5 6 7 8 9]
     *          - (7) [0 1 2 3 4 5 6 7 8 9]
     *          - (8) [0 1 2 3 4 5 6 7 8 9]
     *          - (9) [0 1 2 3 4 5 6 7 8 9]
     *              - 0,3 to 5,2 would start in the 0th array at index 3,
     *                and draw a rectangle to index 5 at position 2
     *              - the leftmost coordinate is the y position, or the index of
     *                the outer array
     *              - the rightmost coordinate is the x position, or the index of
     *                the inner array
     *
     */

    public static void main(String[] args) throws FileNotFoundException {

        // get input file
        File file = new File("src/main/java/org/match/year2015/inputs/input06");

        // parse input file into a list of strings
        List<String> input = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // pass input file into solution method

        int answer = countLights(input);

    }


    private static int countLights(List<String> input) {

        // initialize count
        int count = 0;

        // set up data structure
        int[][] grid = new int[1000][1000];

        // visualize the grid
//        System.out.println("begin");
//        for (int[] innerArray : grid) {
//            for(int i : innerArray) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("end");

        // define some regex for parsing the numbers out
        Pattern patternAction = Pattern.compile("toggle|on|off");
        Pattern patternX = Pattern.compile("\\d{1,3},");
        Pattern patternY = Pattern.compile(",\\d{1,3}");


        // iterate over input
        for (String line : input) {

            // set up matchers
            Matcher matchAction = patternAction.matcher(line);
            Matcher matchX = patternX.matcher(line);
            Matcher matchY = patternY.matcher(line);


            // parse action (on/off/toggle -> updates position truth values)
            String action = "";
            if (matchAction.find()) action = matchAction.group();


            // gonna get sloppy with the input validations/null checks because in this case I know I can trust it


            // get starting and ending x coordinates
            int startingX = 0;
            int endingX = 0;
            if (matchX.find()) startingX = Integer.parseInt(matchX.group().replace(",",""));
            if (matchX.find()) endingX = Integer.parseInt(matchX.group().replace(",",""));
            System.out.println("X: " + startingX + " " + endingX);

            // get starting and ending y coordinates
            int startingY = 0;
            int endingY = 0;
            if (matchY.find()) startingY = Integer.parseInt(matchY.group().replace(",",""));
            if (matchY.find()) endingY = Integer.parseInt(matchY.group().replace(",",""));
            System.out.println("Y: " + startingY + " " + endingY);


            // okay, so now I have my action stored in a string, and my starting and ending x and y coordinates
            // now on to the actual logic

            // execute action on range

        }

        // iterate over data structure and count the trues


        return count;
    }







}
