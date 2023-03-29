package y2023.m03.d29;

import java.io.*;
import java.util.*;

public class Main_bj_2143_두배열의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++)
			A[i] = A[i-1] + Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++)
			B[i] = B[i-1] + Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> asum = new HashMap<>();
		Map<Integer, Integer> bsum = new HashMap<>();
		for (int i = 1; i <= N; i++)
			for (int j = 0; j < i; j++) {
				int n = A[i]-A[j];
				asum.put(n, asum.getOrDefault(n, 0)+1);
			}
		for (int i = 1; i <= M; i++)
			for (int j = 0; j < i; j++) {
				int n = B[i]-B[j];
				bsum.put(n, bsum.getOrDefault(n, 0)+1);
			}
		long ans = 0;
		for (int a : asum.keySet()) {
			int t = T-a;
			ans += (long)asum.get(a)*(long)bsum.getOrDefault(t, 0);
		}
		System.out.println(ans);
		br.close();
	}
}
