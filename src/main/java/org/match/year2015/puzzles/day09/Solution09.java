package org.match.year2015.puzzles.day09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution09 {

    /**
     *  I need to figure out the shortest route Santa can fly given
     *  distances between locations in the input file.
     *
     *  He must visit each location only once.
     *
     *  There are 7 locations.
     *  So 7 factorial is the number of possible permutations for his route.
     *  7*6*5*4*3*2*1 = 5040 possible routes
     *
     *  Need to programmatically calculate the routes and return the shortest.
     *
     */

    public static void main(String[] args) {

        File file = new File("src/main/java/org/match/year2015/inputs/input09");

        List<String> inputList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                inputList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int answer = calculateShortestRoute(inputList);

        System.out.println(answer);

    }

    private static int calculateShortestRoute(List<String> inputlist) {
        int shortestRoute = 0;

        /**
         *  okay, so I have a list of distances between locations.
         *  what to do with them?
         *  how to convert them to factorial? how to handle the data?
         *
         *  I can boil the inputs down to the numbers.
         *  the distances are all that matter. I don't care about the location names.
         *
         *  the input file does not list all possible permutations, because there can
         *  be no repeats.
         *  the distance from tristram to straylight is the same as the distance from straylight
         *  to tristram. so I only need that distance once. if i plan a route that travels from A to B,
         *  I don't also need to plan a route that goes from B to A, as those distances are equivalent.
         *
         *  wait, the locations do matter.
         *  i need to know that I'm not going to the same location twice.
         *
         *  there are 7 links in the chain. 7 locations I can be at.
         *  must start at one and end at any other, and visit all in between
         *  but i cannot visit the same one twice.
         */




        return shortestRoute;
    }

}
