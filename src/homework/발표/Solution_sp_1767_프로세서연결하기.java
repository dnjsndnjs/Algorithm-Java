package homework.발표;

import java.io.*;
import java.util.*;

public class Solution_sp_1767_프로세서연결하기 {
	static final int[] di = {-1, 0, 1, 0};
	static final int[] dj = {0, 1, 0, -1};
	
	static int N, C, maxc, ans;
	static int[][] map; // 빈칸: 0, 코어: 1, 전선: 2
	static int[] corei, corej;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_sp_1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			corei = new int[12];
			corej = new int[12];
			C = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 가장자리에 붙은 경우
					if (i == 0 || i == N - 1 || j == 0 || j == N - 1)
						continue;
					if (map[i][j] == 1) {
						corei[C] = i;
						corej[C] = j;
						C++;
					}
				}
			}
			maxc = 0;
			ans = Integer.MAX_VALUE;
			subset(0, 0, 0);
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	static void subset(int cnt, int sum, int core) {
		if (cnt == C) {
			if (maxc < core) {
				maxc = core;
				ans = sum;
			} else if (maxc == core && ans > sum) {
				ans = sum;
			}
			return;
		}
		direction:for (int d = 0; d < 4; d++) {
			int ci = corei[cnt], cj = corej[cnt];
			for (int i = ci+di[d], j = cj+dj[d];
					0 <= i && i < N && 0 <= j && j < N;
					i += di[d], j += dj[d]) {
				// 연결 불가능
				if (map[i][j] != 0)
					continue direction;
			}
			// 전선 그리기
			int len = 0;
			for (int i = ci+di[d], j = cj+dj[d];
					0 <= i && i < N && 0 <= j && j < N;
					i += di[d], j += dj[d], len++) {
				map[i][j] = 2;
			}
			subset(cnt+1, sum+len, core+1);
			// 전선 지우기
			for (int i = ci+di[d], j = cj+dj[d];
					0 <= i && i < N && 0 <= j && j < N;
					i += di[d], j += dj[d]) {
				map[i][j] = 0;
			}
		}
		subset(cnt+1, sum, core);
	}
}
