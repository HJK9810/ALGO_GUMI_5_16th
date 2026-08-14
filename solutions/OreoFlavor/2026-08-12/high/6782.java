import java.util.Scanner;

class Solution {
  static long count;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testCase = sc.nextInt();

    for(int tc = 1; tc <= testCase; tc++) {
      long N = sc.nextLong();

      count = 0;
      counting(N);
      System.out.println("#" + tc + " " + count);
    }
    
    sc.close();
  }

  static long nextSq(long N) { //제곱수가 아닌 경우 다음 제곱수 탐색
    long seil = (long)Math.sqrt(N) + 1;
    return seil * seil;
  }
  static boolean sqCheck(Long N) { //제곱수 체크
    return (Math.sqrt(N) % 1 == 0);
  }

  static void counting(Long N) {
    if(N == 2) {
      return;
    }
    if(sqCheck(N)) {
      count++;
      counting((long)Math.sqrt(N));
    }
    else {
      count += nextSq(N) - N;
      counting((nextSq(N)));
    }
  }
}