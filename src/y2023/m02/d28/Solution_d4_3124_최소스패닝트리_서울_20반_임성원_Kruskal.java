package y2023.m02.d28;

import java.io.*;
import java.util.*;

public class Solution_d4_3124_최소스패닝트리_서울_20반_임성원_Kruskal {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int[] p = new int[N+1];
			for (int i = 1; i <= N; i++) p[i] = i;
			
			int[][] edges = new int[E][3];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 3; j++)
					edges[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(edges, (x, y) -> Integer.compare(x[2], y[2]));
			
			long sum = 0;
			int cnt = 0;
			for (int[] e : edges) {
				if (union(p, e[0], e[1])) {
					sum += e[2];
					if (++cnt == N-1) break;
				}
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static int find(int[] p, int a) {
		if (p[a] == a) return a;
		return p[a] = find(p, p[a]);
	}
	
	static boolean union(int[] p, int a, int b) {
		int ar = find(p, a);
		int br = find(p, b);
		if (ar == br) return false;
		p[br] = ar;
		return true;
	}
}
