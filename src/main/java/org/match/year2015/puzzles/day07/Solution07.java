package org.match.year2015.puzzles.day07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution07 {

    /**
     *  Okay, how to solve this one?
     *      my input is a list of operations resulting in an output.
     *      i need to execute those operations to determine the output.
     *      those outputs are used as inputs to other operations.
     *      but i don't have all the data i need right away.
     *
     *      it boils down to doing bitwise calculations on numbers.
     *      as far as I understand, this means taking the decimal inputs and
     *      operating on their binary representations.
     *      so 1 is 0001 and 2 is 0010 and 3 is 0011 and 4 is 0100 etc.
     *
     *      the bitwise operators are boolean logic gates, and the output is the
     *      binary result of the logic being applied to the input bits.
     *
     *      so 0010 AND 0011 = 0010, because 0 AND 0 is 0, 0 AND 0 is 0,
     *      1 and 1 is 1, and 0 AND 1 is 0.
     *
     *      need to execute all the ops in order to determine what the final value
     *      of a is.
     *
     *      but most variables in the input are defined only in terms of
     *      operations on other variables, which are themselves defined
     *      in terms of other variables. very few lines of the input point
     *      back to actual numbers.
     *      the numbers need to be my starting point. maybe not literally.
     *      i don't necessarily need to start parsing the input at the number
     *      inputs, but those are the only lines I can use to start CALCULATING.
     *
     *      I basically need to solve for the right side of each equation.
     *      I can create a function to do that based on which bitwise operator
     *      is referenced.
     *      but most variables are undefined, so i'll need to call the solve
     *      function repeatedly until inputs are actual numbers. from there I can
     *      move up the stack of input lines solving for the right side,
     *      using each solution to solve further input lines.
     *
     *      so I need to start solving for a. that is the end goal. everything
     *      I need to solve it is SOMEWHERE in the input lines. just keep going
     *      until you get to an answer.
     *
     */

    public static void main(String[] args) {

        // parse input into a list
        File file = new File("src/main/java/org/match/year2015/inputs/input07");

        List<String> input = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }


        // pass list to workhorse function and return answer
        int answer = solveForA(input);

        System.out.println(answer);
    }

    private static int solveForA(List<String> input) {
        int answer = 0;

        // do stuff here
        // k. what stuff?

        // parse input lines into a map with the operation and operands as a string, the output as key.
        // This map will be for reference. For example, if I need to calculate k, I'll look for the key k in the map,
        // then parse the operation and variables/numbers out of the string at that key.

        // calculate function
        // this function requires one or two number inputs to produce output, depending on the operation.
        // if the input is a variable, the function must be recursively called to solve for that variable before
        // it can provide an output for the original input
        // will first pass in the operation for outputting the value of a. then work from there.

        Map<String, String> inputMap = new HashMap<>();

        for (String line : input) {
            String[] splitLine = line.split("->");
            inputMap.put(splitLine[1].trim(), splitLine[0].trim());
        }

//        while (true) {
//            // interatively check the map
//            Scanner scan = new Scanner(System.in);

//            System.out.print("please select a key: " );
//            String userInput = scan.nextLine();

//            System.out.println("value: " + inputMap.get(userInput));
//        }

        // Java provides bitwise operators for AND, OR, XOR, NOT, LEFT SHIFT, and RIGHT SHIFT
        // will use these operators to calculate the outputs

        // what data will be passed into the calculate function? -> the value of the map. the calculate function
        // returns the value of the map key.

        // the calculate function will be called recursively. I want the value of a, but in my input, the
        // calculation for a is simply the value of lx. I need the value of lx, so the calculate function will
        // check if the values in the map are digits or variables.
        // if digits, use them for the calculation. if variables, call the calculation function on them until
        // they resolve to digits.

        answer = calculate(inputMap.get("il"));

        return answer;
    }

    // AND and OR contain 2 values for calculation
    // NOT, RSHIFT, LSHIFT, and direct assignment contain 1 value for calculation (for the shift operations we can think of the
    // distance of the shift as part of the operation itself)

    private static int calculate(String calculation) {
        int output = 0;

        // parse the input (store operator and digit(s)/variable(s)

        // if operator does not contain AND or OR -> prepare for 1 value
            // it will be a NOT, a SHIFT, or a direct assignment
        if (!calculation.contains("AND") && !calculation.contains("OR")) {
            System.out.println(calculation);
        }
            // if value is a number, calculate output
            // if value is a variable, call the calculate function on it to arrive at a number.


        // else prepare for 2 values
            // it will be an AND or an OR
        else {
            System.out.println(calculation);
        }
            // if both values are numbers, calculate output
            // if value a is a variable, call the calculate function on it to arrive at a number.
            // if value b is a variable, call the calculate function on it to arrive at a number.


        return output;
    }
}
