import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.ArrayList;

class Solution {
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        int M;
        int A;
        StringTokenizer st;
        StringTokenizer stA;
        StringTokenizer stB;
        int result;
        for(int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            int[] Aloc = new int[2]; //A 좌표
            int[] Bloc = new int[2]; //B 좌표
            
            int[][] BC = new int[A + 1][4]; //BC 정보 저장 공간
            int[] tempNode = {0, 0, 0, 0}; //접근 가능 BC가 없는 경우 처리

            result = 0; //결과 초기화

            init(Aloc, Bloc); //초기 좌표 설정

            stA = new StringTokenizer(br.readLine()); //A 이동 정보
            stB = new StringTokenizer(br.readLine()); //B 이동 정보

            BC[0] = tempNode;

            for(int i = 1; i <= A; i++) { //BC 정보
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 4; j++) {
                    BC[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ArrayList<Integer> listA = new ArrayList<>(); //각 시점에서 충전 가능한 BC
            ArrayList<Integer> listB = new ArrayList<>(); //각 시점에서 충전 가능한 BC
            int max; //각 시점별 최댓값
            int temp;

            for(int i = 0; i < M; i++) { //이동에 따른 순회
                max = 0;
                listA.add(0);
                listB.add(0);

                for(int j = 1; j <= A; j++) { //각 BC에 대해 검사
                    int[] current = BC[j];
                    if(inRange(Aloc, current)) { //A가 범위 내
                        listA.add(j); //리스트 추가
                    }
                    if(inRange(Bloc, current)) { //B가 범위 내
                        listB.add(j); //리스트 추가
                    }
                }
                
                for(int a = 0; a < listA.size(); a++) { //bruteforce
                    for(int b = 0; b < listB.size(); b++) {
                        if(listA.get(a) == listB.get(b)) { //BC가 같으면
                            temp = BC[listA.get(a)][3];
                        }
                        else {
                            temp = BC[listA.get(a)][3] + BC[listB.get(b)][3];
                        }
                        if(max < temp) {
                            max = temp;
                        }
                    }
                }

                result += max; //각 시점별 최댓값

                nextLoc(Aloc, Integer.parseInt(stA.nextToken())); //A 다음 좌표 계산
                nextLoc(Bloc, Integer.parseInt(stB.nextToken())); //B 다음 좌표 계산
                listA.clear();
                listB.clear();
            }

            //마지막 좌표에 대한 계산
            max = 0;
            listA.add(0);
            listB.add(0);

            for(int j = 1; j <= A; j++) { //각 BC에 대해 검사
                int[] current = BC[j];
                if(inRange(Aloc, current)) { //A가 범위 내
                    listA.add(j); //리스트 추가
                }
                if(inRange(Bloc, current)) { //B가 범위 내
                    listB.add(j); //리스트 추가
                }
            }
            
            for(int a = 0; a < listA.size(); a++) { //bruteforce
                for(int b = 0; b < listB.size(); b++) {
                    if(listA.get(a) == listB.get(b)) { //BC가 같으면
                        temp = BC[listA.get(a)][3];
                    }
                    else {
                        temp = BC[listA.get(a)][3] + BC[listB.get(b)][3];
                    }
                    if(max < temp) {
                        max = temp;
                    }
                }
            }

            result += max; //마지막 시점의 최댓값

            sb.append('#');
            sb.append(tc);
            sb.append(' ');
            sb.append(result);
            sb.append('\n');
        }

        
        System.out.println(sb);
        br.close();
    }

    static void init(int[] Aloc, int[] Bloc) {
        Aloc[0] = 1;
        Aloc[1] = 1;

        Bloc[0] = 10;
        Bloc[1] = 10;
    }

    static boolean inRange(int[] loc, int[] AP) {
        return Math.abs(loc[0] - AP[0]) + Math.abs(loc[1] - AP[1]) <= AP[2];
    }

    static void nextLoc(int[] loc, int move) {
        loc[0] = loc[0] + dy[move];
        loc[1] = loc[1] + dx[move];
    }
}
