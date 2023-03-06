package y2023.m03.d06;

import java.io.*;
import java.util.*;

public class Main_bj_9376_탈옥 {
	static final int INF = 10001;
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, 1, -1};
	
	static int H, W, ans;
	
	static class Pos {
		int x, y, door;
		Pos(int i, int j) {
			x = i; y = j; door = INF;
		}
		public String toString() {
			return x+" "+y+" "+door;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			int cnt = 0;
			Pos[] pos = new Pos[2];
			int[][] map = new int[H][W];
			int[][][] door = new int[2][H][W];
			for (int i = 0; i < H; i++) {
				String in = br.readLine();
				for (int j = 0; j < W; j++) {
					door[0][i][j] = door[1][i][j] = INF;
					switch (in.charAt(j)) {
					case '*': map[i][j] = 1; break;
					case '#': map[i][j] = 2; break;
					case '$':
						door[cnt][i][j] = 0;
						pos[cnt++] = new Pos(i, j);
						break;
					}
				}
			}
			System.out.println(Arrays.toString(pos));
			for(int[]m:map)System.out.println(Arrays.toString(m));System.out.println();
			ans = 0;
			bfs(pos[0], map, door[0]);
			bfs(pos[1], map, door[1]);
			System.out.println(Arrays.toString(pos));
			for(int[]m:door[0])System.out.println(Arrays.toString(m));System.out.println();
			for(int[]m:door[1])System.out.println(Arrays.toString(m));
			System.out.println();
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static void bfs(Pos pos, int[][] map, int[][] door) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {pos.x, pos.y, 0});
		while (!q.isEmpty()) {
			int[] ijd = q.poll();
			int i = ijd[0], j = ijd[1], d = ijd[2];
			for (int dd = 0; dd < 4; dd++) {
				int ni = i + di[dd], nj = j + dj[dd];
				if (!(0 <= ni && ni < H && 0 <= nj && nj < W)) {
					if (pos.door > d)
						pos.door = d;
					continue;
				}
				if (door[ni][nj] <= d || map[ni][nj] == 1) continue;
				door[ni][nj] = d;
				if (map[ni][nj] == 2) {
					door[ni][nj]++;
					q.offer(new int[] {ni, nj, d+1});
				} else
					q.offer(new int[] {ni, nj, d});
			}
		}
	}
}
