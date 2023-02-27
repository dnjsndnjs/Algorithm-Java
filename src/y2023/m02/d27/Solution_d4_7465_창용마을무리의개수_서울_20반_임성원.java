package y2023.m02.d27;

import java.io.*;
import java.util.*;

public class Solution_d4_7465_창용마을무리의개수_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7465.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] p = new int[N+1];
			for (int i = 1; i <= N; i++)
				p[i] = i;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(p, a, b);
			}
			
			List<Integer> list = new ArrayList<>();
			list.add(find(p, 1));
			for (int i = 2; i <= N; i++) {
				int r = Collections.binarySearch(list, find(p, i));
				if (r < 0) list.add(~r, p[i]);
			}
			sb.append("#").append(tc).append(" ").append(list.size()).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static int find(int[] p, int a) {
		if (p[a] == a) return a;
		return p[a] = find(p, p[a]);
	}
	
	static void union(int[] p, int a, int b) {
		int ar = find(p, a);
		int br = find(p, b);
		if (ar != br) p[br] = ar;
	}
}
