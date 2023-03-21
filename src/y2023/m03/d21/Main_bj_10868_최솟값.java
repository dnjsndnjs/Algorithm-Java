package y2023.m03.d21;

import java.io.*;
import java.util.*;

public class Main_bj_10868_최솟값 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		int[] tree = new int[4*N];
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());
		init(tree, 0, N-1, 1, nums);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			sb.append(get(tree, 0, N-1, 1, a, b)).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static int init(int[] tree, int s, int e, int n, int[] nums) {
		if (s == e) return tree[n] = nums[s];
		int m = (s+e)/2;
		return tree[n] = Math.min(init(tree, s, m, n*2, nums), init(tree, m+1, e, n*2+1, nums));
	}
	
	static int get(int[] tree, int s, int e, int n, int l, int r) {
		if (r < s || e < l) return Integer.MAX_VALUE;
		if (l <= s && e <= r) return tree[n];
		int m = (s+e)/2;
		return Math.min(get(tree, s, m, n*2, l, r), get(tree, m+1, e, n*2+1, l, r));
	}
}
