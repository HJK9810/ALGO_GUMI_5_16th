import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            StringBuilder row = new StringBuilder();
            StringBuilder col = new StringBuilder();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    row.append(board[i][j]);
                    col.append(board[j][i]);
                }
                row.append('0');
                col.append('0');
            }

            int result = 0;

            for (String nums : row.toString().split("0")) {
                if (nums.length() == k) result++;
            }

            for (String nums : col.toString().split("0")) {
                if (nums.length() == k) result++;
            }

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(result)
                    .append('\n');
        }
        System.out.print(sb);
    }
}
