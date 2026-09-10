import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        int current;
        int before;
        for(int tc = 1; tc <= testCase; tc++) {
            String input = br.readLine();
            int cnt = 0;
            before = 0;
            
            for(int i = 0; i < input.length(); i++) {
                current = input.charAt(i) - '0';
                cnt += before ^ current; //if 연산 대체
                before = current;
            }
            sb.append('#').append(tc).append(' ').append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}