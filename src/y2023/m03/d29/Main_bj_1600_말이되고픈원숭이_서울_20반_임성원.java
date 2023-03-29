package y2023.m03.d29;

import java.io.*;
import java.util.*;

public class Main_bj_1600_말이되고픈원숭이_서울_20반_임성원 {
	static final int[] di = {0, 1, 0, -1,  -2, -2, -1, 1, 2, 2, 1, -1};
	static final int[] dj = {-1, 0, 1, 0,  -1, 1, 2, 2, 1, -1, -2, -2};
	static final int INF = 2_000_000_000;
	
	static int W, H, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[H][W];
		int[][][] memo = new int[H][W][K+1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = st.nextToken().charAt(0) == '1';
				for (int k = 0; k <= K; k++)
					memo[i][j][k] = INF;
			}
		}
		System.out.println(bfs(0, 0, K, map, memo));
		br.close();
	}
	
	static int bfs(int i, int j, int k, boolean[][] map, int[][][] memo) {
		Deque<int[]> q = new ArrayDeque<>();
		memo[i][j][k] = 0;
		q.offer(new int[] {i, j, k, 0});
		while (!q.isEmpty()) {
			int[] ijkl = q.poll();
			i = ijkl[0]; j = ijkl[1]; k = ijkl[2];
			int l = ijkl[3];
			if (memo[i][j][k] < l) continue;
			if (i == H-1 && j == W-1)
				return l;
			l++;
			for (int d = 0; d < 12; d++) {
				if (d == 4)
					if (k-- == 0) break;
				int ni = i+di[d], nj = j+dj[d];
				if (!(0 <= ni && ni < H && 0 <= nj && nj < W)) continue;
				if (map[ni][nj] || memo[ni][nj][k] <= l) continue;
				memo[ni][nj][k] = l;
				q.offer(new int[] {ni, nj, k, l});
			}
		}
		return -1;
	}
}
