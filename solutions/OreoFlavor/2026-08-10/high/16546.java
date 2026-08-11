import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for(int tc = 1; tc <= testCase; tc++) {
            int[] num = new int[12];
            int isTriplet = 0;
            int isRun = 0;
            String input = sc.next();
            for(int i = 0; i < 6; i++) {
                num[input.charAt(i) - '0'] += 1;
            }

            for (int i = 0; i < 10; i++) {
                if(num[i] >= 3) {
                    int cnt = num[i] / 3;
                    isTriplet += cnt;
                    num[i] -= 3 * cnt;
                }
                if(num[i] > 0 && (num[i] == num[i + 1] && num[i] == num[i + 2])) {
                    isRun += num[i];
                    num[i + 2] -= num[i];
                    num[i + 1] -= num[i];
                    num[i] -= num[i];
                }
            }

            System.out.println("#" + tc + " " + (isTriplet + isRun == 2 ? "true" : "false"));
        }
    }
}