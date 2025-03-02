package org.match.year2015.puzzles.day01;

import org.match.year2015.helpers.FileReaderHelper;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Solution01 {


    static FileReaderHelper fileReaderHelper = new FileReaderHelper();

    public static void main(String[] args) throws IOException {

//        String filePath = "/home/match/notes/daybook";
//        File file = fileReaderHelper.getFile(filePath);
//        fileReaderHelper.getFileInfo(file);
//        String multiLineInput = fileReaderHelper.useBufferedReaderMultiLine(file);
//        String singleLineInput = fileReaderHelper.useBufferedReaderSingleLine(file);
//        List<String> listInput = fileReaderHelper.useBufferedReaderToList(file);


//        String inputFromFiles = fileReaderHelper.useFilesReturnString(filePath);

//        System.out.println(inputFromFiles);

        File file = new File("src/main/java/org/match/year2015/inputs/input01");

        String input = fileReaderHelper.useBufferedReaderSingleLine(file);

        int answer = elevatorFinalFloor(input);

        System.out.println("Ends up at floor " + answer);

        answer = elevatorBasement(input);

        System.out.println("First enters the basement at position " + answer);

    }



    // need a method to parse the input (a series of opening and closing parentheses)
    // we will initialize an int to 0 (the starting floor)
    // for each '(' in the input, Santa goes up one floor (increment the int)
    // for each ')' in the input, Santa goes down one floor (decrement the int)
    // return the resulting in
    private static int elevatorFinalFloor (String input) {

        // declare int
        int floor = 0;

        for (char ch : input.toCharArray()) {
            if (ch == '(') floor++;
            else floor--;
        }

        return floor;
    }

    private static int elevatorBasement(String input) {

        int floor = 0;
        int position = 1;

        for (char ch : input.toCharArray()) {
            if (ch == '(') floor++;
            else floor--;

            if (floor < 0) return position;

            position++;
        }

        return position;

    }
}
