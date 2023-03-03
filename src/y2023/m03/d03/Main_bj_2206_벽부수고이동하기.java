package y2023.m03.d03;

import java.io.*;
import java.util.*;

public class Main_bj_2206_벽부수고이동하기 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, 1, -1};
	
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		int[][] dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = in.charAt(j)-'0' == 0 ? true : false;
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		Deque<int[]> q = new ArrayDeque<>();
		Deque<int[]> next = new ArrayDeque<>();
		dist[0][0] = 1;
		q.offer(new int[] {0, 0, 1});
		bfs(q, map, dist, next);
		bfs(next, map, dist, null);
		int ans = dist[N-1][M-1];
		if (ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
		br.close();
	}
	
	static void bfs(Deque<int[]> q, boolean[][] map, int[][] dist, Deque<int[]> next) {
		while (!q.isEmpty()) {
			int[] ijl = q.poll();
			int i = ijl[0], j = ijl[1], l = ijl[2];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < N && 0 <= nj && nj < M)) continue;
				if (dist[ni][nj] > l+1) {
					dist[ni][nj] = l+1;
					if (map[ni][nj])
						q.offer(new int[] {ni, nj, l+1});
					else if (next != null)
						next.offer(new int[] {ni, nj, l+1});
				}
			}
		}
	}
}
