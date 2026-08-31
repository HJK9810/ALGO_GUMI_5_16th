import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			
			int N = sc.nextInt();
            String[] cards = new String[N];
            int mid = N % 2 == 1 ? N / 2 + 1 : N / 2;
            
            String[] shuffled = new String[N];
            for (int n = 0; n < N; n++) cards[n] = sc.next();
            
            if (N % 2 == 1) {
            	for (int i = 0; i < mid; i++) {
                	if (i == mid - 1) shuffled[N - 1] = cards[mid - 1];
                    else {shuffled[2 * i] = cards[i]; shuffled[2 * i + 1] = cards[mid + i];}
                    
                }
            }
            else for (int i = 0; i < mid; i++) {shuffled[2 * i] = cards[i]; shuffled[2 * i + 1] = cards[mid + i];}
            System.out.print("#" + test_case);
            for (int n = 0; n < N; n++) {
            	System.out.print(" " + shuffled[n]);
            }
            System.out.println();
		}
	}
}