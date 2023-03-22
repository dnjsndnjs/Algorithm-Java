package study.week7;

import java.io.*;
import java.util.*;

public class boj_2042_LimSW {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] nums = new long[N];
		long[] tree = new long[4*N];
		for (int i = 0; i < N; i++)
			nums[i] = Long.parseLong(br.readLine());
		init(tree, 0, N-1, 1, nums);
		
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken())-1;
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				long diff = c - nums[b];
				update(tree, 0, N-1, 1, b, diff);
				nums[b] = c;
			} else {
				sb.append(sum(tree, 0, N-1, 1, b, (int)c-1)).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	static long init(long[] tree, int s, int e, int n, long[] nums) {
		if (s == e) return tree[n] = nums[s];
		int m = (s+e)/2;
		return tree[n] = init(tree, s, m, n*2, nums) + init(tree, m+1, e, n*2+1, nums);
	}
	
	static void update(long[] tree, int s, int e, int n, int i, long diff) {
		if (i < s || e < i) return;
		tree[n] += diff;
		if (s == e) return;
		int m = (s+e)/2;
		update(tree, s, m, n*2, i, diff);
		update(tree, m+1, e, n*2+1, i, diff);
	}
	
	static long sum(long[] tree, int s, int e, int n, int l, int r) {
		if (e < l || r < s) return 0;
		if (l <= s && e <= r) return tree[n];
		int m = (s+e)/2;
		return sum(tree, s, m, n*2, l, r) + sum(tree, m+1, e, n*2+1, l, r);
	}
}
