import java.util.Scanner;

class Solution {
//	static int answer;
//
//	public static void main(String[] args) throws Exception {
//		//System.setIn(new FileInputStream("input.txt"));
//
//		Scanner sc = new Scanner(System.in);
//
//		for (int test_case=1; test_case<=10; test_case++) {
//			System.out.print("#" + test_case + " ");
//			sc.nextLine();
//
//			int N = Integer.parseInt(sc.next());
//			int M = Integer.parseInt(sc.next());
//			sc.nextLine();
//
//			answer = 1;
//			exp(N, M);
//
//			System.out.println(answer);
//		}
//	}
//
//	static void exp(int N, int M) {
//		if (M == 0) {
//			return;
//		}
//
//		answer = answer * N;
//		exp(N, M-1);
//	}


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        for (int test_case=1; test_case<=10; test_case++) {
            System.out.print("#" + test_case + " ");
            sc.nextLine();

            int N = Integer.parseInt(sc.next());
            int M = Integer.parseInt(sc.next());
            sc.nextLine();

            int answer = exp(N, M);

            System.out.println(answer);
        }
    }

    static int exp(int N, int M) {
        if (M == 0) {
            return 1;
        }

        return N * exp(N, M-1);
    }
}