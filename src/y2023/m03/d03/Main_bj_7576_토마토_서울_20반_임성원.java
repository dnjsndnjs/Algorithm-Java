package y2023.m03.d03;

import java.io.*;
import java.util.*;

public class Main_bj_7576_토마토_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, 1, -1};
	
	static int M, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int total = 0;
		Deque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) q.offer(new int[] {i, j, 0});
				if (map[i][j] != -1) total++;
			}
		}
		int ans = 0, cnt = 0;
		while (!q.isEmpty()) {
			int[] ijt = q.poll();
			int i = ijt[0], j = ijt[1], t = ijt[2];
			cnt++;
			if (ans < t) ans = t;
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 0)) continue;
				map[ni][nj] = 1;
				q.offer(new int[] {ni, nj, t+1});
			}
		}
		if (cnt != total) ans = -1;
		System.out.println(ans);
		br.close();
	}
}
