package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_17135_캐슬디펜스_서울_20반_임성원 {
	static final int[] dr = {0, -1, 0};
	static final int[] dc = {-1, 0, 1};
	
	static int N, M, D, T, anum = 3, ans = 0;
	static int[][] map, tmap;
	static int[] archer = new int[anum], tr = new int[anum], tc = new int[anum];
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		T = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && T < 0)
					T = N - i;
			}
		}
		comb(0, 0);
		System.out.println(ans);
		br.close();
	}
	static void comb(int cnt, int start) {
		if (cnt == anum) {
			simul();
			return;
		}
		for (int i = start; i < M; i++) {
			archer[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	static void simul() {
		int res = 0;
		tmap = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				tmap[i][j] = map[i][j];
		
		for (int turn = 0; turn < T; turn++) {
			for (int i = 0; i < anum; i++)
				bfs(i);
			for (int i = 0; i < anum; i++) {
				if (tmap[tr[i]][tc[i]] == 0) continue;
				tmap[tr[i]][tc[i]] = 0;
				res++;
			}
			
			for (int i = N-1; i > 0; i--)
				tmap[i] = tmap[i-1];
			tmap[0] = new int[M];
		}
		if (ans < res)
			ans = res;
	}
	
	static void bfs(int idx) {
		int r = N-1, c = archer[idx], d = 1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c, d});
		tr[idx] = r; tc[idx] = c;
		v = new boolean[N][M];
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			r = temp[0]; c = temp[1]; d = temp[2];
			if (d > D) continue;
			if (v[r][c]) continue;
			v[r][c] = true;
			if (tmap[r][c] == 1) {
				tr[idx] = r; tc[idx] = c;
				return; 
			}
			for (int i = 0; i < 3; i++) {
				r += dr[i]; c += dc[i];
				if (r >= 0 && r < N && c >= 0 && c < M && !v[r][c])
					q.add(new int[] {r, c, d+1});
				r -= dr[i]; c -= dc[i];
			}
		}
	}
}
