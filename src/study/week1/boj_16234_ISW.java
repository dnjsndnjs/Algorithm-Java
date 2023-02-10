package study.week1;

import java.io.*;
import java.util.*;

public class boj_16234_ISW {
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	static int N, L, R;
	static int union_cnt;
	static int[][] population, union;
	static int[] union_pop, union_size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		population = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		boolean change = true;
		while (change) {
			change = false;
			union_cnt = 0;
			union = new int[N][N];
			union_pop = new int[N*N+1];
			union_size = new int[N*N+1];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (union[r][c] > 0) continue;
					bfs(r, c);
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int u = union[r][c];
					if (union_size[u] == 1) continue;
					change = true;
					population[r][c] = union_pop[u] / union_size[u];
				}
			}
			if (change) ans++;
		}
		System.out.println(ans);
		br.close();
	}
	
	static boolean inRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	static void bfs(int r, int c) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {r, c});
		union_cnt++;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			r = cur[0];
			c = cur[1];
			if (union[r][c] > 0) continue;
			union_size[union_cnt]++;
			union_pop[union_cnt] += population[r][c];
			union[r][c] = union_cnt;
			int pop = population[r][c];
			for (int i = 0; i < 4; i++) {
				r += dr[i]; c += dc[i];
				if (inRange(r, c)) {
					int diff = Math.abs(pop - population[r][c]);
					if (diff >= L && diff <= R) queue.add(new int[] {r, c});
				}
				r -= dr[i]; c -= dc[i];
			}
		}
	}
}
