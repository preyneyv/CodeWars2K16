package com.preyneyv.codewars2k16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class prob07 {
    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            int num_triplets = Integer.parseInt(reader.readLine());

            String[] ob = new String[num_triplets];

            for (int i = 0; i < num_triplets; i++) {
                String[] triplets = reader.readLine().split("\\s+");

                List<String> word1 = new ArrayList<>(Arrays.asList(triplets[0].split("")));
                List<String> word2 = new ArrayList<>(Arrays.asList(triplets[1].split("")));
                List<String> word3 = new ArrayList<>(Arrays.asList(triplets[2].split("")));

                List<String> result = new ArrayList<>();

                for (String elem : word1) {
                    for (String comp1 : word2) {
                        if(comp1.equals(elem)) {
                            boolean flag = false;
                            for (String comp2 : word3) {
                                if(comp2.equals(elem)) {
                                    word2.remove(comp1);
                                    word3.remove(comp2);
                                    result.add(elem);
                                    flag = true;
                                    break;
                                }
                            }
                            if(flag)
                                break;
                        }
                    }
                }

                Collections.sort(result);

                ob[i] = String.join("", result);
            }

            for (String str : ob) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
