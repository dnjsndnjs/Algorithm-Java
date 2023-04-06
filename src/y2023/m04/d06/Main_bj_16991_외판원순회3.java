package y2023.m04.d06;

import java.io.*;
import java.util.*;

/*
 * 시작점은 반드시 방문 상태 => 해당 부분의 비트마스킹에 의미가 없음
 * 시작점을 N-1로 설정하면 memo 배열의 길이가 (1<<N)에서 (1<<N-1)로 줄일 수 있음
 * 다음 점을 위한 순회도 N-1은 반드시 방문 상태이니까 고려하지 않아도 됨
 */

public class Main_bj_16991_외판원순회3 {
	static final double INF = 4*16*2000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N], y = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		double[][] g = new double[N][N];
		double[][] memo = new double[N][1<<(N-1)];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				int dx = x[i]-x[j], dy = y[i]-y[j];
				g[i][j] = g[j][i] = Math.sqrt(dx*dx+dy*dy);
			}
			memo[i][(1<<(N-1))-1] = g[i][N-1];
		}
		System.out.println(tsp(N-1, 0, N, g, memo));
	}

	static double tsp(int i, int v, int N, double[][] g, double[][] memo) {
		if (memo[i][v] != 0) return memo[i][v];
		double res = INF;
		for (int j = 0, b = 1; j < N-1; j++, b<<=1) {
			if (i == j) continue;
			if ((v&b) != 0) continue;
			res = Math.min(res, tsp(j, v|b, N, g, memo)+g[i][j]);
		}
		return memo[i][v] = res;
	}
}
