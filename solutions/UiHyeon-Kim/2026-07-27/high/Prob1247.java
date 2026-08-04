import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1247 {

    private static class Pair {
        int first;
        int second;

        Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    private static int n;
    private static Pair company;
    private static Pair home;
    private static Pair[] customers;
    private static boolean[] visited;
    private static int minDist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            company = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            customers = new Pair[n];

            for (int i = 0; i < n; i++) {
                customers[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            visited = new boolean[n];
            minDist = Integer.MAX_VALUE;

            dfs(company, 0, 0);

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(minDist)
                    .append('\n');
        }
        System.out.print(sb);
    }

    private static int getDist(Pair a, Pair b) {
        return Math.abs(a.first - b.first) + Math.abs(a.second - b.second);
    }

    private static void dfs(Pair curr, int cnt, int sum) {
        if (sum >= minDist) return;

        if (cnt == n) {
            int totalDist = sum + getDist(curr, home);
            minDist = Math.min(minDist, totalDist);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(customers[i], cnt + 1, sum + getDist(curr, customers[i]));
            visited[i] = false;
        }
    }
}