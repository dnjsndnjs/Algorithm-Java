package y2023.m02.d23;

import java.io.*;
import java.util.*;

public class Main_bj_17135_캐슬디펜스_서울_20반_임성원 {
	static final int[] di = {0, -1, 0}, dj = {-1, 0, 1};
	
	static int N, M, D, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		comb(0, 0, new int[3], map);
		System.out.println(ans);
		br.close();
	}
	
	static void comb(int cnt, int start, int[] apos, int[][] map) {
		if (cnt == 3) {
			int res = 0;
			int[][] tmap = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++)
					tmap[i][j] = map[i][j];
			}
			for (int T = 0; T < N; T++) {
				int[][] kill = new int[3][2];
				for (int i = 0; i < 3; i++) {
					bfs(N-1, apos[i], tmap, kill[i]);
				}
				for (int i = 0; i < 3; i++) {
					int r = kill[i][0], c = kill[i][1];
					if (r < 0) continue;
					if (tmap[r][c] != 0) res++;
					tmap[r][c] = 0;
				}
				for (int i = N-1; i > 0; i--)
					tmap[i] = tmap[i-1];
				tmap[0] = new int[M];
			}
			if (ans < res) ans = res;
			return;
		}
		for (int i = start; i < M; i++) {
			apos[cnt] = i;
			comb(cnt+1, i+1, apos, map);
		}
	}
	
	static void bfs(int i ,int j, int[][] map, int[] kill) {
		boolean[][] v = new boolean[N][M];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] {i, j, 1});
		while (!q.isEmpty()) {
			int[] ijd = q.poll();
			i = ijd[0]; j = ijd[1];
			int dist = ijd[2];
			if (dist > D) {
				kill[0] = -1;
				return;
			}
			if (map[i][j] != 0) {
				kill[0] = i;
				kill[1] = j;
				return;
			}
			for (int d = 0; d < 3; d++) {
				int ni = i + di[d], nj = j + dj[d], nd = dist+1;
				if (!(0 <= ni && ni < N && 0 <= nj && nj < M && !v[ni][nj])) continue;
				v[ni][nj] = true;
				q.offer(new int[] {ni, nj, nd});
			}
		}
	}
}
