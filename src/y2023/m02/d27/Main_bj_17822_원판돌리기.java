package y2023.m02.d27;

import java.io.*;
import java.util.*;

public class Main_bj_17822_원판돌리기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M];
		int sum = 0, num = N*M;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		for(int[] m: map)System.out.println(Arrays.toString(m));System.out.println();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int i = x; i <= N; i+=x) {
				if (d == 0) k = -k;
				int[] tmp = new int[M];
				for (int j = 0, nj = k; j < M; j++, nj++) {
					if (nj < 0) nj += M;
					if (nj >= M) nj -= M;
					tmp[j] = map[i][nj];
				}
				map[i] = tmp;
			}
			map[0] = map[N];
			ArrayDeque<int[]> q = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				for (int j = 0, nj = 1; j < 0; j++, nj++) {
					if (map[i][j] == 0) continue;
					boolean delete = false;
					if (nj == M) nj-=M;
					if (map[i][j] == map[i-1][j]) delete = true;
					if (map[i][j] == map[i][nj]) delete = true;
					if (delete) q.add(new int[] {i, j});
				}
			}
			if (q.isEmpty()) {
				
			}
			while (!q.isEmpty()) {
				int[] ij = q.poll();
				int i = ij[0], j = ij[1];
				sum -= map[i][j];
				num--;
			}
			for(int[] m: map)System.out.println(Arrays.toString(m));System.out.println();
		}
	}

}
