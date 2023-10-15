package y2023.m09.d06;

import java.io.*;
import java.util.*;

// 알약
public class BOJ_4811 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());;
        long[][] dp = new long[31][31];
        dp[0][0] = 1;
        int max = 0;
        while (N != 0) {
            if (max < N) {
                for (int i = max+1; i <= N; i++) {
                    long num = 0;
                    for (int j = 0; j <= i; j++)
                        dp[i][j] = num += dp[i-1][j];
                }
                max = N;
            }
            sb.append(dp[N][N]).append('\n');
            N = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
        br.close();
    }
}
