import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken()); // 1리터당 요금
            int Q = Integer.parseInt(st.nextToken()); // R리터 기본 요금
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken()); // 초과 사용 1리터당 요금
            int W = Integer.parseInt(st.nextToken()); // 전체 사용한 리터

            int aCompany = P * W;
            int bCompany = R >= W ? Q : Q + (W - R) * S;

            int result = Math.min(aCompany, bCompany);

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(result)
                    .append('\n');
        }
        System.out.print(sb);
    }
}
