package y2023.m04.d01;

import java.io.*;

public class Main_bj_10844_쉬운계단수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][12];
		for (int i = 1; i < 10; i++)
			dp[0][i+1] = 1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++)
				dp[i][j+1] = (dp[i-1][j] + dp[i-1][j+2]) % 1_000_000_000;
		}
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += dp[N-1][i+1];
			ans %= 1_000_000_000;
		}
		System.out.println(ans);
		br.close();
	}
}
