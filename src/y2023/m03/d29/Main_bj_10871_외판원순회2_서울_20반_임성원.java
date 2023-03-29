package y2023.m03.d29;

import java.io.*;
import java.util.*;

public class Main_bj_10871_외판원순회2_서울_20반_임성원 {
	static final int INF = 10_000_001;
	
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N][1<<N];
		int[][] g = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				g[i][j] = Integer.parseInt(st.nextToken());
			dp[i][(1<<N)-1] = g[i][0];
		}
		System.out.println(tsp(1, 0, N, g));
		br.close();
	}
	
	static int tsp(int bit, int i, int N, int[][] g) {
		if (dp[i][bit] != 0)
			return dp[i][bit];
		int res = INF;
		for (int j = 0, b = 1; j < N; j++, b<<=1) {
			if ((bit&b)!=0) continue;
			if (g[i][j] == 0) continue;
			int tmp = g[i][j]+tsp(bit|b, j, N, g);
			if (tmp >= INF) continue;
			if (res > tmp)
				res = tmp;
		}
		return dp[i][bit] = res;
	}
}
