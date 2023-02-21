package y2023.m02.d21;

import java.io.*;
import java.util.*;

public class Main_bj_17144_미세먼지안녕_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0};
	static final int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int mr = -1, total = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] < 0) {
					map[i][j] = 0;
					if (mr < 0) mr = i;
				}
				total += map[i][j];
			}
		}
		for (int time = 0; time < T; time++) {
			int[][] tmap = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 0) continue;
					tmap[i][j] += map[i][j];
					int dust = map[i][j] / 5;
					if (dust == 0) continue;
					for (int d = 0; d < 4; d++) {
						int ni = i + di[d], nj = j + dj[d];
						if (!(0 <= ni && ni < R && 0 <= nj && nj < C)) continue;
						if (nj == 0 && (ni == mr || ni == mr+1)) continue;
						tmap[ni][nj] += dust;
						tmap[i][j] -= dust;
					}
				}
			}
			map = tmap;
//			for (int[] m:map)System.out.println(Arrays.toString(m));System.out.println();
			total -= map[mr-1][0];
			for (int i = mr-1; i > 0; i--)
				map[i][0] = map[i-1][0];
			for (int j = 0; j < C-1; j++)
				map[0][j] = map[0][j+1];
			for (int i = 0; i < mr; i++)
				map[i][C-1] = map[i+1][C-1];
			for (int j = C-1; j > 0; j--)
				map[mr][j] = map[mr][j-1];
			total -= map[mr+2][0];
			for (int i = mr+2; i < R-1; i++)
				map[i][0] = map[i+1][0];
			for (int j = 0; j < C-1; j++)
				map[R-1][j] = map[R-1][j+1];
			for (int i = R-1; i > mr+1; i--)
				map[i][C-1] = map[i-1][C-1];
			for (int j = C-1; j > 0; j--)
				map[mr+1][j] = map[mr+1][j-1];
//			for (int[] m:map)System.out.println(Arrays.toString(m));System.out.println();
		}
		System.out.println(total);
		br.close();
	}
}
