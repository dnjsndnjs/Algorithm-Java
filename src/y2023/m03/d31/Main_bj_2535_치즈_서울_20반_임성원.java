package y2023.m03.d31;

import java.io.*;
import java.util.*;

public class Main_bj_2535_치즈_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int total = 0;
		boolean[][] map = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = st.nextToken().charAt(0) == '1';
				if (map[i][j]) total++;
			}
		}
		Deque<int[]> q = new ArrayDeque<>();
		Deque<int[]> next = new ArrayDeque<>();
		boolean[][] v = new boolean[H][W];
		v[0][0] = true;
		q.offer(new int[] {0, 0});
		int ans = 0;
		while (!q.isEmpty()) {
			while (!q.isEmpty()) {
				int[] ij = q.poll();
				int i = ij[0], j = ij[1];
				for (int d = 0; d < 4; d++) {
					int ni = i+di[d], nj = j+dj[d];
					if (!(0 <= ni && ni < H && 0 <= nj && nj < W && !v[ni][nj])) continue;
					v[ni][nj] = true;
					int[] tmp = {ni, nj};
					if (map[ni][nj])
						next.offer(tmp);
					else
						q.offer(tmp);
				}
			}
			ans++;
			total -= next.size();
			if (total == 0) {
				total = next.size();
				break;
			}
			while (!next.isEmpty()) {
				int[] ij = next.poll();
				int i = ij[0], j = ij[1];
				map[i][j] = false;
				q.offer(ij);
			}
		}
		System.out.println(ans+"\n"+total);
		br.close();
	}
}
