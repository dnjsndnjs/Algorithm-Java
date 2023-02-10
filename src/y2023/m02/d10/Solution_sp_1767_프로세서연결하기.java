package y2023.m02.d10;

import java.io.*;
import java.util.*;

public class Solution_sp_1767_프로세서연결하기 {
	static final int[] di = {-1, 0, 1, 0};
	static final int[] dj = {0, 1, 0, -1};
	
	static int N, C, connect, maxc, ans;
	static int[][] map; // 빈칸: 0, 코어: 1, 전선: 2, 탐색(빈칸): -1
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
					if (map[i][j] == 1) {
						corei[C] = i;
						corej[C] = j;
						C++;
					}
				}
			}
			maxc = 0;
			ans = Integer.MAX_VALUE;
			connect = 0;
			subset(0, 0);
			sb.append("#"+tc+" "+ans+"\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	static void subset(int cnt, int sum) {
		if (cnt == C) {
			if (maxc < connect) {
				maxc = connect;
				ans = sum;
			} else if (maxc == connect && ans > sum) {
				ans = sum;
			}
			return;
		}
		direction:for (int d = 0; d < 4; d++) {
			int i = corei[cnt]+di[d], j = corej[cnt]+dj[d];
			while (0 <= i && i < N && 0 <= j && j < N) {
				// 연결 불가능
				if (map[i][j] > 0) {
					continue direction;
				}
				map[i][j] = -1;
				i += di[d]; j += dj[d];
			}
			// 전선 그리기
			connect++;
			int len = 0;
			i = corei[cnt]+di[d]; j = corej[cnt]+dj[d];
			while (0 <= i && i < N && 0 <= j && j < N) {
				map[i][j] = 2;
				i += di[d]; j += dj[d];
				len++;
			}
			subset(cnt+1, sum+len);
			// 전선 지우기
			connect--;
			i = corei[cnt]+di[d]; j = corej[cnt]+dj[d];
			while (0 <= i && i < N && 0 <= j && j < N) {
				map[i][j] = 0;
				i += di[d]; j += dj[d];
			}
		}
		subset(cnt+1, sum);
	}
}
