package y2023.m03.d29;

import java.io.*;
import java.util.*;

public class Main_bj_1010_다리놓기_서울_20반_임성원 {
	static int[][] dp = new int[31][31];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(comb(M, N)).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static int comb(int n, int r) {
		if (r == n || r == 0) return 1;
		if (dp[n][r] != 0) return dp[n][r];
		return dp[n][r] = dp[n][n-r] =  comb(n-1, r) + comb(n-1, r-1);
	}
}
