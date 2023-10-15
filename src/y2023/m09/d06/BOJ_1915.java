package y2023.m09.d06;

import java.io.*;
import java.util.*;

// 가장 큰 정사각형
public class BOJ_1915 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N][M];
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = s.charAt(j) == '1';
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int jl = 1;
            for (int j = 0; j < M; j++, jl++) {
                if (!map[i][j]) {
                    jl = 0;
                    continue;
                }
                int il = 1, ti = i;
                while (ti--> 0 && map[ti][j]) il++;
                int minl = Math.min(jl, il);
                if (i > 0 && j > 0 && map[i-1][j-1])
                    dp[i][j] = Math.min(dp[i-1][j-1]+1, minl);
                else dp[i][j] = 1;
                if (ans < dp[i][j])
                    ans = dp[i][j];
            }
        }
        System.out.println(ans*ans);
        br.close();
    }
}
