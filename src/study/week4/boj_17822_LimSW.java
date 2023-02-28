package study.week4;

import java.io.*;
import java.util.*;

public class boj_17822_LimSW {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M];
		// sum: 수의 합계, num: 수의 개수
		int sum = 0, num = N*M;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		// T개의 명령
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			// 반시계 방향이면 k를 부호바꾸기
			if (d == 0) k = -k;
			// x의 배수에 해당하는 원반 회전
			for (int i = x; i <= N; i+=x) {
				// 새로운 배열에 회전
				int[] tmp = new int[M];
				for (int j = 0, nj = k; j < M; j++, nj++) {
					if (nj < 0) nj += M;
					if (nj >= M) nj -= M;
					tmp[j] = map[i][nj];
				}
				// 회전한 배열로 변경
				map[i] = tmp;
			}
			// 바로바로 지우면 지워야할 값이 지워지지 않을 수 있음
			// q에 담아 한번에 지우기
			ArrayDeque<int[]> q = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				for (int j = 0, nj = 1, pj = M-1; j < M; j++, nj++, pj++) {
					if (map[i][j] == 0) continue;
					boolean delete = false;
					if (nj >= M) nj-=M;
					if (pj >= M) pj-=M;
					// 상하좌우 조건 확인 후 q에 한번만 넣기
					if (map[i][j] == map[i-1][j]) delete = true;
					else if (i != N && map[i][j] == map[i+1][j]) delete = true;
					else if (map[i][j] == map[i][nj]) delete = true;
					else if (map[i][j] == map[i][pj]) delete = true;
					if (delete) q.offer(new int[] {i, j});
				}
			}
			// q가 비어있다 -> 지우는 값이 없다
			if (q.isEmpty()) {
				double avg = 1.* sum / num;
				for (int i = 1; i <= N; i++) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] == 0) continue;
						// 오류때문에 double과의 비교를 명시적으로 처리했으나 다른 부분이 문제였음ㅠㅜ
						if (1.*map[i][j] < avg) {
							map[i][j]++;
							sum++;
						// else를 해주지 않으면 map[i][j]가 3, avg가 3.66일때
						// map[i][j]가 4로 증가후 다시 조건 판단하여 3으로 돌아오는 오류가 생김
						} else if (1.*map[i][j] > avg){
							map[i][j]--;
							sum--;
						}
					}
				}
			}
			// q의 크기 = 지우는 값의 개수
			num -= q.size();
			while (!q.isEmpty()) {
				int[] ij = q.poll();
				int i = ij[0], j = ij[1];
				sum -= map[i][j];
				map[i][j] = 0;
			}
		}
		System.out.println(sum);
	}
}
