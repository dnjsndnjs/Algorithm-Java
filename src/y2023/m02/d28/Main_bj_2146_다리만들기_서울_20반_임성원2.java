package y2023.m02.d28;

import java.io.*;
import java.util.*;

public class Main_bj_2146_다리만들기_서울_20반_임성원2 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
	
	static int N, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		List<List<int[]>> list = new ArrayList<>();
		boolean[][] v = new boolean[N][N];
		boolean[][] sea = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j] || map[i][j] == 0) continue;
				list.add(bfs(i, j, map, v, sea));
			}
		}
		ans = Integer.MAX_VALUE;
		comb(0, 0, list.size(), 2, new int[2], list);
		System.out.println(ans);
		br.close();
	}
	
	static void comb(int cnt, int start, int N, int R, int[] C, List<List<int[]>> list) {
		if (cnt == R) {
			for (int[] a : list.get(C[0])) {
				for (int[] b : list.get(C[1])) {
					int len = Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]) - 1;
					if (ans > len) ans = len;
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			C[cnt] = i;
			comb(cnt+1, i+1, N, R, C, list);
		}
	}
	
	static List<int[]> bfs(int i, int j, int[][] map, boolean[][] v, boolean[][] sea) {
		List<int[]> res = new ArrayList<>();
		Deque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] {i, j});
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0]; j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj])) continue;
				if (map[ni][nj] == 0) {
					if (sea[i][j]) continue;
					sea[i][j] = true;
					res.add(ij);
					continue;
				}
				v[ni][nj] = true;
				q.offer(new int[] {ni, nj});
			}
		}
		return res;
	}
}
