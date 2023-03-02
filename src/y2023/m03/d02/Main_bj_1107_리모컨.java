package y2023.m03.d02;

import java.io.*;
import java.util.*;

public class Main_bj_1107_리모컨 {
	static int N, M, K, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		K = in.length();
		N = Integer.parseInt(in);
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] error = new int[M];
		for (int i = 0; i < M; i++)
			error[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(error);
		
		ans = Math.abs(N - 100);
		if (ans < K) {
			System.out.println(ans);
			System.exit(0);
		}
		
		M = 10-M;
		int cnt = 0;
		int[] num = new int[M];
		for (int i = 0; i < 10; i++) {
			if (Arrays.binarySearch(error, i) < 0)
				num[cnt++] = i;
		}
		
		
	}
	
	static void comb() {
		
	}
}
