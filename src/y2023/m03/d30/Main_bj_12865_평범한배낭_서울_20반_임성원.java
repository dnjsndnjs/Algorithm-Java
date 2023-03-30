package y2023.m03.d30;

import java.io.*;
import java.util.*;

public class Main_bj_12865_평범한배낭_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[K+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			for (int j = K; j >= 0; j--) {
				if (j < W) break;
				dp[j] = Math.max(dp[j], dp[j-W]+V);
			}
		}
		System.out.println(dp[K]);
		br.close();
	}
}
