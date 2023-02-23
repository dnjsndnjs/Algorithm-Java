package y2023.m02.d23;

import java.io.*;
import java.util.*;

public class Main_bj_1260_DFS와BFS_서울_20반_임성원 {
	static int N;
	static boolean[][] g;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		int V  = Integer.parseInt(st.nextToken());
		g = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a][b] = g[b][a] = true;
		}
		dfs(V, g, new boolean[N+1]);
		sb.append("\n");
		bfs(V, g, new boolean[N+1]);
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int i, boolean[][] g, boolean[] v) {
		v[i] = true;
		sb.append(i).append(" ");
		for (int j = 1; j <= N; j++) {
			if (g[i][j] && !v[j]) dfs(j, g, v);
		}
	}
	
	static void bfs(int i, boolean[][] g, boolean[] v) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			sb.append(i).append(" ");
			for (int j = 1; j <= N; j++) {
				if (g[i][j] && !v[j]) {
					v[j] = true;
					q.offer(j);
				}
			}
		}
	}
}
