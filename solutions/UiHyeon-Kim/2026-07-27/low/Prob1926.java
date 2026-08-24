import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1926 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            int cnt = 0;

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == '3' || ch == '6' || ch == '9') cnt++;
            }

            if (cnt == 0) {
                sb.append(i);
            } else {
                for (int j = 0; j < cnt; j++) {
                    sb.append('-');
                }
            }
            sb.append(' ');
        }

        System.out.println(sb);
    }
}