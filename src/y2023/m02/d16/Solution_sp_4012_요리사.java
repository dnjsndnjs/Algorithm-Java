package y2023.m02.d16;

import java.io.*;
import java.util.*;

public class Solution_sp_4012_요리사 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_sp_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] S = new int[N][N];
			int[] v = new int[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					S[i][j] = Integer.parseInt(st.nextToken());
			}
			v[0] = 1;
			sb.append("#"+tc+" ")
			  .append(comb(1, 1, N, S, v))
			  .append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	static int comb(int cnt, int start, int N, int[][] S, int[] v) {
		int res = Integer.MAX_VALUE;
		if (cnt == N/2) {
			int[] sum = {0, 0};
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					if (v[i] == v[j]) sum[v[i]] += S[i][j] + S[j][i];
				}
			}
			return Math.abs(sum[0]-sum[1]);
		}
		for (int i = start; i < N; i++) {
			v[i] = 1;
			int tmp = comb(cnt+1, i+1, N, S, v);
			v[i] = 0;
			if (res > tmp)
				res = tmp;
		}
		return res;
	}
}
