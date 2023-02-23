package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_17779_게리멘더링2_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
	static int N, ans;
	static int[] sector;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] pop = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				pop[i][j] = Integer.parseInt(st.nextToken());
		}
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N-2; i++) {
			for (int j = 1; j < N-1; j++) {
				simul(pop, i, j, 1, 1, true);
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	static void simul(int[][] pop, int x, int y, int d1, int d2, boolean two) {
		if (!(0 <= y-d1 && y+d2 < N && x+d1+d2 < N)) return;
		int[][] map = new int[N][N];
		
		for (int i = 0; i < d1; i++)
			map[x+i][y-i] = map[x+1+i][y-i] = map[x+d2+i][y+d2-i] = 5;
		for (int i = 0; i < d2; i++)
			map[x+i][y+i] = map[x+1+i][y+i] = map[x+d1+i][y-d1+i] = 5;
		map[x+d1+d2][y-d1+d2] = 5;
		for (int i = 0; i < x; i++) map[i][y] = 1;
		for (int i = y+d2+1; i < N; i++) map[x+d2][i] = 2;
		for (int i = 0; i < y-d1; i++) map[x+d1][i] = 3;
		for (int i = x+d1+d2+1; i < N; i++) map[i][y-d1+d2] = 4;
		dfs(x, y-1, map, 1);
		dfs(x, y+1, map, 2);
		dfs(x+d1+d2, y-d1+d2-1, map, 3);
		dfs(x+d1+d2, y-d1+d2+1, map, 4);
		dfs(x+2, y, map, 5);
		
		sector = new int[6];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sector[map[i][j]] += pop[i][j];
		}
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 1; i <= 5; i++) {
			max = Math.max(max, sector[i]);
			min = Math.min(min, sector[i]);
		}
		int diff = max - min;
		if (ans > diff) {
			ans = diff;
//			System.out.println(ans);
//			for(int[]m:map)System.out.println(Arrays.toString(m));System.out.println();
		}
		
		if(two)
			simul(pop, x, y, d1+1, d2, two);
		simul(pop, x, y, d1, d2+1, false);
	}
	
	static void dfs(int i, int j, int[][] map, int s) {
		map[i][j] = s;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
			if (map[ni][nj] == 0) dfs(ni, nj, map, s);
		}
	}
}
