package y2023.m04.d05;

import java.io.*;
import java.util.*;

public class Main_bj_3055_탈출 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int Di = 0, Dj = 0;
		int[][] map = new int[N][M];
		Deque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				switch (in.charAt(j)) {
				case 'D': Di = i; Dj = j; break;
				case 'S': map[i][j] = 1; q.offerFirst(new int[] {i, j, 1}); break;
				case '*': map[i][j] = 2; q.offer(new int[] {i, j, 2}); break;
				case 'X': map[i][j] = 3; break;
				}
			}
		}
		int ans = 0;
		for (ans = 1; !q.isEmpty(); ans++) {
			int size = q.size();
			while (size-->0) {
				int[] ijt = q.poll();
				int i = ijt[0], j = ijt[1], t = ijt[2];
				if (map[i][j] > t) continue;
				for (int d = 0; d < 4; d++) {
					int ni = i+di[d], nj = j+dj[d];
					if (!(0 <= ni && ni < N && 0 <= nj && nj <M)) continue;
					if (map[ni][nj] >= t) continue;
					if (t == 2 && ni == Di && nj == Dj) continue;
					map[ni][nj] = t;
					q.offer(new int[] {ni, nj, t});
				}
			}
			if (map[Di][Dj] != 0) break;
		}
		System.out.println(q.isEmpty() ? "KAKTUS" : ans);
		br.close();
	}
}
