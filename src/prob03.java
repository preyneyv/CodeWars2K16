import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prob03 {
    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            
            int num_words = Integer.parseInt(reader.readLine());

            String[] ob = new String[num_words];

            Pattern regex = Pattern.compile("(.)\\1");

            for (int i = 0; i < num_words; i++) {
                String word = reader.readLine();
                Matcher m = regex.matcher(word);
                if(m.find()) {
                    ob[i] = String.format("likes %s", word);
                } else {
                    ob[i] = String.format("hates %s", word);
                }
            }

            for (String text: ob) {
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
