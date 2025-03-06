package org.match.year2015.puzzles.day06;

import java.util.List;

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

    public static void main(String[] args) {

        // get input file


        // parse input file into a list of strings


        // pass input file into solution method

    }


    private static int countLights(List<String> input) {

        // initialize count
        int count = 0;


        // set up data structure


        // iterate over input
        for (String line : input) {

            // parse action (on/off/toggle -> updates position truth values)

            // get starting y coordinate

            // get ending y coordinate

            // get starting x coordinate

            // get ending x coordinate

            // execute action on range

        }

        // iterate over data structure and count the trues


        return count;
    }







}
