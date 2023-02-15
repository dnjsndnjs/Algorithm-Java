package y2023.m02.d15;

import java.io.*;
import java.util.*;

public class Main_bj_12865_평범한배낭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] wv = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			wv[i][0] = Integer.parseInt(st.nextToken());
			wv[i][1] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				int w = wv[i][0], v = wv[i][1];
				if (j < w)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w]+v);
			}
		}
		System.out.println(dp[N][K]);
		br.close();
	}
}
