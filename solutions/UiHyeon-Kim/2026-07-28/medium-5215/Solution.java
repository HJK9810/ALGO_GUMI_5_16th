/**
 * 5215 햄버거 다이어트
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static Material[] materials;
    private static int maxScore;
    private static int limitKcal;

    private static class Material {
        int score;
        int kcal;

        Material(int score, int kcal) {
            this.score = score;
            this.kcal = kcal;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            // 재료 수, 제한 칼로리
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            limitKcal = Integer.parseInt(st.nextToken());
            materials = new Material[n];
            maxScore = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                materials[i] = new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            getMaxScore(0, 0, 0);

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(maxScore)
                    .append('\n');
        }

        System.out.print(sb);
    }

    private static void getMaxScore(int idx, int score, int kcal) {
        if (limitKcal < kcal) return;
        maxScore = Math.max(maxScore, score);
        if (idx == materials.length) return;

        getMaxScore(idx + 1, score, kcal);
        getMaxScore(idx + 1, score + materials[idx].score, kcal + materials[idx].kcal);
    }
}
