import java.util.Scanner;

class Solution {
    static int N;
    static int[][] S;
    static int[] group;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int testCase = sc.nextInt();

        for(int tc = 1; tc <= testCase; tc++) {
            N = sc.nextInt();
            S = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    S[i][j] = sc.nextInt();
                } 
            }

            group = new int[N];
            group[0] = 1; //0번 인덱스 음식은 항상 그룹 1으로 배정
            min = 1120000; // (N/2 <= 8) -> 한 음식의 최대 시너지 수 = 56개 -> 56 * 20000

            dfs(1, 1);
            System.out.println("#" + tc + " " + min);
        }
        sc.close();
    }

    static void dfs(int index, int count) {
        if(count == N / 2) {
            int gap = calc();
            if(min > gap) {
                min = gap;
            }
            return;
        }

        if(count + (N - index) < N / 2) { //남아있는 것을 모두 뽑아도 안되는 경우
            return;
        }
        
        group[index] = 1;
        dfs(index + 1, count + 1);
        group[index] = 0;
        dfs(index + 1, count);
    }

    static int calc() {
        int[] taste = new int[2];
        int gap;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(group[i] == group[j]) {
                    taste[group[i]] += S[i][j] + S[j][i];
                }
            }
        }
        gap = taste[1] - taste[0];
        return (gap >= 0) ? gap : -gap;
    }
}
