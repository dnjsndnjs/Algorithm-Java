package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_17143_낚시왕_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0};
	static final int[] dj = {0, 0, 1, -1};
	
	static int R, C;
	
	static class Shark {
		int i, j, s, d, z;
		Shark(int i, int j, int s, int d, int z) {
			this.i = i;
			this.j = j;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		public String toString() {
			return d+" "+z+" ";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		Deque<Shark> sharks = new ArrayDeque<>();
		int f = 0, fp = R;
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			map[i][j] = z;
			sharks.offer(new Shark(i, j, s, d, z));
			if (j == f && fp > i) fp = i;
		}
//		for (int[] m : map) System.out.println(Arrays.toString(m)); System.out.println();
		int ans = 0;
		for (f = 0; f < C; f++) {
			// 
			if (fp < R) {
				ans += map[fp][f];
				map[fp][f] = 0;
			}
			fp = R;
//			System.out.println(f+" "+ans);
//			for (int[] m : map) System.out.println(Arrays.toString(m)); System.out.println();
			//
			int loop = sharks.size();
			for (int i = 0; i < loop; i++) {
				Shark s = sharks.poll();
				if (map[s.i][s.j] == 0 || map[s.i][s.j] > s.z) continue;
				map[s.i][s.j] = 0;
				int ni = s.i + s.s*di[s.d], nj = s.j + s.s*dj[s.d];
				while (!(0 <= ni && ni < R && 0 <= nj && nj < C)) {
					if (di[s.d] != 0)
						ni = (di[s.d] > 0) ? 2*(R-1)-ni : -ni;
					if (dj[s.d] != 0)
						nj = (dj[s.d] > 0) ? 2*(C-1)-nj : -nj;
					s.d += -di[s.d]+dj[s.d];
				}
				s.i = ni; s.j = nj;
				if (s.j == f+1 && fp > s.i) fp = s.i;
				sharks.offer(s);
			}
			loop = sharks.size();
			for (int i = 0; i < loop; i++) {
				Shark s = sharks.poll();
				if (map[s.i][s.j] > s.z) continue;
				map[s.i][s.j] = s.z;
				sharks.offer(s);
			}
//			for (int[] m : map) System.out.println(Arrays.toString(m)); System.out.println();
		}
		System.out.println(ans);
		br.close();
	}
}
