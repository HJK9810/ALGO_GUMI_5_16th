import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test_case=1; test_case<=10; test_case++) {
			sb.append("#").append(test_case).append(" ");
			
			int size = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];
			
			for (int r=0; r<8; r++) {
				String s = br.readLine();
				for (int c=0; c<8; c++) {
					arr[r][c] = s.charAt(c);
				}
			}
			
			int count = 0;
			for (int r=0; r<8; r++) {
				for (int c=0; c<=8-size; c++) {
					boolean isHorSame = true;
					boolean isVerSame = true;
		
					for (int i=0; i<size/2; i++) {
						if (arr[r][c+i] != arr[r][c+size-1-i]) {
							isHorSame = false;
							break;
						}
					}
					
					for (int i=0; i<size/2; i++) {
						if (arr[c+i][r] != arr[c+size-1-i][r]) {	
							isVerSame = false;
							break;
						}
					}
					
					if (isHorSame) {
						count++;
					}
					
					if (isVerSame) {
						count++;
					}
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}
}