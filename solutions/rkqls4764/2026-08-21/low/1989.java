/*
1989. 초심자의 회문 검사 (D2)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PyTLqAf4DFAUq&categoryId=AV5PyTLqAf4DFAUq&categoryType=CODE&problemTitle=1989&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
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
      boolean isPossible = true;

      int s = 0;
      int e = input.length() - 1;

      while (s < e) {
        if (input.charAt(s) != input.charAt(e)) {
          isPossible = false;
          break;
        }

        s++;
        e--;
      }
      
      bw.write("#" + t + " " + (isPossible ? "1" : "0") + "\n");
    }

    bw.flush();
  }
}
