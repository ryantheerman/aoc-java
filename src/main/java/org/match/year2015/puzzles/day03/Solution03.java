package org.match.year2015.puzzles.day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution03 {

    public static void main(String[] args) {

        File file = new File("src/main/java/org/match/year2015/inputs/input03");

        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String input = String.valueOf(content);

        int answer = navigateTheGrid(input);

        System.out.println("# of unique locations visited: " + answer);

    }


    /**
     *  '^' means north
     *  'v' means south
     *  '>' means east
     *  '<' means west
     *
     *  I need to do something with 2-dimensional arrays
     *  As I parse the input, I will move around in the array
     *  Need to keep track of location somehow. Need to know if a place I visit is somewhere I've visited before.
     *  Tricky.
     *
     *  Arrays in java are not dynamic. I cannot make them bigger or smaller.
     *  Is a 2-dimensional array the right data structure for this problem?
     *
     *  Could use lists. lists are resizable.
     *  play with this. see how it could work.
     *
     *  I know < an > will move me along the x axis.
     *  while ^ and v with move me along the y axis.
     *
     *  I could do something with arrays if I know where the boundaries need to be
     *
     *  I could first parse the input to know, from the starting location, how far east and west I would need to go, and how far north and south I need to go.
     *
     *  Then, I could the east+west and north+south to determine the size of the arrays
     *
     *  Then could start from the middle element of both arrays and navigate around
     *
     *  The outer array would hold arrays, the inner array would hold ints initialized to 0, or booleans initialized to false, or chars initialized to some arbitrary character.
     *
     *  As I navigate, I could increment the ints when Santa stops, or flip the boolean to true, or change the char to a different arbitrary char.
     *
     *  maybe I should use the ints, because I suspect part 2 of the problem will throw a curveball where it might be useful to have the count of visits to any one place
     *
     *  I've been overthinking it. I don't need an actual grid of initialized values. I just need to know where I am, and where I've been.
     *
     *  starting from coordinates 0,0 I need to follow the instructions to move north, south, east, or west. With each move I record the resulting coordinates. If the location is new, I increment a uniqueLocation counter. If the location matches a previously visited coordinate, I do not increment the counter.
     *
     *  which data structure do I use to store the coordinates?
     *  A map, with location on the x axis as keys, and locations on the y axis stores in lists of ints as values?
     *  try it.
     */



    // get the boundaries
    private static int navigateTheGrid(String input) {

        String santa = "";
        String robot = "";

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) santa += input.toCharArray()[i];
            else robot += input.toCharArray()[i];
        }


        System.out.println("santa's route");
        System.out.println(santa);

        System.out.println();

        System.out.println("robot's route");
        System.out.println(robot);

        int uniqueLocation = 1;

        int santaX = 0;
        int santaY = 0;

        int robotX = 0;
        int robotY = 0;

//        Map<Integer, List<Integer>> coords = new HashMap<>();

//        List<Integer> initialList = new ArrayList<>();
//        initialList.add(xPosition);
//        coords.put(yPosition,initialList);

        List<String> coordinates = new ArrayList<>();
        coordinates.add(String.valueOf(santaX) + "," + String.valueOf(santaY));


        for (char ch : santa.toCharArray()) {

            // the movement
            if (ch == '>') {
                santaX++;
            } else if (ch == '<') {
                santaX--;
            } else if (ch == '^') {
                santaY++;
            } else {
                santaY--;
            }

            String position = String.valueOf(santaX) + "," + String.valueOf(santaY);

            if (!coordinates.contains(position)) {
                uniqueLocation++;
                coordinates.add(position);

            }

            // if we are at a new y position, we create a list for the xValues at that y position, and add the y value as a key in the map, and add the xValues list as the map value with the current x position as the list's first value
//            if (!coords.containsKey(yPosition)) {
//
//                // create a list to hold the x axis values for this point on the y axis...
//                List<Integer> xValues = new ArrayList<>();
//
//                // add the current x position to the list of x values for the current y position...
//                xValues.add(xPosition);
//
//                // and add the KV pair to the map
//                coords.put(yPosition, xValues);
//
//                // increment the counter as we've never been here before
//                uniqueLocation++;
//            }
        }

        for (char ch : robot.toCharArray()) {

            // the movement
            if (ch == '>') {
                robotX++;
            } else if (ch == '<') {
                robotX--;
            } else if (ch == '^') {
                robotY++;
            } else {
                robotY--;
            }

            String position = String.valueOf(robotX) + "," + String.valueOf(robotY);

            if (!coordinates.contains(position)) {
                uniqueLocation++;
                coordinates.add(position);

            }

        }
        return uniqueLocation;
    }

}
