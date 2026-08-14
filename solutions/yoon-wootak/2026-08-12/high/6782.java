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
			
			long N = Long.parseLong(br.readLine());
			int count = 0;
			
			while(N != 2) {
				double sq = Math.sqrt(N);
				
				if (sq % 1 == 0) {
					N = (long)sq;
					count++;
				}
				else {
					long temp = ((long)sq + 1) * ((long)sq + 1);
					count += temp - N;
					N = temp;
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}
}