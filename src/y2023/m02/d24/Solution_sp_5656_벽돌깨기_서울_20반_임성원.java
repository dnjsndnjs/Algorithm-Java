package y2023.m02.d24;

import java.io.*;
import java.util.*;

public class Solution_sp_5656_벽돌깨기_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
	
	static int N, W, H, total, max;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_sp_5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			total = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) total++;
				}
			}
			max = 0;
//			for(int[]m:map)System.out.println(Arrays.toString(m));System.out.println();
			prod(0, new int[N], map);
			sb.append("#").append(tc).append(" ").append(total-max).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static void prod(int cnt, int[] ball, int[][] map) {
		if (cnt == N) {
			int[][] tmap = new int[H][W];
			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					tmap[i][j] = map[i][j];
			simul(ball, tmap);
			return;
		}
		for (int i = 0; i < W; i++) {
			ball[cnt] = i;
			prod(cnt+1, ball, map);
		}
	}
	
	static void simul(int[] ball, int[][] map) {
//		System.out.println(Arrays.toString(ball));
		int res = 0;
		for (int b = 0; b < N; b++) {
			int r = 0, c = ball[b];
			ArrayDeque<int[]> q = new ArrayDeque<>();
			while (r < H && map[r][c] == 0) r++;
			if (r == H) break;
			res++;
			q.offer(new int[] {r, c, map[r][c]});
			map[r][c] = 0;
			while (!q.isEmpty()) {
				int[] rcl = q.poll();
				r = rcl[0]; c = rcl[1];
				int l = rcl[2];
				for (int d = 0; d < 4; d++) {
					int nr = r + di[d], nc = c + dj[d];
					for (int i = 1; i < l; i++, nr+=di[d], nc+=dj[d]) {
						if (!(0 <= nr && nr < H && 0 <= nc && nc < W)) break;
						if (map[nr][nc] == 0) continue;
						res++;
						q.offer(new int[] {nr, nc, map[nr][nc]});
						map[nr][nc] = 0;
					}
				}
			}
			for (c = 0; c < W; c++) {
				for (int z = r = H-1; r >= 0; r--) {
					if (map[z][c] != 0) z--;
					else if (map[r][c] != 0) {
						map[z--][c] =  map[r][c];
						map[r][c] = 0;
					}
				}
			}
//			for(int[]m:map)System.out.println(Arrays.toString(m));System.out.println();
		}
		if (max < res) max = res;
	}
}
