package y2023.m04.d05;

import java.io.*;
import java.util.*;

public class Solution_d5_7793_오나의여신님_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_d5_7793.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
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
			String result = q.isEmpty() ? "GAME OVER\n" : ans+"\n";
			sb.append("#"+tc+" "+result);
		}
		System.out.print(sb);
		br.close();
	}
}
