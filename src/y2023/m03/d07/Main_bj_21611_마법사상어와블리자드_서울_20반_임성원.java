package y2023.m03.d07;

import java.io.*;
import java.util.*;

public class Main_bj_21611_마법사상어와블리자드_서울_20반_임성원 {
	static final int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static final int[] coeff = {3, -1, -3, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		List<Integer> ball = new ArrayList<>(N*N);
		int d = 0, x = N/2, y = N/2;
		ball.add(0);
		l:for (int l = 1; l <= N; l++) {
			for (int k = 0; k < 2; k++) {
				for (int i = 0; i < l; i++) {
					if (x == 0 && y == 0) break l;
					x+=dx[d]; y+=dy[d];
					if (map[x][y] == 0) break l;
					ball.add(map[x][y]);
				}
				if (++d == 4) d = 0;
			}
		}
		int[] exp = new int[4];
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken())-1;
			for (int s = Integer.parseInt(st.nextToken()); s > 0; s--) {
				int idx = (4*s+coeff[d])*s;
				if (idx >= ball.size()) continue;
				ball.remove(idx);
			}
			List<Integer> next = new ArrayList<>();
			next.add(0);
			int cnt = 1, prev = ball.get(1);
			for (int i = 2, size = ball.size(); i < size; i++) {
				int cur = ball.get(i);
				if (cur == prev) {
					cnt++;
				} else if (cnt >= 4) {
					exp[prev] += cnt;
					if (next.size() == 1) {
						prev = cur;
						cnt = 1;
						continue;
					}
					i--;
					prev = next.remove(next.size()-1);
					cnt = next.remove(next.size()-1);
				} else {
					next.add(cnt);
					next.add(prev);
					prev = cur;
					cnt = 1;
				}
			}
			ball = next;
		}
		int ans = 0;
		for (int i = 1; i < 4; i++) {
			ans += i*exp[i];
		}
		System.out.println(ans);
		br.close();
	}
}
