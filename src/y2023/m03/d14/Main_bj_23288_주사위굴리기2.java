package y2023.m03.d14;

import java.io.*;
import java.util.*;

public class Main_bj_23288_주사위굴리기2 {
	static final int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int x = 0;
		int y = 0;
		int[][] dice = {
				{2, 5},
				{4, 3},
				{6, 1},
		};
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		int[] score = new int[N*M+1];
		int[][] smap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (smap[i][j] != 0) continue;
				score[cnt] = dfs(i, j, cnt, map, smap) * map[i][j];
				cnt++;
			}
		}
		int ans = 0, d = 0;
		for (int k = 0; k < K; k++) {
			int nx = x + dx[d], ny = y + dy[d];
			if (!(0 <= nx && nx < N && 0 <= ny && ny < M)) {
				d += 2;
				if (d >= 4) d -= 4;
				nx = x+dx[d]; ny = y+dy[d];
			};
			x = nx; y = ny;
			rotate(dice, d);
			int A = dice[2][0];
			int B = map[x][y];
			if (A > B) {
				if (++d == 4) d = 0;
			} else if (A < B) {
				if (--d < 0) d += 4;
			}
			ans += score[smap[x][y]];
		}
		System.out.println(ans);
		br.close();
	}
	
	static int dfs(int x, int y, int num, int[][] map, int[][] smap) {
		int res = 1;
		smap[x][y] = num;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d], ny = y + dy[d];
			if (!(0 <= nx && nx < N && 0 <= ny && ny < M)) continue;
			if (smap[nx][ny] != 0 || map[nx][ny] != map[x][y]) continue;
			res += dfs(nx, ny, num, map, smap);
		}
		return res;
	}
	
	static void swap(int[][] dice, int a1, int a2, int b1, int b2) {
		dice[a1][a2] ^= dice[b1][b2];
		dice[b1][b2] ^= dice[a1][a2];
		dice[a1][a2] ^= dice[b1][b2];
	}
	
	static void rotate(int[][] dice, int d) {
		switch(d) {
		case 0:
			// 동
			swap(dice, 1, 1, 2, 0);
			swap(dice, 1, 1, 2, 1);
			swap(dice, 1, 0, 2, 1);
			break;
		case 1:
			// 남
			swap(dice, 0, 1, 2, 1);
			swap(dice, 0, 0, 2, 1);
			swap(dice, 0, 0, 2, 0);
			break;
		case 2:
			// 서
			swap(dice, 1, 0, 2, 1);
			swap(dice, 1, 1, 2, 1);
			swap(dice, 1, 1, 2, 0);
			break;
		case 3:
			// 북
			swap(dice, 0, 0, 2, 0);
			swap(dice, 0, 0, 2, 1);
			swap(dice, 0, 1, 2, 1);
			break;
		}
	}
}
