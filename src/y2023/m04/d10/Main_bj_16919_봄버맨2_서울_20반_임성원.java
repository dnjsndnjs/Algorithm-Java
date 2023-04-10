package y2023.m04.d10;

import java.io.*;
import java.util.*;

public class Main_bj_16919_봄버맨2_서울_20반_임성원 {
	static final int[] di = {0, 0, 1, -1}, dj = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		if ((N&1) == 0) { // 2n
			StringBuilder tmp = new StringBuilder();
			while (C--> 0) tmp.append("O");
			tmp.append("\n");
			while (R--> 0) {
				br.readLine();
				sb.append(tmp.toString());
			}
		} else if (N == 1) {
			while (R--> 0) sb.append(br.readLine()).append('\n');
		} else {
			boolean[][] map = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				String in = br.readLine();
				for (int j = 0; j < C; j++) {
					if (in.charAt(j) == 'O') {
						map[i][j] = true;
						for (int d = 0; d < 4; d++) {
							int ni = i+di[d], nj = j+dj[d];
							if (!(0 <= ni && ni < R && 0 <= nj && nj < C)) continue;
							map[ni][nj] = true;
						}
					}
				}
			}
			if ((N&2) == 0) {
				boolean[][] tmp = new boolean[R][C];
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j]) continue;
						tmp[i][j] = true;
						for (int d = 0; d < 4; d++) {
							int ni = i+di[d], nj = j+dj[d];
							if (!(0 <= ni && ni < R && 0 <= nj && nj < C)) continue;
							tmp[ni][nj] = true;
						}
					}
				}
				map = tmp;
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++)
					sb.append(map[i][j] ? '.' : 'O');
				sb.append('\n');
			}
		}
		System.out.print(sb);
		br.close();
	}
}