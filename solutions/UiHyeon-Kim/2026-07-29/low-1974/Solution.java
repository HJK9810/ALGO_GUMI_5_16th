import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    private static final int SUDOKU_SIZE = 9;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int[][] sudoku = new int[SUDOKU_SIZE][SUDOKU_SIZE];

            for (int line = 0; line < SUDOKU_SIZE; line++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int i = 0; i < SUDOKU_SIZE; i++) {
                    sudoku[line][i] = Integer.parseInt(st.nextToken());
                }
            }

            boolean isSudoku = true;

            for (int i = 0; i < SUDOKU_SIZE; i++) {
                HashSet<Integer> row = new HashSet<>();
                HashSet<Integer> col = new HashSet<>();

                for (int j = 0; j < SUDOKU_SIZE; j++) {
                    row.add(sudoku[i][j]);
                    col.add(sudoku[j][i]);
                }

                if (row.size() != 9 || col.size() != 9) isSudoku = false;
            }

            if (isSudoku) {
                HashSet<Integer> block = new HashSet<>();

                for (int i = 0; i < SUDOKU_SIZE; i += 3) {
                    for (int j = 0; j < SUDOKU_SIZE; j += 3) {
                        for (int k = 0; k < 3; k++) {
                            for (int l = 0; l < 3; l++) {
                                block.add(sudoku[k][l]);
                            }
                        }
                    }
                }

                if (block.size() != 9) isSudoku = false;
            }

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(isSudoku ? 1 : 0)
                    .append('\n');
        }

        System.out.print(sb);
    }
}
