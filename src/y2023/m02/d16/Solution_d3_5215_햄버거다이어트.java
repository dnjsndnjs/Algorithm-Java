package y2023.m02.d16;

import java.io.*;
import java.util.*;

public class Solution_d3_5215_햄버거다이어트 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[] memo = new int[L+1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int T = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				for (int j = L; j > 0; j--) {
					if (j-K < 0) break;
					memo[j] = Math.max(memo[j], memo[j-K]+T);
				}
			}
			sb.append("#"+tc+" "+memo[L]+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
