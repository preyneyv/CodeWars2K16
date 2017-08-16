import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob12 {
    private static int direction = 0;
    private static int x;
    private static int y;
    private static String[][] spiral;

    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String[] dimensions_input = reader.readLine().split("\\s+");
            int[] dimensions = {
                    Integer.parseInt(dimensions_input[0]),
                    Integer.parseInt(dimensions_input[1])
            };
            spiral = new String[dimensions[0]][dimensions[1]];
            // spiral[y][x]

            for (int i = 0; i < dimensions[0]; i++) {
                String[] line = reader.readLine().split("");
                spiral[i] = line;
            }

            int startX = 0;
            int startY = 0;

            // find starting corner
            if(spiral[0][0].equals(" ")) {
                startX = 0;
                startY = 0;
                // left column : go down
                direction = 3;
            } else if (spiral[dimensions[0]-1][0].equals(" ")) {
                startX = 0;
                startY = dimensions[0]-1;
                // bottom row : go right
                direction = 2;
            } else if (spiral[dimensions[0]-1][dimensions[1]-1].equals(" ")) {
                startX = dimensions[1]-1;
                startY = dimensions[0]-1;
                // right column : go up
                direction = 1;
            } else if (spiral[0][dimensions[1]-1].equals(" ")) {
                startX = dimensions[1]-1;
                startY = 0;
                // top row : go left
                direction = 0;
            }
            x = startX;
            y = startY;
            StringBuilder word = new StringBuilder();

            // find starting
            while (spiral[y][x].equals(" ")) {
                spiral[y][x] = "@#";
                changePos();
                if (!inBounds(x, y)) {
                    unchangePos();
                    changeDirectionBackwards();
                    changePos();
                }
            }
            word.append(spiral[y][x]);
            // found starting
            while (!spiral[y][x].equals(" ")) {
                spiral[y][x] = "@#"; // change prev letter. used for turning

                changePos(); // go forward
                if (!inBounds(x, y) || spiral[y][x].equals("@#")) {
                    unchangePos(); // back up
                    changeDirectionBackwards(); // change direction
                    changePos(); // go forward
                }
                word.append(spiral[y][x]);
            }

            word.deleteCharAt(word.length()-1);
            System.out.println(word.reverse().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static boolean inBounds(int x, int y) {
        return (x > -1 && x < spiral[0].length && y > -1 && y < spiral.length);
    }
    static void changeDirectionBackwards() {
        // rotate counterclockwise

        // 0 = left
        // 1 = up
        // 2 = right
        // 3 = down

        if(--direction == -1)
            direction = 3;
    }
    static void changePos() {
        // go forwards
        switch (direction) {
            case 0:
                x--;
                break;
            case 1:
                y--;
                break;
            case 2:
                x++;
                break;
            case 3:
                y++;
                break;
        }
    }
    static void unchangePos() {
        // back up
        switch (direction) {
            case 0:
                x++;
                break;
            case 1:
                y++;
                break;
            case 2:
                x--;
                break;
            case 3:
                y--;
                break;
        }
    }
}
