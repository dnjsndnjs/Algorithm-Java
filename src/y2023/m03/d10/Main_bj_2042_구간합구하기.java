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
		int[] nums = new int[N];
		int[] tree = new int[4*N+1];
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());
		init(tree, nums, 0, N-1, 1);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(tree));
	}
	
	static int init(int[] tree, int[] nums, int s, int e, int node) {
		if (s == e)
			return tree[node] = nums[s];
		int m = (s+e)/2;
		return tree[node] = init(tree, nums, s, m, node*2)
				+ init(tree, nums, m+1, e, node*2+1);
	}
	
	static void update(int[] tree, int s, int e, int node, int idx, int diff) {
		if (idx < s || e < idx) return;
		tree[node] += diff;
		if (s==e) return;
		int m = (s+e)/2;
		update(tree, s, m, node*2, idx, diff);
		update(tree, m+1, e, node*2+1, idx, diff);
	}
	
	static int sum(int[] tree, int s, int e, int node, int idx, int diff) {
		if (idx < s || e < idx) return 0;
		if (s==e) return tree[node];
		int m = (s+e)/2;
		return sum(tree, s, m, node*2, idx, diff) + sum(tree, m+1, e, node*2+1, idx, diff);
	}
}
