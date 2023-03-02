package y2023.m03.d02;

import java.io.*;
import java.util.*;

public class Main_bj_17143_낚시왕_서울_20반_임성원 {
	static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1};
	
	static class Shark {
		int r, c, s, d, z;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		Deque<Shark> sharks = new ArrayDeque<>();
		int fc = 0, fr = R;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Shark tmp = new Shark();
			tmp.r = Integer.parseInt(st.nextToken())-1;
			tmp.c = Integer.parseInt(st.nextToken())-1;
			tmp.s = Integer.parseInt(st.nextToken());
			tmp.d = Integer.parseInt(st.nextToken())-1;
			tmp.z = Integer.parseInt(st.nextToken());
			map[tmp.r][tmp.c] = tmp.z;
			sharks.offer(tmp);
			if (fc == tmp.c && fr > tmp.r) fr = tmp.r;
		}
//		for (int[] m:map)System.out.println(Arrays.toString(m));System.out.println();
		int ans = 0;
		Deque<Shark> next = new ArrayDeque<>();
		for (fc = 0; fc < C; fc++) {
//			System.out.println(ans+" "+fc);
			if (fr != R) {
//				System.out.println(map[fr][fc]);
				ans += map[fr][fc];
				map[fr][fc] = 0;
			}
			fr = R;
			while (!sharks.isEmpty()) {
				Shark cur = sharks.poll();
				int r = cur.r, c = cur.c, s = cur.s, d = cur.d, z = cur.z;
				if (map[r][c] == 0 || map[r][c] > z)
					continue;
				map[r][c] = 0;
				int nr = r + s*dr[d], nc = c + s*dc[d];
				while (!(0 <= nr && nr < R && 0 <= nc && nc < C)) {
					if (dr[d] != 0)
						nr = (nr < 0) ? -nr : 2*(R-1)-nr;
					else
						nc = (nc < 0) ? -nc : 2*(C-1)-nc;
					d += -dr[d] + dc[d];
				}
				cur.r = nr;
				cur.c = nc;
				cur.d = d;
				if (nc == fc+1 && fr > nr)
					fr = nr;
				next.offer(cur);
			}
			while (!next.isEmpty()) {
				Shark cur = next.poll();
				int r = cur.r, c = cur.c, z = cur.z;
				if (map[r][c] > z) continue;
				map[r][c] = z;
				sharks.offer(cur);
			}
//			for (int[] m:map)System.out.println(Arrays.toString(m));System.out.println();
		}
		System.out.println(ans);
		br.close();
	}
}
