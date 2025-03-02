package org.match.year2015.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderHelper {

    public FileReaderHelper() {

    }

    // This is a helper class containing methods for reading input from files.

    // if a file is only one line, it can be read into a string

    // if the file is multiple lines, it can be read into a list

    // in what cases would we want to use a stream?

    public File getFile(String filePath) {
        return new File(filePath);
    }

    // Get info on the file
    public void getFileInfo(File file) throws IOException {
        System.out.println("file name: " + file.getName());
        System.out.println("file absolute path: " + file.getAbsolutePath());
        System.out.println("file canonical path: " + file.getCanonicalPath());
    }

    // BufferedReader

    // return multi line string
    public String useBufferedReaderMultiLine(File file) {

        // The BufferedReader reads the file line by line. this helps conserve memory

        // We'll use a StringBuilder to collect all the lines into a String
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line =br.readLine()) != null) {
                content.append(line).append("\n"); // Append each line with a newline character. Can be omitted for a single line string
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(content);
    }

    // return single line string
    public String useBufferedReaderSingleLine(File file) {

        // The BufferedReader reads the file line by line. this helps conserve memory

        // We'll use a StringBuilder to collect all the lines into a String
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line =br.readLine()) != null) {
                content.append(line); // Append each line with a newline character. Can be omitted for a single line string
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(content);
    }

    // return a list with a line of the file for each element
    public List useBufferedReaderToList(File file) {

        List<String> content = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line =br.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }


    // Files

    public String useFilesReturnString(String filePath) {

        String content = "";
        try {
            content = String.valueOf(Files.readAllLines(Path.of(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }


    // Scanner










}
