package study.week7;

import java.io.*;
import java.util.*;

/*
 * 분할 정복 문제
 * 1. 구간에서 가장 낮은 높이를 찾는다
 * 2. 구간의 길이와 가장 낮은 높이를 곱해 넓이를 구한다
 * 3. 최대값과 비교하여 갱신
 * 4. 가장 낮은 높이의 인덱스를 기준으로 구간을 분할한다.
 * 5. 분할한 구간을 대상으로 1부터 반복
 */

public class boj_6549_LimSW {
	static int N;
	static int[] nums, tree;
	static long ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0) break;
			
			nums = new int[N+1];
			tree = new int[4*N];
			for (int i = 0; i < N; i++)
				nums[i] = Integer.parseInt(st.nextToken());
			nums[N] = 1_000_000_001;
			init(0, N-1, 1);
			
			ans = 0;
			calc(0, N-1);
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
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
