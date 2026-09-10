import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            char[] base = input.readLine().toCharArray();
            char[] bit = new char[base.length];
            Arrays.fill(bit, '0');
            int count = 0;

            if (base[0] == '1') {
                bit[0] = '1';
                count = 1;
            }

            for (int idx = 1; idx < base.length; idx++) {
                if (base[idx] != bit[idx - 1]) {
                    count += 1;
                }
                bit[idx] = base[idx];
            }

            System.out.printf("#%d %d\n", test_case, count);
        }
    }
}
