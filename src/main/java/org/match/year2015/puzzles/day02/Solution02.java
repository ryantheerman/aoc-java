package org.match.year2015.puzzles.day02;

import org.match.year2015.helpers.FileReaderHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution02 {

    static FileReaderHelper fileReaderHelper = new FileReaderHelper();

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/java/org/match/year2015/inputs/input02");

        List<String> dimensions = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dimensions.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int answer = calculateRequiredPaper(dimensions);

        System.out.println("total paper needed " + answer);

        answer = calculateRequiredRibbon(dimensions);

        System.out.println("total ribbon needed " + answer);

    }

    private static int calculateRequiredPaper(List<String> input) {

        int totalArea = 0;

        // for each line in the input
        for (Object line : input) {

            // create a String array with the elements of the line, separated by the char 'x'
            String[] stringSides = (line.toString().split("x"));
            int[] intSides = new int[3];

            // convert the String array to an int array
            for (int i = 0; i < stringSides.length; i++) {
                intSides[i] = Integer.parseInt(stringSides[i]);
            }

            // create variables for side lengths
            int l = intSides[0];
            int w = intSides[1];
            int h = intSides[2];

            // create vars for side areas
            int areaA = l*w;
            int areaB = w*h;
            int areaC = h*l;

            // find and store smallest side area
            int smallestSide = 0;

            if (areaA <= areaB && areaA <= areaC) {
                smallestSide = areaA;
            } else if (areaB <= areaA && areaB <= areaC) {
                smallestSide = areaB;
            } else smallestSide = areaC;

            // calculate total paper needed for the given package
            int area = 2*areaA + 2*areaB + 2*areaC + smallestSide;

            totalArea += area;

        }

        return totalArea;
    }

    private static int calculateRequiredRibbon(List<String> input) {

        int totalLength= 0;

        // for each line in the input
        for (Object line : input) {

            // create a String array with the elements of the line, separated by the char 'x'
            String[] stringSides = (line.toString().split("x"));
            int[] intSides = new int[3];

            // convert the String array to an int array
            for (int i = 0; i < stringSides.length; i++) {
                intSides[i] = Integer.parseInt(stringSides[i]);
            }

            int l = intSides[0];
            int w = intSides[1];
            int h = intSides[2];

            int bowLength = l*w*h;

            Arrays.sort(intSides);

            int ribbonLength = 2*intSides[0] + 2*intSides[1] + bowLength;

            totalLength += ribbonLength;

        }

        return totalLength;
    }
}
