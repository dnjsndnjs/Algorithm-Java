package y2023.m03.d15;

import java.io.*;
import java.util.*;

public class Main_bj_11051_이항계수2 {
	static final int mod = 10_007;
	
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		K = Math.min(K, N-K);
		dp = new int[N+1][N+1];
		System.out.println(func(N, K));
		br.close();
	}
	
	static int func(int n, int k) {
		if (dp[n][k] != 0) return dp[n][k];
		if (n < k) return 0;
		if (k == 0) return dp[n][k] = dp[n][n-k] = 1;
		int num = func(n-1, k-1) + func(n-1, k);
		if (num >= mod) num %= mod;
		return dp[n][k] = dp[n][n-k] = num;
	}
}
