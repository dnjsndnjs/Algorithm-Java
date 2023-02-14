package y2023.m02.d14;

import java.io.*;
import java.util.*;

public class Solution_d3_9229_한빈이와SpotMart_서울_20반_임성원 {
	static int ans;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_9229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				A[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(A);
			ans = -1;
			comb(0, 0, N, M, M, A);
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	static void comb(int cnt, int start, int n, int m, int w, int[] A) {
		if (w < 0)
			return;
		if (cnt == 2) {
			if (ans < m-w)
				ans = m-w;
			return;
		}
		for (int i = start; i < n; i++) {
			comb(cnt+1, i+1, n, m, w-A[i], A);
		}
	}
}
