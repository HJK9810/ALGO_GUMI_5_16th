import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case=1; test_case<=T; test_case++) {
            sb.append("#").append(test_case).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[N+1];

            for (int i=1; i<N+1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                //a와 b 모두 조회 했을때 서로가 나와야 하니까 양방향으로 추가
                graph[a].add(b);
                graph[b].add(a);
            }

            //bfs
            //visited는 거리 문제가 아닌 경우
            //distance는 거리 문제인 경우

//			boolean[] visited = new boolean[N+1];
            int[] distance = new int[N+1];
            Arrays.fill(distance, -1); //-1은 방문하지 않음

            Queue<Integer> queue = new ArrayDeque<>();

            queue.offer(1);

//			visited[1] = true;
            distance[1] = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : graph[current]) {
//					if (!visited[next]) {
//						queue.offer(next);
//						visited[next] = true;
//					}
                    if (distance[next] == -1) {
                        queue.offer(next);
                        distance[next] = distance[current] + 1;
                    }
                }
            }

            int answer = 0;
            for (int i=1; i<distance.length; i++) {
                if (distance[i] >= 1 && distance[i] <= 2) {
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}