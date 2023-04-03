package y2023.m04.d01;

import java.io.*;
import java.util.*;

public class Main_bj_2294_동전2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		for (int i = 0; i < n; i++)
			coins[i] = Integer.parseInt(br.readLine());
		int[] dp = new int[k+1];
		for (int i = 1; i <= k; i++) {
			dp[i] = k+1;
			for (int j = 0; j < n; j++) {
				if (i - coins[j] < 0) continue;
				dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
			}
		}
		int ans = dp[k];
		if (ans == k+1) ans = -1;
		System.out.println(ans);
		br.close();
	}
}
