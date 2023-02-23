package y2023.m02.d23;

import java.io.*;
import java.util.*;

public class Solution_d4_1219_길찾기_서울_20반_임성원 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1219.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			boolean[][] g = new boolean[100][100];
			boolean[] v = new boolean[100];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				g[a][b] = true;
			}
			sb.append("#").append(tc).append(" ");
//			if (dfs(0, g, v)) sb.append(1);
			if (bfs(0, g, v)) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static boolean dfs(int i, boolean[][] g, boolean[] v) {
		if (i == 99) return true;
		v[i] = true;
		for (int j = 0; j < 100; j++)
			if (g[i][j] && !v[j] && dfs(j, g, v)) return true;
		return false;
	}
	
	static boolean bfs(int i, boolean[][] g, boolean[] v) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			if (i == 99) return true;
			for (int j = 0; j < 100; j++) {
				if (g[i][j] && !v[j]) {
					v[j] = true;
					q.offer(j);
				}
			}
		}
		return false;
	}
}
