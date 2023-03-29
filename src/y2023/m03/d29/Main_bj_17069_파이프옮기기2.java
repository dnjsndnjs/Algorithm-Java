package y2023.m03.d29;

import java.io.*;
import java.util.*;

public class Main_bj_17069_파이프옮기기2 {
	static final int[] di = {0, 1, 1}, dj = {1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[N][N];
		long[][][] dp = new long[N+1][N+1][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = st.nextToken().equals("1");
		}
		long ans = func(0, 1, 0, N, map, dp);
		if (ans == -1) ans = 0;
		System.out.println(ans);
		br.close();
	}
	
	static long func(int i, int j, int d, int N, boolean[][] map, long[][][] dp) {
		if (dp[i][j][d] != 0) {
			if (dp[i][j][d] == -1) return 0;
			return dp[i][j][d];
		}
		if (i == N-1 && j == N-1)
			return dp[i][j][d] = 1;
		long res = 0;
		for (int dd = -1; dd <= 1; dd++) {
			int nd = d+dd;
			if (!(0 <= nd && nd < 3)) continue;
			int ni = i + di[nd], nj = j + dj[nd];
			if (ni == N || nj == N) continue;
			if (nd == 1)
				if (map[i][nj] || map[ni][j]) continue;
			if (map[ni][nj]) continue;
			res += func(ni, nj, nd, N, map, dp);
		}
		dp[i][j][d] = res;
		if (res == 0)
			dp[i][j][d] = -1;
		return res;
	}
}
