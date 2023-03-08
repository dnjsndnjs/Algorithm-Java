package y2023.m03.d08;

import java.io.*;
import java.util.*;

public class Main_bj_9376_탈옥 {
	static final int INF = 10001;
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, 1, -1};
	
	static int H, W, ans;
	
	static class Pos {
		int x, y, level;
		Pos(int i, int j, int level) {
			x = i; y = j; this.level = level;
		}
		public String toString() {
			return x+" "+y+" "+level;
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
			Pos[] people = new Pos[2];
			int[][] map = new int[H][W];
			int[][] levels = new int[H][W];
			for (int i = 0; i < H; i++) {
				String in = br.readLine();
				for (int j = 0; j < W; j++) {
					levels[i][j] = INF;
					switch (in.charAt(j)) {
					case '*': map[i][j] = 1; break;
					case '#': map[i][j] = 2; break;
					case '$':
						if (cnt == 0) levels[i][j] = 0;
						people[cnt++] = new Pos(i, j, 0);
						break;
					}
				}
			}
			System.out.println(Arrays.toString(people));
			ans = 0;
			bfs(people[0], map, levels);
			for(int[]m:levels) {
				for (int n:m)
					System.out.print(n+"\t");
				System.out.println();
			}
			System.out.println();
			bfs(people[1], map, levels);
			for(int[]m:levels) {
				for (int n:m)
					System.out.print(n+"\t");
				System.out.println();
			}
			System.out.println();
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static void bfs(Pos pos, int[][] map, int[][] levels) {
		Deque<Pos> q = new ArrayDeque<>();
		boolean[][] v = new boolean[H][W];
		v[pos.x][pos.y] = true;
		int level = pos.level = levels[pos.x][pos.y];
		q.offer(pos);
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			int i = cur.x, j = cur.y, l = cur.level;
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < H && 0 <= nj && nj < W)) continue;
				if (map[ni][nj] == 1 || v[ni][nj]) continue;
				v[ni][nj] = true;
				if (map[ni][nj] == 0) {
					levels[ni][nj] = l;
					q.push(new Pos(ni, nj, l));
				} else {
					levels[ni][nj] = l+1;
					q.offer(new Pos(ni, nj, l+1));
				}
			}
		}
	}
	
	static void bfs2(Pos pos, int[][] map, int[][] levels) {
		Deque<Pos> q = new ArrayDeque<>();
		boolean[][] v = new boolean[H][W];
		v[pos.x][pos.y] = true;
		int level = pos.level = levels[pos.x][pos.y];
		q.offer(pos);
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			int i = cur.x, j = cur.y, l = cur.level;
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < H && 0 <= nj && nj < W)) continue;
				if (map[ni][nj] == 1 || v[ni][nj]) continue;
				v[ni][nj] = true;
				if (map[ni][nj] == 0) {
					levels[ni][nj] = l;
					q.push(new Pos(ni, nj, l));
				} else {
					levels[ni][nj] = l+1;
					q.offer(new Pos(ni, nj, l+1));
				}
			}
		}
	}
}
