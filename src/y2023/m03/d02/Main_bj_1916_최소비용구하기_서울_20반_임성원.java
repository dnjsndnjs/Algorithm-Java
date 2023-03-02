package y2023.m03.d02;

import java.io.*;
import java.util.*;

public class Main_bj_1916_최소비용구하기_서울_20반_임성원 {
	static class Edge implements Comparable<Edge> {
		int j, w;
		Edge(int j, int w) {
			this.j = j; this.w = w;
		}
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		public String toString() {
			return "["+j+" "+w+"]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Edge>[] g = new List[N+1];
		int[] dist = new int[N+1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			g[a].add(new Edge(b, w));
//			g[b].add(new Edge(a, w));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[s] = 0;
		boolean[] v = new boolean[N+1];
		pq.offer(new Edge(s, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int minV = cur.j;
			int minW = cur.w;
			if (v[minV]) continue;
			v[minV] = true;
			if (minV == e) break;
			for (Edge edge : g[minV]) {
				int j = edge.j, w = edge.w;
				if (v[j]) continue;
				if (dist[j] > minW + w) {
					dist[j] = minW + w;
					pq.offer(new Edge(j, dist[j]));
				}
			}
//			System.out.println(cur);
//			System.out.println(Arrays.toString(v));
//			System.out.println(g[minV]);
//			System.out.println(Arrays.toString(dist));
		}
		System.out.println(dist[e]);
		br.close();
	}
}
