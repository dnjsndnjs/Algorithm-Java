package y2023.m03.d23;

import java.io.*;
import java.util.*;

public class Main_bj_2263_트리의순회 {
	static int point;
	
	static class Node {
		int n;
		Node l, r;
		Node(int n) {
			this.n = n;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] inor = new int[N];
		int[] post = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			inor[i] = Integer.parseInt(st1.nextToken());
			post[i] = Integer.parseInt(st2.nextToken());
		}
		point = N-1;
		Node root = dq(0, N-1, 1, inor, post);
		preorder(root, sb);
		System.out.println(sb);
		br.close();
	}
	
	static Node dq(int s, int e, int n, int[] inor, int[] post) {
		if (s > e) return null;
		int m = 0;
		for (m = s; m <=e; m++)
			if (inor[m] == post[point]) break;
		Node res = new Node(post[point--]);
		res.r = dq(m+1, e, n*2+1, inor, post);
		res.l = dq(s, m-1, n*2, inor, post);
		return res;
	}
	
	static void preorder(Node n, StringBuilder sb) {
		if (n == null) return;
		sb.append(n.n).append(" ");
		preorder(n.l, sb);
		preorder(n.r, sb);
	}
}
