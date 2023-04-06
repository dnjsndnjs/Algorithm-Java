package y2023.m04.d06;

import java.io.*;
import java.util.*;

public class Solution_sp_1767_프로세서연결하기_서울_20반_임성원 {
	static final int[] di = {0, 0, 1, -1}, dj = {-1, 1, 0, 0};
	static int max, ans;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_sp_1767.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int C = 0;
			int[] ci = new int[12], cj = new int[12];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0 && i != 0 && i != N-1 && j != 0 && j != N-1) {
						ci[C] = i;
						cj[C] = j;
						C++;
					}
				}
			}
			max = ans = 0;
			subs(0, 0, 0, C, ci, cj, N, map);
			sb.append(String.format("#%d %d%n", tc, ans));
		}
		System.out.print(sb);
		br.close();
	}

	static void subs(int cnt, int core, int sum, int C, int[] ci, int[] cj, int N, int[][] map) {
		if (cnt == C) {
			if (max < core) {
				max = core;
				ans = sum;
			} else if (max == core && ans > sum)
				ans = sum;
			return;
		}
		for (int d = 0; d < 4; d++) {
			int len = 0;
			int ni = ci[cnt]+di[d], nj = cj[cnt]+dj[d];
			for (; 0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] == 0;
				map[ni][nj] = 1, ni+=di[d], nj+=dj[d], len++);
			if (!(0 <= ni && ni < N && 0 <= nj && nj < N))
				subs(cnt+1, core+1, sum+len, C, ci, cj, N, map);
			for (ni-=di[d], nj-=dj[d]; ni != ci[cnt] || nj != cj[cnt];
				map[ni][nj] = 0, ni-=di[d], nj-=dj[d]);
		}
		subs(cnt+1, core, sum, C, ci, cj, N, map);
	}
}
