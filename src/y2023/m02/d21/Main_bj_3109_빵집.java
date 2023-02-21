package y2023.m02.d21;

import java.io.*;
import java.util.*;

/*
 * 한번 지나갔을 때 끝까지 도달하지 못하는 지점은
 *   다시 방문하더라도 끝까지 도달하지 못하는 지점
 *   따라서 도달하지 못한 지점을 원래상태로 되돌리면 시간 초과
 */

public class Main_bj_3109_빵집 {
	static int R, C, ans;
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
				if (in.charAt(j) == 'x') map[i][j] = 1;
			}
		}
		for (int i = 0; i < R; i++) {
			if (dfs(i, 0)) ans++;
		}
		System.out.println(ans);
		br.close();
	}
	
	static boolean dfs(int i, int j) {
		if (!(0 <= i && i < R)) return false;
		if (j == C) return true;
		if (map[i][j] != 0) return false;
		map[i][j] = 2;
		if (dfs(i-1, j+1))
			return true;
		if (dfs(i, j+1))
			return true;
		if (dfs(i+1, j+1))
			return true;
		return false;
	}
}
