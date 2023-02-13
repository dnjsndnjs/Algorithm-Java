package y2023.m02.d13;

import java.io.*;
import java.util.*;

public class Solution_d4_7733_치즈도둑_서울_20반_임성원_dfs {
	static final int[] di = {-1, 0, 1, 0};
	static final int[] dj = {0, 1, 0, -1};
	
	static int N;
	static int[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int min = Integer.MAX_VALUE, max = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (min > map[i][j])
						min = map[i][j];
					if (max < map[i][j])
						max = map[i][j];
				}
			}
			int ans = 1;
			for (int k = min; k < max; k++) {
				int res = 0;
				v = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (v[i][j] || map[i][j] <= k) continue;
						dfs(i, j, k);
						res++;
					}
				}
				if (ans < res)
					ans = res;
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	static void dfs(int i, int j, int k) {
		v[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
			if (v[ni][nj] || map[i][j] <= k) continue;
			dfs(ni, nj, k);
		}
	}
}
