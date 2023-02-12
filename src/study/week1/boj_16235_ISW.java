package study.week1;

import java.io.*;
import java.util.*;

public class boj_16235_ISW {
	static final int[] di = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static final int[] dj = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static int N;
	static int[][] map;

	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_16235.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		int[][] add = new int[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[2], y[2]));
		List<int[]> alive = new ArrayList<>();
		List<int[]> death = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				add[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pq.add(new int[] { x - 1, y - 1, z });
		}
		// K년 후
		for (int year = 0; year < K; year++) {
			alive.clear();
			death.clear();
			// 봄
			while (!pq.isEmpty()) {
				int[] now = pq.poll();
				if (map[now[0]][now[1]] >= now[2]) {
					map[now[0]][now[1]] -= now[2];
					now[2]++;
					alive.add(now);
				} else {
					death.add(now);
				}
			}
			pq.addAll(alive);
			// 여름
			for (int[] t : death) {
				map[t[0]][t[1]] += t[2] / 2;
			}
			// 가을
			for (int[] t : alive) {
				if (t[2] % 5 != 0)
					continue;
				for (int d = 0; d < 8; d++) {
					int x = t[0] + di[d];
					int y = t[1] + dj[d];
					if (inRange(x, y)) {
						pq.add(new int[] { x, y, 1 });
					}
				}
			}
			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] += add[i][j];
				}
			}
		}
		System.out.println(pq.size());
		br.close();
	}
}
