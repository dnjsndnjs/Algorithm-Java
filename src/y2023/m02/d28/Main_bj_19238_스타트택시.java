package y2023.m02.d28;

import java.io.*;
import java.util.*;

public class Main_bj_19238_스타트택시 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
	
	static int N, M, F, nx, ny;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		
		List<int[]> people = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] tmp = new int[4];
			for (int j = 0; j < 4; j++)
				tmp[j] = Integer.parseInt(st.nextToken())-1;
			map[tmp[0]][tmp[1]] = -1;
			people.add(tmp);
		}
	}
	
	static int bfs(int i, int j, int[][] map, int option) {
		boolean[][] v = new boolean[N][N];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		int dist = 0;
		q.offer(new int[] {i, j, dist});
		while(!q.isEmpty()) {
			int[] ijd = q.poll();
			i = ijd[0]; j = ijd[1]; dist = ijd[2];
			if (option == 0 && map[i][j] == -1) {
				if (nx > i) {
					nx = i;
					ny = j;
				} else if (nx == i && ny > j) {
					ny = j;
				}
			}
			if (option == 1 && i == nx && j == ny) {
				return dist;
			}
			if (dist > F) return -1;
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
				if (v[ni][nj] || map[ni][nj] == 1) continue;
				v[ni][nj] = true;
				q.offer(new int[] {ni, nj, dist+1});
			}
		}
		return dist;
	}
}
