package study.week2;

import java.io.*;
import java.util.*;

public class boj_17142_ISW {
	static final int[] di = {-1, 0, 1, 0};
	static final int[] dj = {0, -1, 0, 1};
	
	static int N, M, vn, blank, ans;
	static int[][] map;
	static int[] vi, vj; // 바이러스의 위치 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		// 2의 개수는 M보다 크거나 같고, 10보다 작거나 같은 자연수
		vi = new int[10];
		vj = new int[10];
		vn = 0;
		// 빈 공간의 수 저장
		blank = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					vi[vn] = i;
					vj[vn] = j;
					vn++;
				}
				if (map[i][j] == 0)
					blank++;
			}
		}
		ans = Integer.MAX_VALUE;
		comb(0, 0, new int[M]);
		if (ans == Integer.MAX_VALUE) ans = 0;
		// 아래에서 서술할 문제 때문에 ans-1 출력
		System.out.println(ans-1);
		br.close();
	}
	
	// virus: 초기에 활성화할 바이러스의 위치 조합
	static void comb(int cnt, int start, int[] virus) {
		if (cnt == M) {
			// bfs
			Deque<int[]> q = new ArrayDeque<>();
			// 해당 칸에 바이러스가 전파된 시간을 저장하는 이차원 배열
			// 초기화 문제로 전파된 시간 + 1로 저장
			// ex) 바이러스가 시작부터 있던 칸 = 1
			//     바이러스가 마지막으로 전파된 칸 = ans + 1;
			int[][] time = new int[N][N];
			int C = 0;
			for (int k = 0; k < M; k++) {
				int i = vi[virus[k]], j = vj[virus[k]];
				time[i][j] = 1;
				q.offer(new int[] {i, j, 1});
			}
			while (!q.isEmpty()) {
				int[] ijt = q.poll();
				C++;
				int i = ijt[0], j = ijt[1], t = ijt[2];
				// 비활성 바이러스가 활성이 된 경우
				// t는 q에 넣을때의 값이 유지되므로 새로 활성된 바이러스가
				// 전파하는 공간의 시간은 유지됨
				// 비활성 바이러스 자체는 시작부터 있었으므로 time[i][j]를 1로 바꿈
				if (map[i][j] == 2)
					time[i][j] = 1;
				for (int d = 0; d < 4; d++) {
					int ni = i + di[d], nj = j + dj[d];
					if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
					if (time[ni][nj] != 0 || map[ni][nj] == 1) continue;
					time[ni][nj] = t+1;
					q.offer(new int[] {ni, nj, t+1});
				}
			}
			// 모든 칸에 퍼지지 못한 경우
			if (C-vn != blank)
				return;
			// 가장 마지막에 전파된 시간 구하기
			int tmax = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int t = time[i][j];
					if (tmax < t)
						tmax = t;
				}
			}
			if (ans > tmax)
				ans = tmax;
			return;
		}
		for (int i = start; i < vn; i++) {
			virus[cnt] = i;
			comb(cnt+1, i+1, virus);
		}
	}
}
