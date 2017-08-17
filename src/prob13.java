import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prob13 {
    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            int num_stars = Integer.parseInt(reader.readLine());
            Star[] stars = new Star[num_stars];
            for (int i = 0; i < num_stars; i++) {
                String[] data = reader.readLine().split("\\s+");
                String name = data[0];
                int raHours = Integer.parseInt(data[1]);
                double raMinutes = Double.parseDouble(data[2]);
                int decDegrees = Integer.parseInt(data[3]);
                int decMinutes = Integer.parseInt(data[4]);
                double lightYears = Double.parseDouble(data[7]);

                Matcher sign = Pattern.compile("([+-])\\d+").matcher(data[3]);
                String decSign = "";
                if(sign.find()) {
                    decSign = sign.group(0);
                } else {
                    System.err.println("Error with Regex");
                }

                stars[i] = new Star(name, raHours, raMinutes, decDegrees, decMinutes, decSign, lightYears);
            }
            for (Star star : stars) {
                star.printCoords();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Star {
    private String name;
    private double x;
    private double y;
    private double z;

    Star(String name, int raHours, double raMinutes, int decDegrees, int decMinutes, String decSign, double lightYears) {
        this.name = name;

        // convert to degrees
        double ra = 0, dec = 0;
        ra += raHours * 15; // 1 hr = 15 deg
        ra += raMinutes * 15 / 60.0; // 60 min in 1 hr
        dec += decDegrees; // includes sign
        if(decSign.equals("+")) {
            dec += (double) decMinutes / 60.0;
        } else {
            dec -= (double) decMinutes / 60.0;
        }

        // convert to spherical coordinates
        double r = lightYears;
        double theta = (90 - dec) * Math.PI / 180;
        double q = ra * Math.PI / 180;

        // convert to x, y, z coordinates
        this.x = r * Math.sin(theta) * Math.cos(q);
        this.y = r * Math.sin(theta) * Math.sin(q);
        this.z = r * Math.cos(theta);
    }

    public void printCoords() {
        System.out.printf("%s x=%.2f y=%.2f, z=%.2f\n", this.name, this.x, this.y, this.z);
    }
}