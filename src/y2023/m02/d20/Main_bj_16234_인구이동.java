package y2023.m02.d20;

import java.io.*;
import java.util.*;

public class Main_bj_16234_인구이동 {
	static final int[] di = {-1, 1, 0, 0};
	static final int[] dj = {0, 0, -1, 1};
	
	static int N, L, R, cnt;
	static int[][] pop, map, union;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		pop = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				pop[i][j] = Integer.parseInt(st.nextToken());
		}
		boolean change = true;
		union = new int[N*N+1][2];
		int ans;
		for (ans = -1; change; ans++) {
			change = false;
			cnt = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) continue;
					bfs(i, j);
				}
			}
			for (int i = 1; i <= cnt; i++) {
				if (union[i][0] == 1) continue;
				union[i][1] /= union[i][0];
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (union[map[i][j]][0] == 1) continue;
					pop[i][j] = union[map[i][j]][1];
					change = true;
				}
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	static void bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();
		map[i][j] = ++cnt;
		union[cnt][0] = 1;
		union[cnt][1] = pop[i][j];
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0]; j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] == 0)) continue;
				int diff = Math.abs(pop[i][j] - pop[ni][nj]);
				if (!(L <= diff && diff <= R)) continue;
				map[ni][nj] = cnt;
				union[cnt][0]++;
				union[cnt][1] += pop[ni][nj];
				q.offer(new int[] {ni, nj});
			}
		}
	}
}
