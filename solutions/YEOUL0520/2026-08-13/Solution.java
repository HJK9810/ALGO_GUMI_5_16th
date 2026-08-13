import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String args[]) throws IOException {

        /*
         * 1215. 회문1
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            int N = Integer.parseInt(br.readLine());

            char[][] arr = new char[8][8];

            // 배열 입력
            for (int i = 0; i < 8; i++) {
                String input = br.readLine();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = input.charAt(j);
                }
            }

            int count = 0;

            // 가로 회문 검사
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - N; j++) {

                    boolean isPalindrome = true;

                    for (int k = 0; k < N / 2; k++) {
                        if (arr[i][j + k] != arr[i][j + N - 1 - k]) {
                            isPalindrome = false;
                            break;
                        }
                    }

                    if (isPalindrome) { count++; }
                }
            }

            // 세로 회문 검사
            for (int j = 0; j < 8; j++) {
                for (int i = 0; i <= 8 - N; i++) {

                    boolean isPalindrome = true;

                    for (int k = 0; k < N / 2; k++) {
                        if (arr[i + k][j] != arr[i + N - 1 - k][j]) {
                            isPalindrome = false;
                            break;
                        }
                    }

                    if (isPalindrome) { count++; }
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}