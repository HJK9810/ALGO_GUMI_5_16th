import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

class Solution {
    static String line;
    static ArrayList<Integer> list;
    static TreeSet<Integer> set;
    static int N;
    static int K;
    static int singleLength;
    static int password;
    static int quotient;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int tc = 1; tc <= testCase; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            singleLength = N / 4;
            quotient = (int) Math.pow(16, singleLength - 1);

            line = sc.next();
            set = new TreeSet<>(Collections.reverseOrder());

            for(int i = 0; i < singleLength - 1; i++) {
                line = line + line.charAt(i);
            }

            password = Character.digit(line.charAt(0), 16);
            for(int i = 1; i < singleLength; i++) {
                password *= 16;
                password += Character.digit(line.charAt(i), 16);
            }
            set.add(password);


            for(int i = singleLength; i < N + singleLength - 1; i++) {
                password = password % quotient * 16 + Character.digit(line.charAt(i), 16);
                set.add(password);
            }
            list = new ArrayList<>(set);

            System.out.println("#" + tc + " " + list.get(K - 1));
        }
    }
}
