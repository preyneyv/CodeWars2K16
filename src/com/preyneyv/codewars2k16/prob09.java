package com.preyneyv.codewars2k16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class prob09 {
    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            List<String> ob = new ArrayList<>();

            String line;
            while(!(line = reader.readLine()).equals("0 0 0")) {
                String[] dimensions = line.split(" ");
                int l = Integer.parseInt(dimensions[0]),
                    w = Integer.parseInt(dimensions[1]),
                    h = Integer.parseInt(dimensions[2]);

                int total_cubes = l * w * h;
                int face_cubes = 0;
                face_cubes += 8; // corners

                face_cubes += 4 * (l-2); // edges
                face_cubes += 4 * (w-2);
                face_cubes += 4 * (h-2);

                face_cubes += 2 * (l-2) * (w-2);
                face_cubes += 2 * (w-2) * (h-2);
                face_cubes += 2 * (h-2) * (l-2);

                if (face_cubes > total_cubes-face_cubes) {
                    ob.add(String.format("A %dx%dx%d block is MORE than Perfect", l, w, h));
                }else if (face_cubes == total_cubes-face_cubes) {
                    ob.add(String.format("A %dx%dx%d block is PERFECT", l, w, h));
                }else {
                    ob.add(String.format("A %dx%dx%d block is LESS than Perfect", l, w, h));
                }
            }

            for (String text : ob) {
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
