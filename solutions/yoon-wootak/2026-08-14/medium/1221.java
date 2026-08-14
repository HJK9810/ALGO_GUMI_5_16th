import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] num = {
				"ZRO",
				"ONE",
				"TWO",
				"THR",
				"FOR",
				"FIV",
				"SIX",
				"SVN",
				"EGT",
				"NIN"
		};
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case=1; test_case<=T; test_case++) {
			sb.append("#").append(test_case).append("\n");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			for (int i=0; i<N; i++) {
				String s = st.nextToken();
				for (int j=0; j<num.length; j++) {
					if (s.equals(num[j])) {
						arr[i] = j;
					}
				}
			}
			
			Arrays.sort(arr);
			
			for (int i=0; i<arr.length; i++) {
				sb.append(num[arr[i]]).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}