package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_14503_로봇청소기_서울_20반_임성원 {
	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };

	static int N, M;

	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int res = 0;
		main: while (true) {
			if (map[r][c] == 0) {
				map[r][c] = 2;
				res++;
			}
			for (int i = 0; i < 4; i++) {
				d = (d + 3) % 4;
				int x = r + di[d], y = c + dj[d];
				if (inRange(x, y) && map[x][y] == 0) {
					r = x;
					c = y;
					continue main;
				}
			}
			int x = r - di[d], y = c - dj[d];
			if (inRange(x, y) && map[x][y] != 1) {
				r = x;
				c = y;
				continue main;
			} else
				break main;
		}
		System.out.println(res);
		br.close();
	}
}
