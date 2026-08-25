import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case=1; test_case<=T; test_case++) {
            sb.append("#").append(test_case).append(" ");

            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();

            int[] arr = new int[10];
            for (int i=0; i<N; i++) {
                arr[s.charAt(i) - '0']++;
            }

            int max = -1;
            int maxCount = -1;
            for (int i=0; i<arr.length; i++) {
                if (maxCount <= arr[i]) {
                    maxCount = arr[i];
                    max = i;
                }
            }

            sb.append(max).append(" ").append(maxCount).append("\n");
        }

        System.out.println(sb);
    }
}