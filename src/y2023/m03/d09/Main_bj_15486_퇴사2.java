package y2023.m03.d09;

import java.io.*;
import java.util.*;

public class Main_bj_15486_퇴사2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if (max < dp[i])
				max = dp[i];
			if (i+t > N) continue;
			dp[i+t] = Math.max(max+p, dp[i+t]);
//			System.out.println(Arrays.toString(dp));
		}
		System.out.println(Math.max(max, dp[N]));
		br.close();
	}
}
