package y2023.m02.d23;

import java.io.*;
import java.util.*;

public class Main_bj_1987_알파벳_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
	static final int N = 'Z'-'A'+1;
	
	static int R, C, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String in = br.readLine();
			for (int j = 0; j < C; j++)
				map[i][j] = in.charAt(j)-'A';
		}
		ans = 0;
		dfs(0, 0, 1, map, new boolean[N]);
		System.out.println(ans);
		br.close();
	}

	static void dfs(int i, int j, int sum, int[][] map, boolean[] va) {
		va[map[i][j]] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j +dj[d];
			if (!(0 <= ni && ni < R && 0 <= nj && nj < C)) continue;
			if (va[map[ni][nj]]) continue;
			dfs(ni, nj, sum+1, map, va);
		}
		if (ans < sum) ans = sum;
		va[map[i][j]] = false;
	}
}
