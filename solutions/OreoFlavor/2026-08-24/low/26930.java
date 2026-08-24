import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        int pass = 1;
        boolean valid = true;

        for(int tc = 1; tc <= testCase; tc++) {
            String input = br.readLine();
            Deque<Character> brackets = new ArrayDeque<>();

            pass = 1;
            for(int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);
                if(current == '\'' || current == '"') { //valid 변수 토글
                    valid = !valid;
                }
                if(valid == true) { //따옴표 바깥일 경우
                    if(current == '(') {
                        brackets.push(')');
                    }
                    if(current == '{') {
                        brackets.push('}');
                    }
                    if(current == ')' || current == '}') {    
                        if(brackets.isEmpty()) {
                            pass = 0;
                            break;
                        }
                        else if(current != brackets.pop()) {
                            pass = 0;
                            break;
                        }       
                    }
                }
            }

            if(!brackets.isEmpty()) {
                pass = 0;
            }

            sb.append("#");
            sb.append(tc);
            sb.append(" ");
            sb.append(pass);
            sb.append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}