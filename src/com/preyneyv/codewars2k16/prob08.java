package com.preyneyv.codewars2k16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob08 {
    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            int num_words = Integer.parseInt(reader.readLine());

            String[] words = new String[num_words];

            for (int i = 0; i < num_words; i++) {
                words[i] = reader.readLine();
            }

            for (String word : words) {
                int pos = word.length() - 1;
                for (int i = 0; i < word.length(); i++) {
                    for (int j = 0; j < pos; j++) {
                        System.out.print(" ");
                    }
                    System.out.println(word.substring(0, word.length() - pos));

                    pos--;
                }
                pos = 1;
                for (int i = 0; i < word.length()-1; i++) {
                    System.out.println(word.substring(pos));

                    pos++;

                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
