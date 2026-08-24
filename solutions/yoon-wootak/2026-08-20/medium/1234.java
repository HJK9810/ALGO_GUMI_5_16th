import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test_case=1; test_case<=10; test_case++) {
            sb.append("#").append(test_case).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            Deque<Integer> stack = new ArrayDeque<>();
            for (int i=0; i<N; i++) {
                int num = s.charAt(i) - '0';

                if (!stack.isEmpty() && stack.peek() == num) {
                    stack.pop();
                }
                else {
                    stack.push(num);
                }
            }

            int[] arr = new int[stack.size()];
            for (int i=stack.size() - 1; i>=0; i--) {
                arr[i] = stack.pop();
            }

            for (int i=0; i<arr.length; i++) {
                sb.append(arr[i]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}