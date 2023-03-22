package y2023.m03.d22;

import java.io.*;
import java.util.*;

public class Main_bj_1725_히스토그램 {
	static int N;
	static int[] nums, tree;
	static long ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N+1];
		tree = new int[4*N];
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());
		nums[N] = 1_000_000_001;
		init(0, N-1, 1);
		
		ans = 0;
		calc(0, N-1);
		System.out.println(ans);
		br.close();
	}
	
	static int init(int s, int e, int n) {
		if (s == e) return tree[n] = s;
		int m = (s+e)/2;
		int a = init(s, m, n*2);
		int b = init(m+1, e, n*2+1);
		return tree[n] = (nums[a] < nums[b]) ? a : b;
	}
	
	static int get(int s, int e, int n, int l, int r) {
		if (l > r) return N;
		if (r < s || e < l) return N;
		if (l <= s && e <= r) return tree[n];
		int m = (s+e)/2;
		int a = get(s, m, n*2, l, r);
		int b = get(m+1, e, n*2+1, l, r);
		return (nums[a] < nums[b]) ? a : b;
	}
	
	static void calc(int l, int r) {
		int h = get(0, N-1, 1, l, r);
		if (h == N) return;
		long res = (long) (r-l+1) * (long) nums[h];
		if (ans < res)
			ans = res;
		calc(l, h-1);
		calc(h+1, r);
	}
}
