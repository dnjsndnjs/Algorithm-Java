package study.week5;

import java.io.*;
import java.util.*;

public class boj_20057_LimSW {
	static final int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static final int[][] position = {
			{1, -1, 1}, {1, 1, 1},
			{2, -2, 0}, {2, 2, 0},
			{7, -1, 0}, {7, 1, 0},
			{10, -1, -1}, {10, 1, -1},
			{5, 0, -2},
	};
	static final int pn = position.length;
	
	static class Pos {
		int r, x, y;
		Pos(int[] arr){
			r = arr[0];
			x = arr[1];
			y = arr[2];
		}
		void rotate() {
			int tmp = x;
			x = -y;
			y = tmp;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		Pos[] pos = new Pos[pn];
		for (int i = 0; i < pn; i++)
			pos[i] = new Pos(position[i]);
		
		int ans = 0, d = 0, x = N/2, y = N/2;
		l:for (int l = 1; l <= N; l++) {
			for (int k = 0; k < 2; k++) {
				for (int i = 0; i < l; i++) {
					x += dx[d]; y += dy[d];
					int num = map[x][y];
					for (int j = 0; num != 0 && j < pn; j++) {
						int tmp = num * pos[j].r / 100;
						int nx = x+pos[j].x, ny = y+pos[j].y;
						if (!(0 <= nx && nx < N && 0 <= ny && ny < N))
							ans += tmp;
						else map[nx][ny] += tmp;
						map[x][y] -= tmp;
					}
					int nx = x+dx[d], ny = y+dy[d];
					if (!(0 <= nx && nx < N && 0 <= ny && ny < N))
						ans += map[x][y];
					else
						map[nx][ny] += map[x][y];
					map[x][y] = 0;
					if (x == 0 && y == 0) break l;
				}
				if (++d == 4) d = 0;
				for (int i = 0; i < pn; i++)
					pos[i].rotate();
			}
		}
		System.out.println(ans);
		br.close();
	}
}
