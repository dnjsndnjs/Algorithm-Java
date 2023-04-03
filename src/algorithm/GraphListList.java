package algorithm;

import java.util.*;

public class GraphListList {
	static int N;
	static List<Integer>[] g;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		g = new List[N];
		for (int i = 0; i < N; i++)
			g[i] = new ArrayList<>();
		v = new boolean[N];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int toto = sc.nextInt();
			g[from].add(toto);
			g[toto].add(from);
		}
		for (List<Integer> a : g)
			System.out.println(a);
		System.out.println();

		bfs(0);
		// dfs(0);
		sc.close();
	}

	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while (!q.isEmpty()) {
			i = q.poll();
			System.out.print((char) (i + 'A') + " ");
			for (int j : g[i]) {
				if (!v[j]) {
					v[j] = true;
					q.offer(j);
				}
			}
		}
	}

	static void dfs(int i) {
		v[i] = true;
		System.out.print((char) (i + 'A') + " ");
		for (int j : g[i]) {
			if (!v[j])
				dfs(j);
		}
	}
}
/*
 * 7
 * 8
 * 0 1
 * 0 2
 * 1 3
 * 1 4
 * 2 4
 * 3 5
 * 4 5
 * 5 6
 * 
 * A0
 * / \
 * B1 C2
 * / \ /
 * D3 E4
 * \ /
 * F5 - G6
 */