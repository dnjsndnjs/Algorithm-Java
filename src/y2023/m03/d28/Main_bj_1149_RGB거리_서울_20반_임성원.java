package y2023.m03.d28;

import java.io.*;
import java.util.*;

public class Main_bj_1149_RGB거리_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] tmp = new int[3];
			for (int j = 0; j < 3; j++)
				tmp[j] = Integer.parseInt(st.nextToken());
			tmp[0] += Math.min(dp[1], dp[2]);
			tmp[1] += Math.min(dp[0], dp[2]);
			tmp[2] += Math.min(dp[0], dp[1]);
			for (int j = 0; j < 3; j++)
				dp[j] = tmp[j];
		}
		int ans = Integer.MAX_VALUE;
		for (int j = 0; j < 3; j++)
			if (ans > dp[j]) ans = dp[j];
		System.out.println(ans);
		br.close();
	}
}
