import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob05 {
    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            int num_herders = Integer.parseInt(reader.readLine());
            String[] ob = new String[num_herders];

            for (int i = 0; i < num_herders; i++) {
                String[] line = reader.readLine().split(" ");
                int taxRate = Integer.parseInt(line[0]);
                String[] flock = line[1].split("");
                String new_flock = "";

                for (int j = 0; j < flock.length; j++) {
                    if (j % taxRate != 0)
                        new_flock += flock[j];
                }

                ob[i] = new_flock;
            }
            for (String str : ob) {

                System.out.printf("%s %d \n", str, str.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
