package y2023.m02.d15;

import java.io.*;
import java.util.*;

public class Solution_d4_1861_정사각형방 {
	static final int[] di = {-1, 1, 0, 0};
	static final int[] dj = {0, 0, -1, 1};
	
	static int N, minr, maxc, cnt;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			minr = N*N+1; maxc = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 0;
					dfs(i, j);
					if (maxc < cnt) {
						maxc = cnt;
						minr = map[i][j];
					} else if (maxc == cnt && minr > map[i][j])
						minr = map[i][j];
				}
			}
			sb.append("#"+tc+" "+minr+" "+maxc+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	static void dfs(int i, int j) {
		cnt++;
		int r = map[i][j];
		for (int d = 0; d < 4; d++) {
			int ni = i+di[d], nj = j+dj[d];
			if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
			if (map[ni][nj] != r+1) continue;
			dfs(ni, nj);
		}
	}
	
	static void bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();
		int r = map[i][j];
		q.offer(new int[] {i, j, r});
		while (!q.isEmpty()) {
			cnt++;
			int[] ijr = q.poll();
			i = ijr[0]; j = ijr[1]; r = ijr[2];
			for (int d = 0; d < 4; d++) {
				int ni = i+di[d], nj = j+dj[d];
				if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
				if (map[ni][nj] != r+1) continue;
				q.offer(new int[] {ni, nj, r+1});
			}
		}
	}
}
