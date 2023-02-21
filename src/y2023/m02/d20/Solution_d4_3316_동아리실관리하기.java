package y2023.m02.d20;

import java.io.*;
import java.util.*;

public class Solution_d4_3316_동아리실관리하기 {
	static final int big = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3316.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			String in = br.readLine();
			int N = in.length();
			int[][] dp = new int[N][16];
			
			sb.append("#"+tc+" "+func(N, in, dp)+"\n");
			for (int[] d:dp)System.out.println(Arrays.toString(d));
		}
		System.out.print(sb);
		br.close();
	}
	
	static int func(int N, String in, int[][] dp) {
		for (int day = 0; day < N; day++) {
			int admin = 1 << (in.charAt(day)-'A');
			for (int i = 1; i < 16; i++) {
				if (day == 0) {
					if ((i & admin) != 0 && (i & 1) != 0) {
						dp[day][i] = 1;
					}
					continue;
				}
				if (dp[day-1][i] == 0) continue;
				for (int j = 1; j < 16; j++) {
					if ((j & admin) != 0 && (i & j) != 0) {
						dp[day][j] += dp[day-1][i];
						dp[day][j] %= big;
					}
				}
			}
		}
		int res = 0;
		for (int i = 1; i < 16; i++) {
			res += dp[N-1][i];
			res %= big;
		}
		return res;
	}
}
