import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                union(v1, v2);
            }

            Set<Integer> result = new HashSet<>();

            for (int i = 1; i <= N; i++) {
//                System.out.println(find(i));
                result.add(find(i));
            }

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(result.size())
                    .append('\n');
        }
        System.out.print(sb);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        if (rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
}
