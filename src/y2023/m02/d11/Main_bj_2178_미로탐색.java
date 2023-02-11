package y2023.m02.d11;

import java.io.*;
import java.util.*;

public class Main_bj_2178_미로탐색 {
	static final int[] di = {-1, 0, 1, 0};
	static final int[] dj = {0, 1, 0, -1};
	
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = in.charAt(j) - '0';
			}
		}
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);
		br.close();
	}
	
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		v[i][j] = true;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			i = temp[0]; j = temp[1];
			int dist = map[i][j];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
				if (v[ni][nj] || map[ni][nj] == 0) continue;
				v[ni][nj] = true;
				map[ni][nj] = dist + 1;
				q.offer(new int[] {ni, nj});
			}
		}
	}
}
