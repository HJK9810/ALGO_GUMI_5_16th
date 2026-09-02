/*
26938. 하위 조직 인원수 세기 (D2)
https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpGHaHbXHBIQj&categoryId=AZ6wpGHaHbXHBIQj&categoryType=CODE
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      int E = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());

      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for (int e = 0; e <= E + 1; e++) {
        graph.add(new ArrayList<>());
      }

      st = new StringTokenizer(br.readLine());
      for (int e = 0; e < E; e++) {
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        graph.get(start).add(end);
      }

      ArrayDeque<Integer> queue = new ArrayDeque<>();
      queue.offer(N);
      int answer = 0;

      while (!queue.isEmpty()) {
        int cur = queue.poll();
        answer++;

        for (int next : graph.get(cur)) {
          queue.offer(next);
        }
      }

      bw.write("#" + t + " " + answer + "\n");
    }

    bw.flush();
  } 
}
