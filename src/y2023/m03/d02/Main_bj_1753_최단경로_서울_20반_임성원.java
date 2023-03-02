package y2023.m03.d02;

import java.io.*;
import java.util.*;

public class Main_bj_1753_최단경로_서울_20반_임성원 {
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine())-1;
		List<int[]>[] g = new List[V];
		int[] dist = new int[V];
		for (int i = 0; i < V; i++) {
			g[i] = new ArrayList<>();
			dist[i] = INF;
		}
		boolean[] visit = new boolean[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			g[a].add(new int[] {b, w});
		}
		int cnt = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
		dist[K] = 0;
		pq.offer(new int[] {K, 0});
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int minV = cur[0];
			int minW = cur[1];
			if (visit[minV]) continue;
			visit[minV] = true;
			if (++cnt == V) break;
			for (int[] e : g[minV]) {
				int j = e[0];
				int w = e[1];
				if (visit[j]) continue;
				if (dist[j] > minW+w) {
					dist[j] = minW+w;
					pq.offer(new int[] {j, dist[j]});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < V; i++)
			sb.append(dist[i] != INF ? dist[i] : "INF").append("\n");
		System.out.print(sb);
		br.close();
	}
}
