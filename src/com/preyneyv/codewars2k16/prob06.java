package com.preyneyv.codewars2k16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class prob06 {
    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            int num_sensors = Integer.parseInt(reader.readLine());

            float[] ob = new float[num_sensors];

            int[][] sensor_data = new int[num_sensors][5];

            for (int i = 0; i < num_sensors; i++) {
                String[] data = reader.readLine().split(" ");
                for (int j = 0; j < data.length; j++) {
                    sensor_data[i][j] = Integer.parseInt(data[j]);
                }
                int[] sensor = sensor_data[i];

                float gradient = (float) (sensor[2] - sensor[1]) / (sensor[4] - sensor[3]);
                float yIntercept = (float) sensor[1] - (gradient * sensor[3]);
                ob[i] = temp(sensor[0],gradient,yIntercept) / 8f;
            }


            for (float temp : ob) {
                BigDecimal dec = new BigDecimal(temp);
                System.out.println(dec);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static float temp(int temp, float gradient, float yIntercept) {
        return (temp - yIntercept) / gradient;
    }
}
