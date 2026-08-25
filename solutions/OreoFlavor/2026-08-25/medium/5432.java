import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//21:33
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= testCase; tc++) {
            int layer = 0;
            int piece = 0;
            String input = br.readLine();

            char before = ')';
            char current;
            
            for(int i = 0; i < input.length(); i++) {
                current = input.charAt(i);
                if(before == current) {
                    if(before == '(') {
                        layer++;
                    }
                    else if(before == ')'){
                        layer--;
                        piece++;
                    }
                }
                else if(before == '(') {
                    piece += layer;
                }
                before = current;
            }

            sb.append('#');
            sb.append(tc);
            sb.append(' ');
            sb.append(piece);
            sb.append('\n');
        }

        System.out.print(sb);

        br.close();
    }
}
