package y2023.m04.d05;

import java.io.*;
import java.util.*;

public class Solution_d4_5643_키순서_dfs {
	static int N, M, cnt;
	static int[][] adj;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_d4_5643.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N][N];
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				adj[a][b] = 1;
			}
			int ans = 0;
			for (int i = 0; i < N; i++) {
				cnt = 0;
				gdfs(i, new boolean[N]);
				ldfs(i, new boolean[N]);
				if (cnt == N-1)
					ans++;
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb);
		br.close();
	}

	static void gdfs(int cur, boolean[] v) {
		v[cur] = true;
		for (int i = 0; i < N; i++) {
			if(v[i] || adj[cur][i] == 0) continue;
			cnt++;
			gdfs(i, v);
		}
	}

	static void ldfs(int cur, boolean[] v) {
		v[cur] = true;
		for (int i = 0; i < N; i++) {
			if(v[i] || adj[i][cur] == 0) continue;
			cnt++;
			ldfs(i, v);
		}
	}
}
