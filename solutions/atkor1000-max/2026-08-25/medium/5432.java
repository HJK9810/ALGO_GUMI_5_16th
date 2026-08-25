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
            int height = 0;
            int pieces = 0;
			String cuts = sc.next();
			for (int i = 0; i < cuts.length(); i++) {
            	if (cuts.charAt(i) == '(') {
                	height++;
                }
                if (cuts.charAt(i) == ')') {
                    height--;
                	if (cuts.charAt(i - 1) == '(') {
                    	pieces += height;
                    }
                    else pieces += 1;
                }
            }
            System.out.println("#" + test_case + " " + pieces);
		}
	}
}