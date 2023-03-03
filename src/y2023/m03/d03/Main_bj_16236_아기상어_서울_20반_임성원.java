package y2023.m03.d03;

import java.io.*;
import java.util.*;

public class Main_bj_16236_아기상어_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, 1, -1};
	
	static int N, x, y, size, cnt, len;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					map[i][j] = 0;
					x = i; y = j;
				}
			}
		}
		int ans;
		size = 2;
		cnt = 0;
		for (ans = 0; bfs(map); ans+=len) {
			map[x][y] = 0;
			if (++cnt == size) {
				size++;
				cnt = 0;
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	static boolean bfs(int[][] map) {
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][N];
		v[x][y] = true;
		q.offer(new int[] {x, y, 0});
		x = N; y = N;
		len = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] ijw = q.poll();
			int i = ijw[0], j = ijw[1], w = ijw[2];
			if (w > len)
				break;
			if (map[i][j] != 0 && map[i][j] < size) {
				if (x > i) {
					x = i; y = j;
				} else if (x == i && y > j)
					y = j;
				len = w;
			}
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
				if (v[ni][nj] || map[ni][nj] > size) continue;
				v[ni][nj] = true;
				q.offer(new int[] {ni, nj, w+1});
			}
		}
		if (len != Integer.MAX_VALUE)
			return true;
		return false;
	}
}
