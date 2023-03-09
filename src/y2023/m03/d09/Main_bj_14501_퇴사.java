package y2023.m03.d09;

import java.io.*;
import java.util.*;

public class Main_bj_14501_퇴사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] work = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++)
				work[i][j] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int t = work[N-i][0];
			int p = work[N-i][1];
			if (i - t <0) continue;
			dp[i] = Math.max(dp[i-t]+p, dp[i]);
			for (int j = i+1; j <= N; j++)
				dp[j] = dp[j-1];
//			System.out.println(Arrays.toString(dp));
		}
		System.out.println(dp[N]);
		br.close();
	}
}
