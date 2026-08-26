import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int k = sc.nextInt();
            int called = 0;
            for (int i = 0; i < k; i++) {
            	int j  = sc.nextInt();
                if (j == 2) called++;
            }
            
            System.out.print("#" + test_case);
            for (int i = 1; i <= called; i++) {
            	System.out.print(" " + i);
            }
            System.out.println();
		}
	}
}