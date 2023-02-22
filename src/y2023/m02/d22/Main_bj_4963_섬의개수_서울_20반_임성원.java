package y2023.m02.d22;

import java.io.*;
import java.util.*;

public class Main_bj_4963_섬의개수_서울_20반_임성원 {
	static final int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
	static final int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static int w, h;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String in = br.readLine();
		while (!in.equals("0 0")) {
			StringTokenizer st = new StringTokenizer(in," ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int[][] map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			boolean[][] v = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (v[i][j] || map[i][j] == 0) continue;
					dfs(i, j, map, v);
//					bfs(i, j, map, v);
					ans++;
				}
			}
			sb.append(ans).append("\n");
			in = br.readLine();
		}
		System.out.print(sb);
		br.close();
	}
	
	static void dfs(int i, int j, int[][] map, boolean[][] v) {
		v[i][j] = true;
		for (int d = 0; d < 8; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (!(0 <= ni && ni < h && 0 <= nj && nj < w)) continue;
			if (v[ni][nj] || map[ni][nj] == 0) continue;
			dfs(ni, nj, map, v);
		}
	}
	
	static void bfs(int i, int j, int[][] map, boolean[][] v) {
		Deque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] {i, j});
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0]; j = ij[1];
			for (int d = 0; d < 8; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < h && 0 <= nj && nj < w)) continue;
				if (v[ni][nj] || map[ni][nj] == 0) continue;
				v[ni][nj] = true;
				q.offer(new int[] {ni, nj});
			}
		}
	}
}
