package org.match.year2015.puzzles.day04;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Solution04 {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        /**
         * okay, so here's the problem. Need to find the lowest number that can be appended
         * to my puzzle input which together generates an md5 hash starting with 5 zeroes.
         *
         * I'll use a method to generate an md5 hash. not sure what my options are yet, but I'll
         * look into it.
         *
         * Once I have my hash generator, I'll iterate through a loop. maybe a 'while (true)'.
         * I'll start from 0, and append the number to the puzzle input and hash it.
         *
         * Check the hash. Does it begin with 5 zeroes?
         *  No... increment the number and loop through again.
         *  Yes... return the number as the answer.
         */

        String input = "ckczppom";
        int num = 1;

        MessageDigest md = MessageDigest.getInstance("MD5");

        while (num < Integer.MAX_VALUE) {

            // append num to input
            String fullInput = input + num;

            // convert input to bytes
            byte[] inputBytes = fullInput.getBytes();

            // hash the inputBytes with md5
            byte[] hashedBytes = md.digest(inputBytes);

            // convert the hashedBytes to hexadecimal
            String hex = HexFormat.of().formatHex(hashedBytes);

            if (hex.startsWith("000000")) {
                break;
            }

            num++;
        }

        System.out.println(num);

    }
}
