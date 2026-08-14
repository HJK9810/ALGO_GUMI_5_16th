import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case=1; test_case<=T; test_case++) {
            sb.append("#").append(test_case).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[][] codeArr = {
                    {"000", "11", "0", "1"},
                    {"00", "11", "00", "1"},
                    {"00", "1", "00", "11"},
                    {"0", "1111", "0", "1"},
                    {"0", "1", "000", "11"},
                    {"0", "11", "000", "1"},
                    {"0", "1", "0", "1111"},
                    {"0", "111", "0", "11"},
                    {"0", "11", "0", "111"},
                    {"000", "1", "0", "11"}
            };

            Set<String> hs = new HashSet<>();
            int sum = 0;

            for (int r=0; r<N; r++) {
                String s = br.readLine();
                String code = "";

                for (int c=M-1; c>=0; c--) {
                    char ch = s.charAt(c);
                    String binary = "";

                    if (!code.equals("") || ch != '0') {
                        if (ch >= '0' && ch <= '9') {
                            binary = Integer.toBinaryString(ch - '0');
                        } else {
                            binary = Integer.toBinaryString(ch - 'A' + 10);
                        }

                        while(binary.length() < 4) {
                            binary = "0" + binary;
                        }

                        code = binary + code;
                    }

                    int codeLen = code.length();
                    String codeToNum = "";
                    int nTimes = codeLen / 56;
                    if (codeLen >= 56) {
                        if (code.charAt(codeLen - 1) == '0') {
                            while(code.charAt(codeLen - 1) == '0') {
                                code = code.substring(0, codeLen - 1);
                                codeLen = code.length();
                            }
                        }
                        else {
                            for (int i=codeLen; i-7*nTimes>=0 ; i-=7*nTimes) {
                                String codeSub = code.substring(i-7*nTimes, i);

                                for (int j=0; j<10; j++) {
                                    String codeAns = "";

                                    for (int l=0; l<4; l++) {

                                        for (int k=0; k<nTimes; k++) {
                                            codeAns += codeArr[j][l];
                                        }
                                    }

                                    if (codeSub.equals(codeAns)) {
                                        codeToNum = j + codeToNum;
                                        break;
                                    }
                                }

                                if (codeToNum.length() == 8) {
                                    hs.add(codeToNum);
                                    code = "";
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            for (String s : hs) {
                //검증코드 계산
                int ca0 = s.charAt(0) - '0';
                int ca1 = s.charAt(1) - '0';
                int ca2 = s.charAt(2) - '0';
                int ca3 = s.charAt(3) - '0';
                int ca4 = s.charAt(4) - '0';
                int ca5 = s.charAt(5) - '0';
                int ca6 = s.charAt(6) - '0';
                int ca7 = s.charAt(7) - '0';

                if ( ( (ca0 + ca2 + ca4 + ca6) * 3 + (ca1 + ca3 + ca5 + ca7) ) % 10 == 0 ) {
                    sum += ca0 + ca1 + ca2 + ca3 + ca4 + ca5 + ca6 + ca7;
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}