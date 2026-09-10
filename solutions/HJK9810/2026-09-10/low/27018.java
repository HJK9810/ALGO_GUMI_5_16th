import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private int tracking(int left, int total) {
        if (left < 0 || total < 0) return 0;
        else if (left == 0 && total == 0) {
            return 1;
        }

        int count = 0;
        for (int num = 0; num < 10; num++) {
            count += tracking(left - 1, total - num);
        }
        return count;
    }

    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringTokenizer st;

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(input.readLine());
            int D = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int num = 0; num < 10; num++) {
                count += sol.tracking(D - 1, S - num);
            }
            System.out.printf("#%d %d\n", test_case, count);
        }
    }
}
