package y2023.m02.d27;

import java.io.*;
import java.util.*;

public class Main_bj_14500_테트로미노 {
	static final int[] di = {0, 1, 0, -1}, dj = {1, 0, -1, 0};
	
	static int N, M, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		boolean[][] v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(1, i, j, map, v, 0);
				func(i, j, map);
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	static void dfs(int cnt, int i, int j, int[][] map, boolean[][] v, int sum) {
		sum += map[i][j];
		if (cnt == 4) {
			if (ans < sum) ans = sum;
			return;
		}
		v[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (!(0 <= ni && ni < N && 0 <= nj && nj < M && !v[ni][nj])) continue;
			dfs(cnt+1, ni, nj, map, v, sum);
		}
		v[i][j] = false;
	}
	
	static void func(int i, int j, int[][] map) {
		int sum = map[i][j];
		int[] way = new int[4];
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (!(0 <= ni && ni < N && 0 <= nj && nj < M)) continue;
			way[d] = map[ni][nj];
			sum += way[d];
		}
		for (int d = 0; d < 4; d++) {
			int tmp = sum - way[d];
			if (ans < tmp) ans = tmp;
		}
	}
}
