package y2023.m03.d01;

import java.io.*;
import java.util.*;

public class Main_bj_17472_다리만들기2_서울_20반_임성원 {
	static final int[] di = {1, 0, -1, 0}, dj = {0, 1, 0, -1};
	
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M ; j++)
				map[i][j] = -Integer.parseInt(st.nextToken());
		}
		// 같은 섬끼리 그룹화
		int V = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) continue;
				group(i, j, map, ++V);
			}
		}
		// 다리 만들기
		int[][] g = new int[V+1][V+1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) continue;
				bridge(i, j, map, g);
			}
		}
		
//		int ans = kruskal(g, V);
//		int ans = prim(g, V);
		int ans = primPq(g, V);
		System.out.println(ans);
		br.close();
	}
	
	static void group(int i, int j, int[][] map, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		map[i][j] = cnt;
		q.offer(new int[] {i, j});
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0]; j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < N && 0 <= nj && nj < M)) continue;
				if (map[ni][nj] != -1) continue;
				map[ni][nj] = cnt;
				q.offer(new int[] {ni, nj});
			}
		}
	}
	
	static void bridge(int i, int j, int[][] map, int[][] g) {
		int from = map[i][j];
		for (int d = 0; d < 2; d++) {
			int ni = i + di[d], nj = j + dj[d], len = 0;
			for(; ni < N && nj < M && map[ni][nj] == 0; ni+=di[d], nj+=dj[d], len++);
			if (ni == N || nj == M || len < 2) continue;
			int to = map[ni][nj];
			if (g[from][to] != 0 && g[from][to] <= len) continue;
			g[from][to] = g[to][from] = len;
		}
	}
	
	static int kruskal(int[][] g, int V) {
		int res = 0, cnt = 0;
		List<int[]> edges = new ArrayList<>();
		for (int i = 1; i <= V; i++) {
			for (int j = i+1; j <= V; j++) {
				if (g[i][j] == 0) continue;
				edges.add(new int[] {i, j, g[i][j]});
			}
		}
		Collections.sort(edges, (x, y) -> Integer.compare(x[2], y[2]));
		
		int[] p = new int[V+1];
		for (int i = 1; i <= V; i++) p[i] = i;
		for (int[] e : edges) {
			if (union(p, e[0], e[1])) {
				res += e[2];
				if (++cnt == V-1) break;
			}
		}
		if (cnt != V-1) return -1;
		return res;
	}
	static int find(int[] p, int a) {
		if (p[a] == a) return a;
		return p[a] = find(p, p[a]);
	}
	static boolean union(int[] p, int a, int b) {
		int ar = find(p, a);
		int br = find(p, b);
		if (ar == br) return false;
		p[br] = ar;
		return true;
	}
	
	static int prim(int[][] g, int V) {
		int res = 0, cnt = 0;
		boolean[] v = new boolean[V+1];
		int[] minE = new int[V+1];
		for (int i = 1; i <= V; i++) minE[i] = Integer.MAX_VALUE;
		
		minE[1] = 0;
		for (int i = 1; i <= V; i++) {
			int minV = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= V; j++) {
				if (v[j]) continue;
				if (min > minE[j]) {
					min = minE[j];
					minV = j;
				}
			}
			if (minV == -1) return -1;
			v[minV] = true;
			res += min;
			if (cnt++ == V-1) break;
			for (int j = 1; j<= V; j++) {
				if (v[j] || g[minV][j] == 0) continue;
				if (minE[j] > g[minV][j])
					minE[j] = g[minV][j];
			}
		}
		if (cnt != V) return -1;
		return res;
	}
	
	static int primPq(int[][] g, int V) {
		int res = 0, cnt = 0;
		boolean[] v = new boolean[V+1];
		int[] minE = new int[V+1];
		for (int i = 1; i <= V; i++) minE[i] = Integer.MAX_VALUE;
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
		
		minE[1] = 0;
		pq.offer(new int[] {1, 0}); // 정점, 거리
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int minV = cur[0];
			int min = cur[1];
			if (min == Integer.MAX_VALUE) return -1;
			if (v[minV]) continue;
			v[minV] = true;
			res += min;
			if (cnt++ == V-1) break;
			for (int j = 1; j<= V; j++) {
				if (v[j] || g[minV][j] == 0) continue;
				if (minE[j] > g[minV][j]) {
					minE[j] = g[minV][j];
					pq.offer(new int[] {j, minE[j]});
				}
			}
		}
		if (cnt != V) return -1;
		return res;
	}
}
