package y2023.m03.d03;

import java.io.*;
import java.util.*;

public class Main_bj_4485_녹색옷입은애가젤다지_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int tc = 1; N != 0; N = Integer.parseInt(br.readLine()), tc++) {
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dist[0][0] = map[0][0];
			PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[2], y[2]));
			pq.offer(new int[] {0, 0, map[0][0]});
			while (!pq.isEmpty()) {
				int[] ijw = pq.poll();
				int i = ijw[0], j = ijw[1], w = ijw[2];
				if (dist[i][j] < w) continue;
				if (i == N-1 && j == N-1) break;
				for (int d = 0; d < 4; d++) {
					int ni = i + di[d], nj = j + dj[d];
					if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
					if (dist[ni][nj] > w + map[ni][nj]) {
						dist[ni][nj] = w + map[ni][nj];
						pq.offer(new int[] {ni, nj, dist[ni][nj]});
					}
				}
			}
			sb.append("Problem ").append(tc).append(": ").append(dist[N-1][N-1]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
