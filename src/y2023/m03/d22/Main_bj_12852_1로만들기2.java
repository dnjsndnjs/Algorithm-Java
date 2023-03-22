package y2023.m03.d22;

import java.io.*;

public class Main_bj_12852_1로만들기2 {
	static final int inf = Integer.MAX_VALUE;
	static int ans;
	static int[] dp, nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ans = inf;
		dp = new int[N+1];
		nums = new int[N+1];
		nums[1] = 1;
		for (int i = 2; i <= N; i++) {
			int res = inf, prev = i-1;
			if (nums[i-1] != 0)
				res = dp[i-1];
			if (i % 2 == 0 && nums[i/2] != 0 && res > dp[i/2]) {
				res = dp[i/2];
				prev = i/2;
			}
			if (i % 3 == 0 && nums[i/3] != 0 && res > dp[i/3]) {
				res = dp[i/3];
				prev = i/3;
			}
			dp[i] = res+1;
			nums[i] = prev;
		}
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(nums));
		sb.append(dp[N]).append("\n").append(N);
		while (N != 1) {
			N = nums[N];
			sb.append(" ").append(N);
		}
		System.out.println(sb);
		br.close();
	}
}
