package y2023.m02.d12;

import java.io.*;
import java.util.*;

public class Main_bj_2468_안전영역 {
	static final int[] di = {-1, 1, 0, 0};
	static final int[] dj = {0, 0, -1, 1};
	
	static int N;
	static int[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int min = Integer.MAX_VALUE, max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (min > map[i][j])
					min = map[i][j];
				if (max < map[i][j])
					max = map[i][j];
			}
		}
		int ans = 1;
		for (int rain = min; rain <= max; rain++) {
			v = new boolean[N][N];
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (v[i][j]) continue;
					if (map[i][j] <= rain) continue;
					bfs(i, j, rain);
					res++;
				}
			}
			if (ans < res)
				ans = res;
		}
		System.out.println(ans);
		br.close();
	}
	
	static void bfs(int i, int j, int rain) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		v[i][j] = true;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			i = temp[0]; j = temp[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
				if (map[ni][nj] <= rain) continue;
				if (v[ni][nj]) continue;
				v[ni][nj] = true;
				q.offer(new int[] {ni, nj});
			}
		}
	}
}
