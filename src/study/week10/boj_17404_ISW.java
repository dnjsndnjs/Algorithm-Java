package study.week10;

import java.io.*;
import java.util.*;

public class boj_17404_ISW {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[3][];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			dp[i] = new int[] {1001, 1001, 1001};
			dp[i][i]= Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 3; j++) {
				int tmp1 = Math.min(dp[j][1], dp[j][2])+a;
				int tmp2 = Math.min(dp[j][0], dp[j][2])+b;
				int tmp3 = Math.min(dp[j][0], dp[j][1])+c;
				dp[j][0] = tmp1; dp[j][1] = tmp2; dp[j][2] = tmp3;
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) continue;
				if (ans > dp[i][j]) ans = dp[i][j];
			}
		}
		System.out.println(ans);
		br.close();
	}
}
