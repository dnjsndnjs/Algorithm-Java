package study.week5;

import java.io.*;
import java.util.*;

public class boj_21610_LimSW {
	static final int[] di = {0, -1, -1, -1, 0, 1, 1, 1};
	static final int[] dj = {-1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int sum = 0;
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		Deque<int[]> rain = new ArrayDeque<>();
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				rain.offer(new int[] {N-1-i, j});
		
		for (int m = 0; m < M; m++) {
			// loop: 현재 큐에 들어있는 요소의 수. loop만큼 반복
			// plus: 비구름에 의해 물이 증가한 바구니를 기록
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int loop = rain.size();
			boolean[][] plus = new boolean[N][N];
			// 1, 2: 비구름 이동 후 물 증가
			for (int l = 0; l < loop; l++) {
				int[] ij = rain.poll();
				int i = ij[0] + di[d]*s, j = ij[1] + dj[d]*s;
				while (i < 0) i+=N;
				while (j < 0) j+=N;
				while (i >= N) i-=N;
				while (j >= N) j-=N;
				map[i][j]++;
				sum++;
				plus[i][j] = true;
				rain.offer(new int[] {i, j});
			}
			// 4: 8방탐색용 di, dj에서 2씩 증가하면 대각선
			for (int l = 0; l < loop; l++) {
				int[] ij = rain.poll();
				int i = ij[0], j = ij[1];
				int cnt = 0;
				for (d = 1; d < 8; d+=2) {
					int ni = i + di[d], nj = j + dj[d];
					if (0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] != 0)
						cnt++;
				}
				map[i][j] += cnt;
				sum += cnt;
			}
			// 5: plus를 참고하여 물이 2 이상인 곳에서 구름 생성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] >= 2 && !plus[i][j]) {
						map[i][j] -= 2;
						sum -= 2;
						rain.offer(new int[] {i, j});
					}
				}
			}
		}
		System.out.println(sum);
		br.close();
	}
}
