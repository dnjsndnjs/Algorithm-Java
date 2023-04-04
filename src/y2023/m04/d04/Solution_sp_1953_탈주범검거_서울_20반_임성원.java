package y2023.m04.d04;

import java.io.*;
import java.util.*;

public class Solution_sp_1953_탈주범검거_서울_20반_임성원 {
	static final int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static final int[] tunnel = {0, 15, 5, 10, 3, 6, 12, 9};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_sp_1953.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			boolean[][] v = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++)
					map[i][j] = tunnel[Integer.parseInt(st.nextToken())];
			}
			
			Deque<int[]> q = new ArrayDeque<>();
			int ans = 1;
			v[R][C] = true;
			q.offer(new int[] {R, C});
			for (int i = 1; i < L; i++) {
				for (int size = q.size(); size > 0; size--) {
					int[] rc = q.poll();
					int r = rc[0], c = rc[1];
					for (int d = 0; d < 4; d++) {
						if ((map[r][c]&(1<<d)) == 0) continue;
						int nr = r+dr[d], nc = c+dc[d];
						if (!(0 <= nr && nr < N && 0 <= nc && nc < M) || v[nr][nc]) continue;
						int nd = (d+2)%4;
						if ((map[nr][nc]&(1<<nd)) == 0) continue;
						ans++;
						v[nr][nc] = true;
						q.offer(new int[] {nr, nc});
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
