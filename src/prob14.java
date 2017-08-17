import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class prob14 {
    public static void main(String[] args){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            int num_inputs = Integer.parseInt(reader.readLine());
            String[] encoded_strings = new String[num_inputs];
            for (int i = 0; i < num_inputs; i++) {
                encoded_strings[i] = reader.readLine();
            }

            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            for (String cipher : encoded_strings) {
                String[] sentences = cipher.split("\\.");
                String[] outputSentences = new String[sentences.length];
                int k = 0;
                for (String sentence : sentences) {
                    StringBuilder letters = new StringBuilder(sentence);
                    char[] output = new char[letters.length()];
                    for (int i = 0; i < letters.length(); i++) {
                        output[i] = '-';
                    }

                    for (int i = 0; i < output.length; i++) {
                        output[i] = letters.charAt(0);
                        int letter = alphabet.indexOf(letters.charAt(0)) + 1;
                        letters.deleteCharAt(0);
                        letters = rotate(letters, 1-getShift(letter));
                    }

                    outputSentences[k] = new String(output);
                    k++;
                }
                for(String printMe : outputSentences) {
                    System.out.print(printMe+".");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int getShift(int nthLetter) {
        if (nthLetter == 0)
            return 6;
        int n = 0;
        for (int i = 0; i < nthLetter; i++) {
            n++;
            if (n == 6)
                n = 1;
        }
        return n;
    }
    private static StringBuilder rotate(StringBuilder text, int num) {
        if(text.length() == 0)
            return text;
        if(num > 0) {
            for (int i = 0; i < num; i++) {
                char ltr = text.charAt(text.length()-1);
                text.deleteCharAt(text.length()-1).insert(0, ltr);
            }
        } else {
            num = Math.abs(num);
            for (int i = 0; i < num; i++) {
                char ltr = text.charAt(0);
                text.deleteCharAt(0).append(ltr);
            }
        }
        return text;
    }
}
