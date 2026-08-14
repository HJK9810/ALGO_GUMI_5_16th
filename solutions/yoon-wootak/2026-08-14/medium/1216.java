import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test_case=1; test_case<=10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			sb.append("#").append(T).append(" ");
			
			char[][] arr = new char[100][100];
			for (int r=0; r<100; r++) {
				String s = br.readLine();
				for (int c=0; c<100; c++) {
					arr[r][c] = s.charAt(c);
				}
			}
			
			int N = 100;
			int answer = -1;
			
			while (N > 0) {
				for (int r=0; r<100; r++) {
					for (int c=0; c<=100-N; c++) {
						
						boolean isHorSame = true;
						for (int i=0; i<N/2; i++) {
							if (arr[r][c+i] != arr[r][c+N-1-i]) {
								isHorSame = false;
								break;
							}
						}
						
						boolean isVerSame = true;
						for (int i=0; i<N/2; i++) {
							if (arr[c+i][r] != arr[c+N-1-i][r]) {
								isVerSame = false;
								break;
							}
						}
						
						if (isHorSame || isVerSame) {
							answer = N;
							break;
						}
					}
					
					if (answer != -1) {
						break;
					}
				}
				
				if (answer != -1) {
					break;
				}
				
				N--;
			}
			
			sb.append(answer).append("\n");
		}
		
		//문제 특성상 가장 마지막의 줄바꿈에서 오답으로 인식
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}
}