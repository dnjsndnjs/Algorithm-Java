package y2023.m03.d21;

import java.io.*;
import java.util.*;

public class Main_bj_2357_최솟값과최댓값 {
	static final Node zero = new Node(1_000_000_001, 0);
	static class Node {
		int min, max;
		Node(int min, int max) {
			this.min = min;
			this.max = max;
		}
		Node(Node a, Node b) {
			this.min = Math.min(a.min, b.min);
			this.max = Math.max(a.max, b.max);
		}
		public String toString() {
			return min+" "+max+"\n";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		Node[] tree = new Node[4*N];
		
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());
		init(tree, 0, N-1, 1, nums);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			sb.append(get(tree, 0, N-1, 1, a, b));
		}
		System.out.print(sb);
		br.close();
	}
	
	static Node init(Node[] tree, int s, int e, int n, int[] nums) {
		if (s == e) return tree[n] = new Node(nums[s], nums[s]);
		int m = (s+e)/2;
		return tree[n] = new Node(init(tree, s, m, n*2, nums), init(tree, m+1, e, n*2+1, nums));
	}
	
	static Node get(Node[] tree, int s, int e, int n, int l, int r) {
		if (r < s || e < l) return zero;
		if (l <= s && e <= r) return tree[n];
		int m = (s+e)/2;
		return new Node(get(tree, s, m, n*2, l ,r), get(tree, m+1, e, n*2+1, l, r));
	}
}
