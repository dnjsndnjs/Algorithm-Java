package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class MSTTest1 {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static void makeSet() {
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean unionSet(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br)
			return false;
		parents[br] = ar;
		return true;
	}

	static int V, E;
	static Edge[] edgelist;
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		edgelist = new Edge[E];
		for (int i = 0; i < E; i++) {
			edgelist[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(edgelist);
		makeSet();
		int res = 0, cnt = 0;
		for (Edge edge : edgelist) {
			if (unionSet(edge.from, edge.to)) {
				res += edge.weight;
				if (++cnt == V - 1)
					break;
			}
		}
		System.out.println(res);
		sc.close();
	}
}
