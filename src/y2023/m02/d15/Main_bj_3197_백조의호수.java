package y2023.m02.d15;

import java.io.*;
import java.util.*;

public class Main_bj_3197_백조의호수 {
	static final int[] di = {-1, 1, 0, 0};
	static final int[] dj = {0, 0, -1, 1};
	
	static int R, C;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String in = br.readLine();
			for (int j = 0; j < C; j++) {
				if (in.charAt(j) == '.')
					map[i][j] = 0;
				else
					map[i][j] = 1500;
			}
		}
		for (int[] m : map) System.out.println(Arrays.toString(m));
		int day = 0;
		for (day = 0; block(new boolean[R][C]); day++) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] <= day) continue;
					for (int d = 0; d < 4; d++) {
						int ni = i+di[d], nj = j+dj[d];
						if (!(0 <= ni && ni < R && 0 <= nj && nj < C)) continue;
						if (map[ni][nj] <= day) {
							map[i][j] = day;
							break;
						}
					}
				}
			}
		}
	}
	
	static boolean block(boolean[][] v) {
		for (int i = 0; i < R; i++) {
			if (v[i][0]);
		}
		return true;
	}
}
