import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(input.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
      int N = Integer.parseInt(input.readLine());
      String[] members = input.readLine().split(" ");
      int K = Integer.parseInt(input.readLine());
      String[] canceledMembers = input.readLine().split(" ");

      for (int idx = 0; idx < N; idx++) {
        for (int index = 0; index < K; index++) {
          if (members[idx].equals(canceledMembers[index])) {
            members[idx] = "";
            canceledMembers[index] = "";
            break;
          }
        }
      }

      boolean hasMember = false;
      sb.append("#" + test_case);
      for (int index = 0; index < N; index++) {
        if (members[index].isEmpty()) continue;
        hasMember = true;
        sb.append(" " + members[index]);
      }

      if (!hasMember) sb.append(" empty");
      sb.append("\n");
		}
    
    System.out.print(sb.toString());
	}
}
