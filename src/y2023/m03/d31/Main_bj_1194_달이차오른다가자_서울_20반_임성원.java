package y2023.m03.d31;

import java.io.*;
import java.util.*;

public class Main_bj_1194_달이차오른다가자_서울_20반_임성원 {
	static final int[] di = {0, 0, 1, -1}, dj = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		boolean[][][] v = new boolean[H][W][Integer.parseInt("111111", 2)+1];
		Deque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < H; i++) {
			String in = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = in.charAt(j);
				if (map[i][j] == '0') {
					map[i][j] = '.';
					q.offer(new int[] {i, j, 0, 0});
				}
			}
		}
		int ans = -1;
		while (!q.isEmpty()) {
			int[] ijkl = q.poll();
			int i = ijkl[0], j = ijkl[1], k = ijkl[2], l = ijkl[3];
			if (map[i][j] == '1') {
				ans = l;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int ni = i+di[d], nj = j+dj[d], nk = k;
				if (!(0 <= ni && ni < H && 0 <= nj && nj < W) || v[ni][nj][k]) continue;
				char tmp = map[ni][nj];
				if (tmp == '#') continue;
				else if ('a' <= tmp && tmp <= 'f')
					nk |= 1<<(tmp-'a');
				else if ('A' <= tmp && tmp <= 'F')
					if ((nk&(1<<(tmp-'A'))) == 0) continue;
				v[ni][nj][nk] = true;
				q.offer(new int[] {ni, nj, nk, l+1});
			}
		}
		System.out.println(ans);
		br.close();
	}
}
