package org.match.year2015.puzzles.day02;

import org.match.year2015.helpers.FileReaderHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution02 {

    static FileReaderHelper fileReaderHelper = new FileReaderHelper();

    public static void main(String[] args) throws IOException {

        File file = new File("../../inputs/input02");

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

    }

    private static int calculateRequiredPaper(List input) {

        int answer = 0;

        for (Object line : input) {
            int length;
            int width;
            int height;
        }


        return answer;
    }
}
