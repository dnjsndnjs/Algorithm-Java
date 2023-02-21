package y2023.m02.d21;

import java.io.*;
import java.util.*;

public class Main_bj_6987_월드컵_반대로생각 {
	static final int N = 6;
	
	static int[][] result = new int[4][18];
	static int[] C = new int[18], ans = new int[4];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 18; j++)
				result[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 4; i++) {
			bt(0, 1, i);
			System.out.print(ans[i]+" ");
		}
	}
	
	static void bt(int i, int j, int r) {
		if (i == N-1) {
			for (int k = 0; k < 18; k++)
				if (result[r][k] != 0) return;
			ans[r] = 1;
			return;
		}
		if (ans[r] != 0) return;
		int ni = i, nj = j+1;
		if (nj == N) {
			ni++; nj = ni+1;
		}
		for (int p = 0; p < 3; p++) {
			if (result[r][i*3+p] > 0 && result[r][j*3+2-p] > 0) {
				result[r][i*3+p]--; result[r][j*3+2-p]--;
				bt(ni, nj, r);
				result[r][i*3+p]++; result[r][j*3+2-p]++;
			}
		}
	}
}
