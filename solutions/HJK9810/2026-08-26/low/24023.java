import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    int T = Integer.parseInt(input.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
      String SIZE = input.readLine();
      String[] codes = input.readLine().split(" ");

      int outNum = 0;
      int inNum = 0;

      for (String code : codes) {
        if (code.equals("1")) {
          inNum++;
        } else if (outNum <= inNum && code.equals("2")) {
          outNum += 1;
          sb.append(outNum).append(" ");
        }
      }

      System.out.printf("#%d %s\n", test_case, sb.toString());
      sb.setLength(0);
		}

    input.close();
	}
}
