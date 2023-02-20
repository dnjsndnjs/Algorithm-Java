package y2023.m02.d20;

import java.io.*;
import java.util.*;

public class Main_bj_21608_상어초등학교 {
	static final int[] di = {-1, 1, 0, 0};
	static final int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] student = new int[N*N+1][4];
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			q.offer(n);
			for (int j = 0; j < 4; j++)
				student[n][j] = Integer.parseInt(st.nextToken());
			Arrays.sort(student[n]);
		}
		map[1][1] = q.poll();
		while (!q.isEmpty()) {
			int n = q.poll();
			int like = -1, blank = 0, r = 0, c = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) continue;
					int tl = 0, tb = 0;
					for (int d = 0; d < 4; d++) {
						int ni = i + di[d], nj = j + dj[d];
						if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
						if (map[ni][nj] == 0) tb++;
						if (Arrays.binarySearch(student[n], map[ni][nj]) >= 0) tl++;
					}
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
		int[] ans = new int[5];
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
		for (int i = 1, n = 1; i < 5; i++, n *= 10) {
			sum += n * ans[i];
		}
//		System.out.println(Arrays.toString(ans));
		System.out.println(sum);
		br.close();
	}
}
