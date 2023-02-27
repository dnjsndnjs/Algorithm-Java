package y2023.m02.d27;

import java.io.*;
import java.util.*;

public class Solution_d4_3289_서로소집합_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] set = new int[N+1];
			for (int i = 1; i <= N; i++)
				set[i] = i;
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int o = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (o == 0)
					union(set, a, b);
				else
					sb.append(find(set, a, b) ? 1 : 0);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static int find(int[] set, int a) {
		if (set[a] == a) return a;
		return set[a] = find(set, set[a]);
	}
	
	static boolean find(int[] set, int a, int b) {
		return find(set, a) == find(set, b);
	}
	
	static void union(int[] set, int a, int b) {
		int ar = find(set, a);
		int br = find(set, b);
		if (ar != br) set[br] = a;
	}
}
