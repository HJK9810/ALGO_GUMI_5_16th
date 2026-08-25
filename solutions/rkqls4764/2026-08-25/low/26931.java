/*
26931. 컨베이어 벨트 상자 정리 (D2)
https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpD-qHZnHBIQj&categoryId=AZ6wpD-qHZnHBIQj&categoryType=CODE
*/

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      String input = br.readLine();
      Stack<Character> stack = new Stack<>();

      for (int i = 0; i < input.length(); i++) {
        if (stack.isEmpty() || stack.peek() != input.charAt(i)) {
          stack.add(input.charAt(i));
        } else {
          stack.pop();
        }
      }

      bw.write("#" + t + " " + stack.size() + "\n");
    }

    bw.flush();
  }
}
