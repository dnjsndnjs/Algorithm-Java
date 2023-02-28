package y2023.m02.d28;

import java.io.*;
import java.util.*;

public class Main_bj_17472_다리만들기2_서울_20반_임성원_Kruskal {
	static final int[] di = {1, 0, -1, 0}, dj = {0, 1, 0, -1};
	
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M ; j++)
				map[i][j] = -Integer.parseInt(st.nextToken());
		}
		int inum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) continue;
				group(i, j, map, ++inum);
			}
		}
		for(int[] m:map)System.out.println(Arrays.toString(m));System.out.println();
		
	}
	
	static void group(int i, int j, int[][] map, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		map[i][j] = cnt;
		q.offer(new int[] {i, j});
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0]; j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < N && 0 <= nj && nj < M)) continue;
				if (map[ni][nj] != -1) continue;
				map[ni][nj] = cnt;
				q.offer(new int[] {ni, nj});
			}
		}
	}
	
}
