import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            String str = br.readLine();
            TreeSet<String> comb = new TreeSet<>();

            for (int i = 0; i < str.length(); i++) {
                for (int j = i; j < str.length(); j++) {
                    comb.add(str.substring(i, j + 1));
                }
            }

            String result = "none";
            int idx = 0;

            for (String s : comb) {
                if (idx == K - 1) result = s;
                idx++;
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
