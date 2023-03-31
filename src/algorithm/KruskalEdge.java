package algorithm;

import java.io.*;
import java.util.*;

public class KruskalEdge {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int N;
	static Edge[] edges;
	static int[] p;
	
	static void make() {
		p = new int[N];
		for (int i = 0; i < N; i++) p[i] = i;
	}
	
	static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		if (ar == br) return false;
		p[br] = p[ar];
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			edges[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edges);
		make();
		int res = 0, cnt = 0;
		for (Edge edge : edges) {
			if (union(edge.from, edge.to)) {
				res += edge.weight;
				if (++cnt == N-1) break;
			}
		}
		System.out.println(res);
		sc.close();
	}
}
