/*
27023. 은행 번호표 발급기 (D1)
https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87c2tayF3HBITH&categoryId=AZ87c2tayF3HBITH&categoryType=CODE
*/

import java.io.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    
    for (int t = 1; t <= T; t++) {
      int M = Integer.parseInt(br.readLine());
      String input = br.readLine();
      int cnt = 1;

      bw.write("#" + t);

      for (int i = 0; i < input.length(); i += 2) {
        char value = input.charAt(i);

        if (value == '2') {
          bw.write(" " + cnt++);
        }
      }

      bw.write("\n");
    }

    bw.flush();
  }
}