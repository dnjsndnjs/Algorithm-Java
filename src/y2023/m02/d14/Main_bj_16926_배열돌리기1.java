package y2023.m02.d14;

import java.io.*;
import java.util.*;

public class Main_bj_16926_배열돌리기1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int h = Math.min(N, M)/2;
		for (int k = 0; k < R; k++) {
			for (int l = 0; l < h; l++) {
				int save = map[l][l];
				// top
				for (int i = l; i < M-l-1; i++)
					map[l][i] = map[l][i+1];
				// right
				for (int i = l; i < N-l-1; i++)
					map[i][M-l-1] = map[i+1][M-l-1];
				// bottom
				for (int i = M-l-1; i > l; i--)
					map[N-l-1][i] = map[N-l-1][i-1];
				// left
				for (int i = N-l-1; i > l; i--)
					map[i][l] = map[i-1][l];
				map[l+1][l] = save;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(map[i][j]).append(" ");
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
