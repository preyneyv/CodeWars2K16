package com.preyneyv.codewars2k16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class prob04 {
    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            List<Float> ob = new ArrayList<>();

            String line;
            while (!(line = reader.readLine()).equals("0 0")) {
                String[] inputs = line.split(" ");
                float base = Float.parseFloat(inputs[0]);
                int exp = Integer.parseInt(inputs[1]);

                ob.add(base * (float) Math.pow(10, exp));
            }

            for (Float output: ob) {
                System.out.printf("%.2f", output);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
