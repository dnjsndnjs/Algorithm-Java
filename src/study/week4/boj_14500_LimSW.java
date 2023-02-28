package study.week4;

import java.io.*;
import java.util.*;

public class boj_14500_LimSW {
	static final int[] di = {0, 1, 0, -1}, dj = {1, 0, -1, 0};
	
	static int N, M, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		boolean[][] v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(1, i, j, map, v, 0);
				func(i, j, map);
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	// 테트로미노의 모양이 길이가 4인 한줄로 이어진 도형과 같음
	// dfs 재귀를 4까지만 진행
	static void dfs(int cnt, int i, int j, int[][] map, boolean[][] v, int sum) {
		sum += map[i][j];
		if (cnt == 4) {
			if (ans < sum) ans = sum;
			return;
		}
		v[i][j] = true;
		// 탐색에 따라 중복이 생김 <- 개선이 필요
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (!(0 <= ni && ni < N && 0 <= nj && nj < M && !v[ni][nj])) continue;
			dfs(cnt+1, ni, nj, map, v, sum);
		}
		v[i][j] = false;
	}
	
	// 테트로미노중 ㅗ 모양의 경우 한줄로 이을 수 없음
	// 따로 처리해주는 함수
	// + 모양으로 합을 전부 구한 후 4방향을 하나씩 떼어서 계산
	static void func(int i, int j, int[][] map) {
		int sum = map[i][j];
		int[] way = new int[4];
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (!(0 <= ni && ni < N && 0 <= nj && nj < M)) continue;
			way[d] = map[ni][nj];
			sum += way[d];
		}
		for (int d = 0; d < 4; d++) {
			int tmp = sum - way[d];
			if (ans < tmp) ans = tmp;
		}
	}
}
