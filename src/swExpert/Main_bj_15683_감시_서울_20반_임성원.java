package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_15683_감시_서울_20반_임성원 {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	
	static int N, M;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static int zeros;
	static int cnum;
	static int[][] cctvs;
	static int[] direction;
	
	static void recur(int d) {
		if (d == cnum) {
			calc();
			return;
		}
		int n = 4;
		if (cctvs[d][2] == 2)
			n = 2;
		else if (cctvs[d][2] == 5) {
			n = 1;
		}
		for (int i = 0; i < n; i++) {
			direction[d] = i;
			recur(d+1);
		}
	}
	
	static void calc() {
		int[][] tm = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tm[i][j] = map[i][j];
			}
		}
		int res = zeros;
		for (int c = 0; c < cnum; c++) {
			int[] cctv = cctvs[c];
			int x = cctv[0], y = cctv[1], type = cctv[2];
			int d = direction[c];
			
			res -= calcLine(tm, x, y, d);
			if (type == 3 || type == 4 || type == 5) {
				res -= calcLine(tm, x, y, (d+1)%4);
			}
			if (type == 2 || type == 4 || type == 5) {
				res -= calcLine(tm, x, y, (d+2)%4);
			}
			if (type == 5) {
				res -= calcLine(tm, x, y, (d+3)%4);
			}
		}
		if (res < min)
			min = res;
	}
	
	static int calcLine(int[][] tm, int x, int y, int d) {
		int res = 0;
		x += dx[d];
		y += dy[d];
		while (inRange(x, y) && tm[x][y] != 6) {
			if (tm[x][y] == 0) {
				tm[x][y] = 7;
				res++;
			}
			x += dx[d];
			y += dy[d];
		}
		return res;
	}
	
	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvs = new int[8][];
		direction = new int[8];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if (num == 0) {
					zeros++;
				} else if (num != 6) {
					cctvs[cnum++] = new int[] {i, j, num};
				}
			}
		}
		
		recur(0);
		System.out.println(min);
	}
}
