package y2023.m02.d16;

import java.io.*;
import java.util.*;

public class Main_bj_16935_배열돌리기3 {
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int o = 0; o < R; o++) {
			int op = Integer.parseInt(st.nextToken());
			switch (op) {
			case 1: op1(); break;
			case 2: op2(); break;
			case 3: op34(0); break;
			case 4: op34(1); break;
			case 5:
				op56(0, 0, 0, 1);
				op56(0, 0, 1, 0);
				op56(1, 1, 1, 0);
				break;
			case 6:
				op56(0, 0, 0, 1);
				op56(1, 1, 0, 1);
				op56(1, 1, 1, 0);
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(map[i][j]).append(" ");
			sb.replace(sb.length()-1, sb.length(), "\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	static void op1() {
		int range = N/2;
		int[] tmp;
		for (int i = 0; i < range; i++) {
			tmp = map[i];
			map[i] = map[N-1-i];
			map[N-1-i] = tmp;
		}
	}
	
	static void op2() {
		int range = M/2;
		int tmp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < range; j++) {
				tmp = map[i][j];
				map[i][j] = map[i][M-1-j];
				map[i][M-1-j] = tmp;
			}
		}
	}
	
	static void op34(int d) {
		int[][] tmap = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (d == 0)
					tmap[i][j] = map[N-1-j][i];
				else
					tmap[i][j] = map[j][M-1-i];
			}
		}
		int tmp = N;
		N = M;
		M = tmp;
		map = tmap;
	}
	
	static void op56(int si, int sj, int di, int dj) {
		int n = N/2, m = M/2, tmp;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp = map[si*n+i][sj*m+j];
				map[si*n+i][sj*m+j] = map[di*n+i][dj*m+j];
				map[di*n+i][dj*m+j] = tmp;
			}
		}
	}
}
