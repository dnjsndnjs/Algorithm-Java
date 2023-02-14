package y2023.m02.d14;

import java.io.*;
import java.util.*;

/*
 * 새로운 배열을 할당하느라 시간도 느리고 메모리도 더 많이 차지함
 */
public class Main_bj_17406_배열돌리기4_새배열할당 {
	static int N, M, K, ans;
	static int[][] ops;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 배열 A
		int[][] map = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		// 회전 연산 저장
		ops = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++)
				ops[i][j] = Integer.parseInt(st.nextToken());
		}
		// 순열
		v = new boolean[K];
		ans = Integer.MAX_VALUE;
		perm(0, map);
		System.out.println(ans);
		br.close();
	}
	
	static void perm(int cnt, int[][] map) {
		if (cnt == K) {
			// A의 값 계산
			int res = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++)
					sum += map[i][j];
				if (res > sum)
					res = sum;
			}
			if (ans > res)
				ans = res;
			return;
		}
		for (int i = 0; i < K; i++) {
			if (v[i]) continue;
			v[i] = true;
			// 배열 돌리기
			int r = ops[i][0], c = ops[i][1], s = ops[i][2];
			int[][] tmap = new int[N+1][M+1];
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= M; k++)
					tmap[j][k] = map[j][k];
			}
			for (int j = 1; j <= s; j++) {
				for (int k = j; k > -j; k--) {
					tmap[r-j][c+k] = map[r-j][c+k-1];
					tmap[r+k][c+j] = map[r+k-1][c+j];
					tmap[r+j][c-k] = map[r+j][c-k+1];
					tmap[r-k][c-j] = map[r-k+1][c-j];
				}
				tmap[r-j+1][c+j] = map[r-j][c+j];
				tmap[r+j][c+j-1] = map[r+j][c+j];
				tmap[r+j-1][c-j] = map[r+j][c-j];
				tmap[r-j][c-j+1] = map[r-j][c-j];
			}
			perm(cnt+1, tmap);
			v[i] = false;
		}
	}
}
