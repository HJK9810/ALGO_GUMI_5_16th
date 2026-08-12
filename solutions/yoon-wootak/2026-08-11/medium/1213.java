import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test_case=1; test_case<=10; test_case++) {
            br.readLine();
            sb.append("#").append(test_case).append(" ");

            String word = br.readLine();
            String sentence = br.readLine();

            int count = 0;
            for (int i=0; i<=sentence.length()-word.length(); i++) {
                if(sentence.substring(i, i+word.length()).equals(word)) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}