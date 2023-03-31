package algorithm;

import java.io.*;
import java.util.*;

public class GraphMatrix {
	static int N;
	static int[][] g;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		g = new int[N][N]; //
		v = new boolean[N];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int toto = sc.nextInt();
			g[from][toto] = g[toto][from] = 1; //
		}
		for(int[] a:g)System.out.println(Arrays.toString(a));System.out.println();
		
		bfs(0);
//		dfs(0);
		sc.close();
	}

	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while (!q.isEmpty()) { //
			i = q.poll();
			System.out.print((char)(i+'A')+" ");
			for (int j = 0; j < N; j++) { //
				if (g[i][j] != 0 && !v[j]) {
					v[j] = true;
					q.offer(j);
				}
			}
		}
	}

	static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A')+" ");
		for (int j = 0; j < N; j++) { //
			if (g[i][j] != 0 && !v[j])
				dfs(j);
		}
	}
}
/*
7
8
0 1
0 2
1 3
1 4
3 5
4 5
5 6
2 6

    A0
   / \
  B1 C2
 / \ /\
D3  E4 \
 \ /    \
  F5 -- G6
*/