class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int arrivals = sc.nextInt();
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < arrivals; i++) {
            	int dir = sc.nextInt();
                int id = sc.nextInt();
                if (dir == 1) deque.addFirst(id);
                else deque.addLast(id);
            }
            int K = deque.size();
            System.out.print("#" + test_case);
            for (int k = 0; k < K; k++) System.out.print(" " + deque.pollFirst());
            System.out.println();
		}
	}
}