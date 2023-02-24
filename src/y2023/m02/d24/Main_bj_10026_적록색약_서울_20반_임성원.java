package y2023.m02.d24;

import java.io.*;
import java.util.*;

public class Main_bj_10026_적록색약_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = in.charAt(j);
		}
		// a: 적록색약이 아님, b: 적록색약
		int a = 0, b = 0;
		boolean[][] va = new boolean[N][N], vb = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!va[i][j]) {
					dfs(i, j, map, va, false);
//					bfs(i, j, map, va, false);
					a++;
				}
				if (!vb[i][j]) {
//					dfs(i, j, map, vb, true);
					bfs(i, j, map, vb, true);
					b++;
				}
			}
		}
		System.out.println(a+" "+b);
		br.close();
	}
	
	static void dfs(int i, int j, char[][] map, boolean[][] v, boolean colorblind) {
		char color = map[i][j];
		v[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if(!(0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj])) continue;
			if (!colorblind && map[ni][nj] != color) continue;
			if (colorblind &&
					((color == 'B' && map[ni][nj] != 'B') ||
							(color != 'B' && map[ni][nj] == 'B'))) continue;
			dfs(ni, nj, map, v, colorblind);
		}
	}
	
	static void bfs(int i, int j, char[][] map, boolean[][] v, boolean colorblind) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		char color = map[i][j];
		v[i][j] = true;
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0]; j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if(!(0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj])) continue;
				if (!colorblind && map[ni][nj] != color) continue;
				if (colorblind &&
						((color == 'B' && map[ni][nj] != 'B') ||
								(color != 'B' && map[ni][nj] == 'B'))) continue;
				v[ni][nj] = true;
				q.offer(new int[] {ni, nj});
			}
		}
	}
}
