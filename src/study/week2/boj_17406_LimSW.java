package study.week2;

import java.io.*;
import java.util.*;

public class boj_17406_LimSW {
	static int N, M, K, ans;
	static int[][] map, ops;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 배열 A
		map = new int[N+1][M+1];
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
		perm(0);
		System.out.println(ans);
		br.close();
	}
	
	static void perm(int cnt) {
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
			for (int j = 1; j <= s; j++) {
				// 반복문을 줄이기 위해 4개의 줄을 한번에 회전
				//   회전해야하는 줄의 길이가 같아서 한번에 가능
				// 끝 값을 저장
				int tt = map[r-j][c+j];
				int tr = map[r+j][c+j];
				int tb = map[r+j][c-j];
				int tl = map[r-j][c-j];
				// 회전 방향의 역순으로 채워나감
				for (int k = j; k > -j; k--) {
					map[r-j][c+k] = map[r-j][c+k-1];
					map[r+k][c+j] = map[r+k-1][c+j];
					map[r+j][c-k] = map[r+j][c-k+1];
					map[r-k][c-j] = map[r-k+1][c-j];
				}
				// 끝 값을 있어야할 위치에 넣어줌
				map[r-j+1][c+j] = tt;
				map[r+j][c+j-1] = tr;
				map[r+j-1][c-j] = tb;
				map[r-j][c-j+1] = tl;
			}
			perm(cnt+1);
			// 원상복귀
			for (int j = 1; j <= s; j++) {
				int tt = map[r-j][c-j];
				int tr = map[r-j][c+j];
				int tb = map[r+j][c+j];
				int tl = map[r+j][c-j];
				for (int k = -j; k < j; k++) {
					map[r-j][c+k] = map[r-j][c+k+1];
					map[r+k][c+j] = map[r+k+1][c+j];
					map[r+j][c-k] = map[r+j][c-k-1];
					map[r-k][c-j] = map[r-k-1][c-j];
				}
				map[r-j+1][c-j] = tt;
				map[r-j][c+j-1] = tr;
				map[r+j-1][c+j] = tb;
				map[r+j][c-j+1] = tl;
			}
			v[i] = false;
		}
	}
}
