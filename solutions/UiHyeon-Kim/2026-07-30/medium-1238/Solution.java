import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static final int MAX_SIZE = 101;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int _ = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ArrayList<Integer>[] graph = new ArrayList[MAX_SIZE];

            for (int i = 0; i < MAX_SIZE; i++) {
                graph[i] = new ArrayList<>();
            }

            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
            }

            ArrayDeque<Integer> dq = new ArrayDeque<>();
            boolean[] visited = new boolean[MAX_SIZE];

            dq.offer(start);
            visited[start] = true;

            int result = 0;

            while (!dq.isEmpty()) {
                int size = dq.size();
                int currMAX = 0;

                for (int i = 0; i < size; i++) {
                    int current = dq.poll();
                    currMAX = Math.max(currMAX, current);

                    for (int next : graph[current]) {
                        if (visited[next]) continue;

                        visited[next] = true;
                        dq.offer(next);
                    }
                }

                result = currMAX;
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