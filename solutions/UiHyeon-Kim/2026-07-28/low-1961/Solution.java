import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append('#').append(tc).append('\n');

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(board[n - 1 - j][i]);
                }
                sb.append(' ');

                for (int j = 0; j < n; j++) {
                    sb.append(board[n - 1 - i][n - 1 - j]);
                }
                sb.append(' ');

                for (int j = 0; j < n; j++) {
                    sb.append(board[j][n - 1 - i]);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}
