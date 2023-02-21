package study.week3;

import java.io.*;
import java.util.*;

public class boj_21608_LimSW {
	static final int[] di = {-1, 1, 0, 0};
	static final int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] student = new int[N*N+1][4]; // 학생별로 좋아하는 학생 정보 저장
		// 학생의 순서를 기억하기 위한 queue
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			q.offer(n);
			for (int j = 0; j < 4; j++)
				student[n][j] = Integer.parseInt(st.nextToken());
			// binary search를 사용하기 위해 정렬
			Arrays.sort(student[n]);
		}
		map[1][1] = q.poll();
		while (!q.isEmpty()) {
			int n = q.poll();
			// 좋아하는 학생 수가 0인 자리에 앉게 되는 경우를 고려하기 위해 -1로 초기화
			int like = -1, blank = 0, r = 0, c = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) continue;
					int tl = 0, tb = 0;
					for (int d = 0; d < 4; d++) {
						int ni = i + di[d], nj = j + dj[d];
						if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
						if (map[ni][nj] == 0) tb++;
						// 좋아하는 학생인지 빠르게 판단하기 위해 binary search 사용
						if (Arrays.binarySearch(student[n], map[ni][nj]) >= 0) tl++;
					}
					// 조건이 같을 경우 행이 작은 경우가, 행이 같으면 열이 작은 경우가
					// 우선이므로 해당 순서대로 이중 for 문 탐색하면서
					// 좋아하는 학생 수나 빈칸의 수가 같은 때는 갱신 안함
					if (like < tl) {
						like = tl; blank = tb; r = i; c = j;
					} else if (like == tl && blank < tb) {
						blank = tb; r = i; c = j;
					}
				}
			}
			map[r][c] = n;
		}
//		for (int[] m:map)System.out.println(Arrays.toString(m));System.out.println();
		int[] ans = new int[5]; // 학생의 만족도를 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int n = map[i][j], like = 0;
				for (int d = 0; d < 4; d++) {
					int ni = i + di[d], nj = j + dj[d];
					if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
					if (Arrays.binarySearch(student[n], map[ni][nj]) >= 0) like++;
				}
				ans[like]++;
//				System.out.println(n+Arrays.toString(student[n])+like);
			}
		}
		int sum = 0;
		// 좋아하는 학생 수에 따른 만족도: 10^like
		for (int i = 1, n = 1; i < 5; i++, n *= 10) {
			sum += n * ans[i];
		}
//		System.out.println(Arrays.toString(ans));
		System.out.println(sum);
		br.close();
	}
}
