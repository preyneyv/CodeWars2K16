package com.preyneyv.codewars2k16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class prob02 {
    public static void main(String[] args){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(reader.readLine());

            final int waterLevel = 10000;

            List<Integer> usages = new ArrayList<>();

            while (input != 0) {
                usages.add(input);

                input = Integer.parseInt(reader.readLine());
            }

            for (int num: usages){
                int weeks = waterLevel / num;
                System.out.println(String.format("%d gallons per week will last %d weeks", num, weeks));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
