import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] buildings = new int[n];

            for (int i = 0; i < n; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;

            for (int i = 2; i < buildings.length - 2; i++) {
                int side = Math.max(Math.max(buildings[i - 2], buildings[i - 1]), Math.max(buildings[i + 1], buildings[i + 2]));

                if (buildings[i] > side) {
                    result += buildings[i] - side;
                }
            }

            sb.append('#')
                .append(tc)
                .append(' ')
                .append(result)
                .append('\n');
        }

        System.out.println(sb);
    }
}
