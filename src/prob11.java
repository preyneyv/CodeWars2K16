import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class prob11 {
    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            // get input
            String line;

            ArrayList<Float[]> bot_data = new ArrayList<>();

            while (!(line = reader.readLine()).equals("0 0 0")) {
                String[] strengths = line.split("\\s+");
                Float[] strengths_as_floats = {
                    Float.parseFloat(strengths[0]),
                    Float.parseFloat(strengths[1]),
                    Float.parseFloat(strengths[2])
                };
                bot_data.add(strengths_as_floats);
            }
            for (Float[] strengths : bot_data) {
                RelDist[] relativeDistances = {
                    new RelDist(strengths[0], 0, 100),
                    new RelDist(strengths[1], -100, -100),
                    new RelDist(strengths[2], 100, -100),
                };

                for (RelDist dist1 : relativeDistances) {
                    for (RelDist dist2 : relativeDistances) {
                        // calculate ratios
                        double ratio = dist1.distance / dist2.distance;
                        dist1.ratios.add(ratio);
                    }
                }
                int minX = 0;
                int minY = 0;
                double minError = Double.POSITIVE_INFINITY;

                for (int x = -100; x <= 100; x++) {
                    for (int y = -100; y <= 100; y++) {
                        double error = 0;

                        ArrayList<Double> distances = new ArrayList<>();
                        for (int i = 0; i < 3; i++) {
                            distances.add(distBetwPoints(x,y,relativeDistances[i].x,relativeDistances[i].y));
                        }
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                double ratio = distances.get(i) / distances.get(j);
                                error += Math.pow(Math.abs(ratio - relativeDistances[i].ratios.get(j)), 2);
                            }
                        }
                        if(error < minError) {
                            minX = x;
                            minY = y;
                            minError = error;
                        }
                    }
                }

                System.out.printf("%d %d\n", minX, minY);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static double distBetwPoints (int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
    }
}

class RelDist {
    protected double distance;
    protected int x;
    protected int y;
    protected ArrayList<Double> ratios;
    RelDist(float strength, int x, int y) {
        this.distance = Math.sqrt((double) 1 / strength);
        this.x = x;
        this.y = y;
        this.ratios = new ArrayList<>();
    }
}