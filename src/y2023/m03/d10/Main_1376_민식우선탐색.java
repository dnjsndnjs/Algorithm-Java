package y2023.m03.d10;

import java.io.*;
import java.util.*;

public class Main_1376_민식우선탐색 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] g = new List[N+1];
		for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			g[f].add(~Collections.binarySearch(g[f], t), t);
			g[t].add(~Collections.binarySearch(g[t], f), f);
		}
		for (int i = 1; i <= N; i++) System.out.println(i+" "+g[i]);
		System.out.println();
		mfs(1, g, sb);
		System.out.println(sb);
		br.close();
	}
	
	static void mfs(int i, List<Integer>[] g, StringBuilder sb) {
		sb.append(i).append(" ");
		for (int j : g[i])
			g[j].remove(Collections.binarySearch(g[j], i));
		for (int size = g[i].size(); !g[i].isEmpty(); size = g[i].size()) {
			int v = 0;
			if ((size & 1) != 0)
				v = size/2;
			int j = g[i].remove(v);
			System.out.println(i+" "+g[i]+" "+j);
			mfs(j, g, sb);
		}
	}
}
