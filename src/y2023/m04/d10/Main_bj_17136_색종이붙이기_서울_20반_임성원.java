package y2023.m04.d10;

import java.io.*;
import java.util.*;

public class Main_bj_17136_색종이붙이기_서울_20반_임성원 {
	static int N = 10, ans = 26;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[N][N];
		int total = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) total++;
			}
		}
		int[] paper = {5,5,5,5,5};
		back(0, 0, total, paper, map);
		if (ans == 26) ans = -1;
		System.out.println(ans);
		br.close();
	}

	static void back(int cnt, int sum, int total, int[] paper, int[][] map) {
		if (sum >= ans) return;
		if (total == 0 || cnt == N*N) {
			if (ans > sum && total == 0)
				ans = sum;
			return;
		}
		int i = cnt / N, j = cnt % N;
		if (map[i][j] == 0) back(cnt+1, sum, total, paper, map);
		else {
			int L = cover(i, j, map);
			for (int l = 0; l < L; l++) {
				for (int dl = 0; dl <= l; dl++)
					map[i+l][j+dl] = map[i+dl][j+l] = 0;
			}
			for (int l = L-1; l >= 0; l--) {
				if (paper[l] != 0) {
					paper[l]--;
					back(cnt+1, sum+1, total-(l+1)*(l+1), paper, map);
					paper[l]++;
				}
				for (int dl = 0; dl <= l; dl++)
					map[i+l][j+dl] = map[i+dl][j+l] = 1;
			}
		}
	}

	static int cover(int i, int j, int[][] map) {
		int L = 1;
		L:for (; L < 5; L++) {
			if (i+L == N || j+L == N) break;
			for (int l = 0; l <= L; l++) {
				if (map[i+L][j+l] == 0) break L;
				if (map[i+l][j+L] == 0) break L;
			}
		}
		return L;
	}
}
