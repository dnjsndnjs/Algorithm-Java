package y2023.m03.d22;

import java.io.*;
import java.util.*;

public class Main_bj_1275_커피숍2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		long[] nums = new long[N];
		long[] tree = new long[4*N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			nums[i] = Long.parseLong(st.nextToken());
		init(tree, 0, N-1, 1, nums);
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long x = Long.parseLong(st.nextToken())-1;
			long y = Long.parseLong(st.nextToken())-1;
			long a = Long.parseLong(st.nextToken())-1;
			long b = Long.parseLong(st.nextToken());
			if (x > y) {
				x ^= y;
				y ^= x;
				x ^= y;
			}
			sb.append(sum(tree, 0, N-1, 1, (int) x, (int) y)).append("\n");
			long diff = b - nums[(int) a];
			nums[(int) a] = b;
			update(tree, 0, N-1, 1, (int) a, diff);
		}
		System.out.print(sb);
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
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return tree[n];
		int m = (s+e)/2;
		return sum(tree, s, m, n*2, l, r) + sum(tree, m+1, e, n*2+1, l, r);
	}
}