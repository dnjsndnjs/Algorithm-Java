package y2023.m03.d28;

import java.io.*;
import java.util.*;

public class Solution_sp_1952_수영장_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_sp_1952.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int[] pay = new int[4];
			int[] dp = new int[15];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++)
				pay[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 12; i++) {
				int tmp = pay[0]*Integer.parseInt(st.nextToken());
				tmp = Math.min(tmp, pay[1]);
				dp[i] = Math.min(dp[i], dp[i-1]+tmp);
				dp[i+2] = dp[i-1] + pay[2];
			}
			int ans = Math.min(Math.min(pay[3], dp[12]), Math.min(dp[13], dp[14]));
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
