import java.io.*;
import java.util.*;

class Solution {
	static int count;
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case=1; test_case<=T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			
			count = 0;
			N = divide(N, 2);
			sb.append(count).append(" ");
			
			count = 0;
			N = divide(N, 3);
			sb.append(count).append(" ");
			
			count = 0;
			N = divide(N, 5);
			sb.append(count).append(" ");
			
			count = 0;
			N = divide(N, 7);
			sb.append(count).append(" ");
			
			count = 0;
			N = divide(N,11);
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int divide(int N, int x) {
		if (N % x != 0) {
			return N;
		}
		
		N = N / x;
		count++;
		
		return divide(N, x);
	}
}