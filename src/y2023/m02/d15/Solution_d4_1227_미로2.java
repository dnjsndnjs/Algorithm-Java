package y2023.m02.d15;

import java.io.*;
import java.util.*;

public class Solution_d4_1227_미로2 {
	static final int[] di = {-1, 1, 0, 0};
	static final int[] dj = {0, 0, -1, 1};
	static final int N = 100;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1227.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		tc:for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int[][] map = new int[N][N];
			int si = 0, sj = 0, gi = 0, gj = 0;
			for (int i = 0; i < N; i++) {
				String in = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = in.charAt(j)-'0';
					if (map[i][j] == 2) {
						si = i; sj = j;
						map[i][j] = 0;
					}
					if (map[i][j] == 3) {
						gi = i; gj = j;
						map[i][j] = 0;
					}
				}
			}
			// bfs
			sb.append("#").append(tc).append(" ");
			boolean[][] v = new boolean[N][N];
			Deque<int[]> q = new ArrayDeque<>();
			v[si][sj] = true;
			q.offer(new int[] {si, sj});
			while (!q.isEmpty()) {
				int[] ij = q.poll();
				int i = ij[0], j = ij[1];
				for (int d = 0; d < 4; d++) {
					int ni = i+di[d], nj = j+dj[d];
					if (ni == gi && nj == gj) {
						sb.append(1).append("\n");
						continue tc;
					}
					if (!(0 <= ni && ni < N && 0 <= nj && nj <=N)) continue;
					if (v[ni][nj] || map[ni][nj] != 0) continue;
					v[ni][nj] = true;
					q.offer(new int[] {ni, nj});
				}
			}
			sb.append(0).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
