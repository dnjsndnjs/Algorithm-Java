package y2023.m03.d07;

import java.io.*;
import java.util.*;

public class Main_bj_2252_줄세우기_서울_20반_임성원 {
	static class Node {
		int v;
		Node link;
		Node(int v, Node link) {
			this.v = v; this.link = link;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node[] g = new Node[N+1];
		int[] idg = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			g[f] = new Node(t, g[f]);
			idg[t]++;
		}
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++)
			if (idg[i] == 0) q.offer(i);
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			for (Node tmp = g[cur]; tmp != null; tmp = tmp.link) {
				if (--idg[tmp.v] == 0)
					q.offer(tmp.v);
			}
		}
		System.out.println(sb);
		br.close();
	}
}
