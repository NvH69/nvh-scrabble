package com.nvh.scrabble.model;

import com.nvh.scrabble.service.ResourceLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    public static final String dictionaryFile = "/dictionaries/ODS6.txt";
    public static final List<String> dictionary = new ArrayList<>();
    private static ResourceLoader resourceLoader = new ResourceLoader();

    public Dictionary() {

        for (byte j = 2; j <= 15; j++) {
            try (BufferedReader in =
                         new BufferedReader(new FileReader(resourceLoader.getFileFromResource(dictionaryFile)))) {
                String line;
                while (!(line = in.readLine()).equals("*")) {

                    if (line.length() == j) {
                        dictionary.add(line);
                    }
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isCorrectlySpelled(String s) {

        for (String word : dictionary) {
            if (s.equals(word)) return true;
        }
        return false;
    }
}
