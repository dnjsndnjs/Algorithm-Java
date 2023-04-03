package algorithm;

import java.util.*;

public class GraphListNode {
	static int N;
	static Node[] g;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		g = new Node[N];
		v = new boolean[N];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int toto = sc.nextInt();
			g[from] = new Node(toto, g[from]);
			g[toto] = new Node(from, g[toto]);
		}
		for (Node a : g)
			System.out.println(a);
		System.out.println();

		// bfs(0);
		dfs(0);
		sc.close();
	}

	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while (!q.isEmpty()) {
			i = q.poll();
			System.out.print((char) (i + 'A') + " ");
			for (Node j = g[i]; j != null; j = j.link) {
				if (!v[j.vertex]) {
					v[j.vertex] = true;
					q.offer(j.vertex);
				}
			}
		}
	}

	static void dfs(int i) {
		v[i] = true;
		System.out.print((char) (i + 'A') + " ");
		for (Node j = g[i]; j != null; j = j.link) {
			if (!v[j.vertex])
				dfs(j.vertex);
		}
	}

	static class Node {
		int vertex;
		Node link;

		Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return (char) (vertex + 'A') + "(" + vertex + ")->" + link;
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
 * 
 * =dfs========
 * A B D F E C G
 */