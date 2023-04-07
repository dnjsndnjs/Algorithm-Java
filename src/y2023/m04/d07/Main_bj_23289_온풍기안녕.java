package y2023.m04.d07;

import java.io.*;
import java.util.*;

public class Main_bj_23289_온풍기안녕 {
	static final int[] di = {-1, 0, 1, 0}, dj = {0, -1, 0, 1};
	static final Comparator<int[]> comp = new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {
			int r = Integer.compare(o1[0], o2[0]);
			if (r == 0) r = Integer.compare(o1[1], o2[1]);
			return r;
		};
	};

	static int R, C, K;
	static int[][] map;
	static List<int[]> heater, search;
	static List<List<int[]>> wall;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		heater = new ArrayList<>();
		search = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C ; j++) {
				int d = Integer.parseInt(st.nextToken());
				switch(d) {
				case 5: search.add(new int[] {i, j});
				case 0: continue;
				case 1: d = 3; break;
				case 2: d = 1; break;
				case 3: d = 0; break;
				case 4: d = 2; break;
				}
				heater.add(new int[] {i, j, d});
			}
		}
		wall = new ArrayList<>();
		for (int i = 0; i < 4; i++) wall.add(new ArrayList<>());
		int W = Integer.parseInt(br.readLine());
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			if (t == 0) {
				wall.get(0).add(new int[] {x-1, y});
				wall.get(2).add(new int[] {x, y});
			} else {
				wall.get(1).add(new int[] {x, y+1});
				wall.get(3).add(new int[] {x, y});
			}
		}
		for (int i = 0; i < 4; i++) Collections.sort(wall.get(i), comp);
		for(int[] m:map)System.out.println(Arrays.toString(m));System.out.println();
		
		int ans = 0;
		while (++ans <= 10) { //
			// 1
			for (int[] h : heater) {
				int i = h[0], j = h[1], d = h[2];
				heat(i, j, d);
			}
			// 2
			balance();
			// 3
			for (int i = 0; i < R; i++) {
				if (map[i][0] != 0) map[i][0]--;
				if (map[i][C-1] != 0) map[i][C-1]--;
			}
			for (int i = 0; i < C; i++) {
				if (map[0][i] != 0) map[0][i]--;
				if (map[R-1][i] != 0) map[R-1][i]--;
			}
			// 5
			boolean end = true;
			for (int[] s : search) {
				if (map[s[0]][s[1]] < K) {
					end = false;
					break;
				}
			}
			if (end) break;
			for(int[] m:map)System.out.println(Arrays.toString(m));System.out.println();
		}
		System.out.println(ans);
		br.close();
	}

	static boolean inRange(int i, int j, int d) {
		return (0 <= i && i < R && 0 <= j && j < C);
	}

	static void heat(int i, int j, int d) {
		// int l = (d+1)%4, r = (d+3)%4;
		// for (int h = 5, c = 0; h > 0; h--, c++) {
		// 	int ni = i+di[d], nj = j+dj[d];
		// 	if (!inRange(ni, nj, d)) continue;
		// 	map[ni][ni] += h;
		// }
	}
	
	static void balance() {
		int[][] tmp = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tmp[i][j] += map[i][j];
				if (i == R-1 || j == C-1) continue;
				int[] pos = {i, j};
				if (Collections.binarySearch(wall.get(3), pos, comp) < 0) {
					int diff = map[i][j] - map[i][j+1];
					int c = Math.abs(diff)/4;
					if (diff < 0) {
						tmp[i][j] += c;
						tmp[i][j+1] -= c;
					} else {
						tmp[i][j] -= c;
						tmp[i][j+1] += c;
					}
				}
				if (Collections.binarySearch(wall.get(2), pos, comp) < 0) {
					int diff = map[i][j] - map[i+1][j];
					int c = Math.abs(diff)/4;
					if (diff < 0) {
						tmp[i][j] += c;
						tmp[i+1][j] -= c;
					} else {
						tmp[i][j] -= c;
						tmp[i+1][j] += c;
					}
				}
			}
		}
		map = tmp;
	}
}
