import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int target = arr[N - 1];

            for (int i = N - 2; i >= 0; i--) {
                if (target < arr[i]) target = arr[i];
                else sum += target - arr[i];
            }

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(sum)
                    .append('\n');
        }
        System.out.print(sb);
    }
}
