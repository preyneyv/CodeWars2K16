package com.preyneyv.codewars2k16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob01 {
    public static void main(String[] args){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();

            System.out.println("Hello from the other side, " + name + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
