package algorithm;

import java.io.*;
import java.util.*;

public class KruskalMain {
	static int N;
	static int[][] edges;
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
		edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			edges[i] = new int[] {from, to, weight};
		}
		Arrays.sort(edges, (x, y) -> Integer.compare(x[2], y[2]));
		make();
		int res = 0, cnt = 0;
		for (int[] edge : edges) {
			if (union(edge[0], edge[1])) {
				res += edge[2];
				if (++cnt == N-1) break;
			}
		}
		System.out.println(res);
		sc.close();
	}
}
