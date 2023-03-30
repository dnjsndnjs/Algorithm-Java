package y2023.m03.d30;

import java.io.*;
import java.util.*;

public class Solution_d3_3282_01Knapsack_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_d3_3282.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] dp = new int[K+1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int V = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				for (int j = K; j >= 0; j--) {
					if (j < V) break;
					dp[j] = Math.max(dp[j], dp[j-V]+C);
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[K]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
