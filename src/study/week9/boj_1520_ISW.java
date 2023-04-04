package study.week9;

import java.io.*;
import java.util.*;

public class boj_1520_ISW {
	static final int[] di = {0, 0, 1, -1}, dj = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[M][N];
		boolean[][] v = new boolean[M][N];
		System.out.println(dfs(0, 0, M, N, map, dp, v));
		br.close();
	}
	
	static int dfs(int i, int j, int M, int N, int[][] map, int[][] dp, boolean[][] v) {
		if (i == M-1 && j == N-1) return 1;
		if (v[i][j]) return dp[i][j];
		v[i][j] = true;
		int res = 0;
		for (int d = 0; d < 4; d++) {
			int ni = i+di[d], nj = j+dj[d];
			if (!(0 <= ni && ni < M && 0 <= nj && nj < N)) continue;
			if (map[ni][nj] < map[i][j])
				res += dfs(ni, nj, M, N, map, dp, v);
		}
		return dp[i][j] = res;
	}
}
