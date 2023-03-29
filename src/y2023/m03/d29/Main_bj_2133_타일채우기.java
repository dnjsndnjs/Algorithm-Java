package y2023.m03.d29;

import java.io.*;

public class Main_bj_2133_타일채우기 {
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		if ((N&1)==0) {
			N /= 2;
			dp = new int[N+3];
			int sum = 4;
			dp[1] = 3;
			for (int i = 2; i <= N; i++) {
				dp[i] = sum * 2 + dp[i-1];
				sum += dp[i];
			}
			ans = dp[N];
		}
		System.out.println(ans);
		br.close();
	}
}
