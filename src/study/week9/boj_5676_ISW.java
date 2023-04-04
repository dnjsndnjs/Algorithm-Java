package study.week9;

import java.io.*;
import java.util.*;

public class boj_5676_ISW {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input, " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] nums = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken());
				if (n < 0) nums[i] = -1;
				if (n > 0) nums[i] = 1;
			}
			int[] tree = new int[4*N];
			init(0, N-1, 1, tree, nums);

			while (K-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				char op = st.nextToken().charAt(0);
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken());
				if (op == 'C') {
					if (b < 0) b = -1;
					if (b > 0) b = 1;
					int tmp = nums[a]*b;
					if (tmp != 1) update(0, N-1, 1, a, b, tree);
					nums[a] = b;
				} else {
					b--;
					int tmp = get(0, N-1, 1, a, b, tree);
					if (tmp != 0) {
						if (tmp < 0) sb.append("-");
						else sb.append("+");
					} else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

	static int init(int s, int e, int n, int[] tree, int[] nums) {
		if (s == e) return tree[n] = nums[s];
		int m = (s+e)/2;
		int lt = init(s, m, n*2, tree, nums);
		int rt = init(m+1, e, n*2+1, tree, nums);
		return tree[n] = lt*rt;
	}
	
	static int get(int s, int e, int n, int l, int r, int[] tree) {
		if (e < l || r < s) return 2;
		if (l <= s && e <= r) return tree[n];
		int m = (s+e)/2;
		int lt = get(s, m, n*2, l, r, tree);
		int rt = get(m+1, e, n*2+1, l, r, tree);
		if (lt == 2) return rt;
		if (rt == 2) return lt;
		return lt*rt;
	}

	static int update(int s, int e, int n, int i, int diff, int[] tree) {
		if (i < s || e < i) return tree[n];
		if (s == e) return tree[n] = diff;
		int m = (s+e)/2;
		int lt = update(s, m, n*2, i, diff, tree);
		int rt = update(m+1, e, n*2+1, i, diff, tree);
		if (lt == 2) tree[n] = rt;
		else if (rt == 2) tree[n] = lt;
		else tree[n] = rt*lt;
		return tree[n];
	}
}
