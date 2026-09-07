import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
    private LinkedList<Integer> baseLine;

    private int findIdx(int sample) {
        for (int idx = 0; idx < baseLine.size(); idx++) {
            if (baseLine.get(idx) > sample) return idx;
        }
        return -1;
    }

    private void insertData(int[] tile, int sampleIdx) {
        if (sampleIdx == -1) {
            for (int value : tile) {
                baseLine.add(value);
            }
        } else {
            for (int idx = 0; idx < tile.length; idx++) {
                baseLine.add(sampleIdx + idx, tile[idx]);
            }
        }
    }

    private String printLastCase() {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        while (!baseLine.isEmpty() && count < 10) {
            sb.append(baseLine.removeLast()).append(" ");
            count++;
        }

        return sb.toString();
    }

    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sol.baseLine = new LinkedList<>();
            int[][] tiles = new int[M - 1][N];

            st = new StringTokenizer(input.readLine());
            for (int idx = 0; idx < N; idx++) {
                sol.baseLine.add(Integer.parseInt(st.nextToken()));
            }

            for (int row = 0; row < M - 1; row++) {
                st = new StringTokenizer(input.readLine());

                for (int col = 0; col < N; col++) {
                    tiles[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            for (int[] tileCase : tiles) {
                int sample = tileCase[0];
                int sampleIdx = sol.findIdx(sample);
                sol.insertData(tileCase, sampleIdx);
            }

            System.out.printf("#%d %s\n", test_case, sol.printLastCase());
        }
    }
}
