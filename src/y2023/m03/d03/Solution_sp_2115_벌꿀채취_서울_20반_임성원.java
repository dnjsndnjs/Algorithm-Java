package y2023.m03.d03;

import java.io.*;
import java.util.*;

public class Solution_sp_2115_벌꿀채취_서울_20반_임성원 {
	static int sum;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_sp_2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = N-M+1;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] memo = new int[N][L]; 
			int[] arr = new int[M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < L; j++) {
					for (int k = 0; k < M; k++)
						arr[k] = map[i][j+k];
					sum = 0;
					comb(0, 0, arr, M, 0, C);
					memo[i][j] = sum;
				}
			}
			int ans = 0, loop = N * L;
			for (int i = 0; i < loop; i++) {
				for (int j = i+1; j < loop; j++) {
					if (i/L == j/L && j < i+M) continue;
					int tmp = memo[i/L][i%L] + memo[j/L][j%L];
					if (ans < tmp)
						ans = tmp;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static void comb(int cnt, int start, int[] arr, int M, int tmp, int C) {
		if (sum < tmp)
			sum = tmp;
		if (cnt == M)
			return;
		for (int i = start; i < M; i++) {
			if (C - arr[i] < 0) continue;
			comb(cnt+1, i+1, arr, M, tmp+(arr[i]*arr[i]), C-arr[i]);
		}
	}
}
