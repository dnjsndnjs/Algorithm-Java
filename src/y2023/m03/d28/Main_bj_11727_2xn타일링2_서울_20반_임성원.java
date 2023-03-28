package y2023.m03.d28;

import java.io.*;

public class Main_bj_11727_2xn타일링2_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		dp[1] = 1;
		if (N > 1) dp[2] = 3;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i-1] + 2*dp[i-2];
			if (dp[i] > 10_007)
				dp[i] %= 10_007;
		}
		System.out.println(dp[N]);
		br.close();
	}
}
