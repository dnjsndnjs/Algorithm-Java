package y2023.m04.d06;

import java.io.*;
import java.util.*;

public class Main_bj_2098_외판원순회_서울_20반_임성원 {
	static final int INF = Integer.MAX_VALUE/2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] g = new int[N][N];
		int[][] dp = new int[N][1<<(N-1)];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				g[i][j] = Integer.parseInt(st.nextToken());
				if (g[i][j] == 0) g[i][j] = INF;
			}
			dp[i][(1<<(N-1))-1] = g[i][N-1];
		}
		System.out.println(tsp(N-1, 0, N-1, g, dp));
		br.close();
	}

	static int tsp(int i, int v, int N, int[][] g, int[][] dp) {
		if (dp[i][v] != 0) return dp[i][v];
		int res = INF;
		for (int j = 0, b = 1; j < N; j++, b<<=1) {
			if ((v&b) != 0) continue;
			res = Math.min(res, tsp(j, v|b, N, g, dp)+g[i][j]);
		}
		return dp[i][v] = res;
	}
}
