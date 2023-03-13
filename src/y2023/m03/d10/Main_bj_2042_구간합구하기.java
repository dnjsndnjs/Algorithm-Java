package y2023.m03.d10;

import java.io.*;
import java.util.*;

public class Main_bj_2042_구간합구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] nums = new long[N];
		long[] tree = new long[4*N+1];
		for (int i = 0; i < N; i++)
			nums[i] = Long.parseLong(br.readLine());
		init(tree, nums, 0, N-1, 1);
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				update(tree, 0, N-1, 1, b-1, c-nums[b-1]);
				nums[b-1] = c;
			} else {
				sb.append(sum(tree, 0, N-1, 1, b-1, (int)c-1)).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	static long init(long[] tree, long[] nums, int s, int e, int node) {
		if (s == e)
			return tree[node] = nums[s];
		int m = (s+e)/2;
		return tree[node] = init(tree, nums, s, m, node*2)
				+ init(tree, nums, m+1, e, node*2+1);
	}
	
	static void update(long[] tree, int s, int e, int node, int idx, long diff) {
		if (idx < s || e < idx) return;
		tree[node] += diff;
		if (s == e) return;
		int m = (s+e)/2;
		update(tree, s, m, node*2, idx, diff);
		update(tree, m+1, e, node*2+1, idx, diff);
	}
	
	static long sum(long[] tree, int s, int e, int node, int l, int r) {
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return tree[node];
		int m = (s+e)/2;
		return sum(tree, s, m, node*2, l, r) + sum(tree, m+1, e, node*2+1, l, r);
	}
}
