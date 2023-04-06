package y2023.m04.d06;

import java.io.*;
import java.util.*;

public class Main_bj_23840_두단계최단경로4 {
	static final long INF = Long.MAX_VALUE/2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<List<int[]>> g = new ArrayList<>(N);
		for (int i = 0; i < N; i++) g.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			g.get(u).add(new int[] {v, w});
			g.get(v).add(new int[] {u, w});
		}

		st = new StringTokenizer(br.readLine(), " ");
		int P = Integer.parseInt(br.readLine());
		int[] yarr = new int[P+2];
		yarr[P] = Integer.parseInt(st.nextToken())-1; // x
		yarr[P+1] = Integer.parseInt(st.nextToken())-1; // z
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < P; i++) yarr[i] = Integer.parseInt(st.nextToken())-1;
		long[][] gy = new long[P+2][P+2];
		long[][] dp = new long[P+1][1<<P];
		for (int i = 0; i < P+2; i++) {
			//
		}
		long ans = tsp(P, 0, P, gy, dp);
		if (ans == INF) ans = -1;
		System.out.println(ans);
		br.close();
	}

	static void dijkstra(int s, int N, List<List<int[]>> g, int P, int[] yarr, long[][] gy) {
		long[] dist = new long[N];
		for (int i = 0; i < N; i++) dist[i] = INF;
		boolean[] v = new boolean[N];
		PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[1], o2[1]);
			}
		});
		dist[s] = 0;
		pq.offer(new long[] {s, 0});
		int cnt = 0;
		while (!pq.isEmpty()) {
			long[] jw = pq.poll();
			int minV = (int) jw[0];
			long min = jw[1];
			if (v[minV]) continue;
			v[minV] = true;
			// for (int j = 0; j < N; j++) {
			// 	if (v[j]) continue;
			// 	if (dist[j] > min+dist[minV]) {
			// 		dist[j] = min+dist[minV];
			// 		pq.offer(new long[] {j, dist[j]});
			// 	}
			// }
		}
	}

	static long tsp(int i, int v, int P, long[][] g, long[][] dp) {
		if (dp[i][v] != 0) return dp[i][v];
		long res = INF;
		for (int j = 0, b = 1; j < P; j++, b<<=1) {
			if ((v&b) != 0) continue;
			if (i == j) continue;
			if (g[i][j] == 0) continue;
			res = Math.min(res, tsp(j, v|b, P, g, dp)+g[i][j]);
		}
		return dp[i][v] = res;
	}
}
