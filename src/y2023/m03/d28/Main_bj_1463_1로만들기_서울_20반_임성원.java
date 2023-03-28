package y2023.m03.d28;

import java.io.*;

public class Main_bj_1463_1로만들기_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		for (int i = 2; i <= N; i++) {
			int tmp = dp[i-1];
			if (i%2 == 0 && tmp > dp[i/2])
				tmp = dp[i/2];
			if (i%3 == 0 && tmp > dp[i/3])
				tmp = dp[i/3];
			dp[i] = tmp+1;
		}
		System.out.println(dp[N]);
		br.close();
	}
}
