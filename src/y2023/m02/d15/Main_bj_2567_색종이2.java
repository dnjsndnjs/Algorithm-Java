package y2023.m02.d15;

import java.io.*;
import java.util.*;

public class Main_bj_2567_색종이2 {
	static final int[] di = {1, -1, 0, 0};
	static final int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int minr = Integer.MAX_VALUE, maxr = 0;
		int minc = Integer.MAX_VALUE, maxc = 0;
		int[][] map = new int[101][101];
		for (int k = 0; k < N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (minr > r)
				minr = r;
			if (minc > c)
				minc = c;
			if (maxr < r+10)
				maxr = r+10;
			if (maxc < c+10)
				maxc = c+10;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (map[r+i][c+j] != 0) continue;
					map[r+i][c+j] = 1;
				}
			}
		}
		int ans = 0;
		for (int i = minr-1; i < maxr; i++) {
			for (int j = minc-1; j < maxc; j++) {
				if (map[i][j] != map[i+1][j]) ans++;
				if (map[i][j] != map[i][j+1]) ans++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}
