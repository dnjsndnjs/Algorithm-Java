package y2023.m02.d13;

import java.io.*;
import java.util.*;

public class Main_bj_17406_배열돌리기4 {
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
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
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
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++)
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
			perm(cnt+1);
			// 원상복귀
			v[i] = false;
		}
	}
}
