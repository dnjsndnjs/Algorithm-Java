package y2023.m03.d09;

import java.io.*;
import java.util.*;

public class Main_bj_5557_1학년 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		long[][] dp = new long[N][21];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		dp[0][nums[0]] = 1;
		for (int i = 1; i < N-1; i++) {
			for (int n = 0; n <= 20; n++) {
				long res = 0;
				if (n-nums[i] >= 0)
					res += dp[i-1][n-nums[i]];
				if (n+nums[i] <= 20)
					res += dp[i-1][n+nums[i]];
				dp[i][n] = res;
			}
		}
		System.out.println(dp[N-2][nums[N-1]]);
	}
}
