import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private int compare(int[] maxList, int[] minList) {
        int loopSize = maxList.length - minList.length + 1;
        int minSize = minList.length;
        int maxTotal = Integer.MIN_VALUE;

        for (int start = 0; start < loopSize; start++) {
            int total = 0;
            for (int idx = 0; idx < minSize; idx++) {
                total += maxList[idx + start] * minList[idx];
            }
            maxTotal = Math.max(maxTotal, total);
        }

        return maxTotal;
    }

    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringTokenizer st;

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(input.readLine());
            for (int idx = 0; idx < N; idx++) {
                A[idx] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(input.readLine());
            for (int idx = 0; idx < M; idx++) {
                B[idx] = Integer.parseInt(st.nextToken());
            }

            int result = N < M ? sol.compare(B, A) : sol.compare(A, B);
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
