package y2023.m02.d22;

import java.io.*;
import java.util.*;

public class Solution_d3_1873_상호의배틀필드_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
	static final char[] dc = {'^', 'v', '<', '>'};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int ti = 0, tj = 0, td = 0;
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String in = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = in.charAt(j);
					for (int d = 0; d < 4; d++) {
						if (map[i][j] == dc[d]) {
							ti = i; tj = j; td = d;
						}
					}
				}
			}
			int T = Integer.parseInt(br.readLine());
			String command = br.readLine();
			for (int time = 0; time < T; time++) {
				char com = command.charAt(time);
				int i = ti, j = tj;
				if (com == 'S') {
					for (;0 <= i && i < H && 0 <= j && j < W; i += di[td], j += dj[td]) {
						if (map[i][j] == '#') break;
						if (map[i][j] == '*') {
							map[i][j] = '.';
							break;
						}
					}
				} else {
					switch (com) {
					case 'U': td = 0; break;
					case 'D': td = 1; break;
					case 'L': td = 2; break;
					case 'R': td = 3; break;
					}
					i += di[td]; j += dj[td];
					if (0 <= i && i < H && 0 <= j && j < W && map[i][j] == '.') {
						map[ti][tj] = '.';
						ti = i; tj = j;
						map[ti][tj] = dc[td];
					} else
						map[ti][tj] = dc[td];
				}
			}
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					sb.append(map[i][j]);
				sb.append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
