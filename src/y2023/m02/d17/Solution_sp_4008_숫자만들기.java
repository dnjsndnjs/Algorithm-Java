package y2023.m02.d17;

import java.io.*;
import java.util.*;

public class Solution_sp_4008_숫자만들기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_sp_4008.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] ops = new int[4];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				ops[i] = Integer.parseInt(st.nextToken());
			}
			int[] nums = new int[N-1];
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N-1; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			// ans [0]: max, ans[1]: min
			int[] ans = {Integer.MIN_VALUE, Integer.MAX_VALUE};
			perm(0, start, ops, nums, N, ans);
			sb.append("#").append(tc).append(" ").append(ans[0]-ans[1]).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	// 화려한 파라미터;;
	static void perm(int cnt, int sum, int[] ops, int[] nums, int N, int[] ans) {
		if (cnt == N-1) {
			if (ans[0] < sum)
				ans[0] = sum;
			if (ans[1] > sum)
				ans[1] = sum;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (ops[i] == 0) continue;
			ops[i]--;
			int tmp = sum;
			switch (i) {
			case 0: tmp += nums[cnt]; break; // +
			case 1: tmp -= nums[cnt]; break; // -
			case 2: tmp *= nums[cnt]; break; // *
			case 3: tmp /= nums[cnt]; break; // /
			}
			perm(cnt+1, tmp, ops, nums, N, ans);
			ops[i]++;
		}
	}
}
