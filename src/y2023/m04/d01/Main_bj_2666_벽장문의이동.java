package y2023.m04.d01;

import java.io.*;
import java.util.*;

public class Main_bj_2666_벽장문의이동 {
	static int INF = 10_0000_0000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		int N = Integer.parseInt(br.readLine());
		int[][][] memo = new int[N+1][M][M];
		for (int i = 0; i <= N; i++)
			for (int j = 0; j < M; j++)
				Arrays.fill(memo[i][j], INF);

		int[] input = new int[N];
		for (int i = 0; i < N; i++)
			input[i] = Integer.parseInt(br.readLine());
		System.out.println(dp(0, N, a, b, input, memo));
		br.close();
	}

	static int dp(int cnt, int N, int a, int b, int[] input, int[][][] memo) {
		if (cnt == N) {
			return 0;
		}
		if (memo[cnt][a][b] != INF) return memo[cnt][a][b];
		// if (input[cnt] <= a);
		return memo[cnt][a][b] = memo[cnt][b][a] = Math.min(
			dp(cnt+1, N, a, input[cnt], input, memo)+Math.abs(b-input[cnt]),
			dp(cnt+1, N, input[cnt], b, input, memo)+Math.abs(a-input[cnt]));
	}
}

/*
8
3 8
2
5
1
=> 5
 */