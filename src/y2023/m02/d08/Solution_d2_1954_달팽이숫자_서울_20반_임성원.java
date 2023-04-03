package y2023.m02.d08;

import java.io.*;

public class Solution_d2_1954_달팽이숫자_서울_20반_임성원 {
	static final int[] dr = { 0, 1, 0, -1 };
	static final int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] ans = new int[N][N];

			int i = 0;
			int d = 0;
			int r = 0;
			int c = 0;
			while (i < N * N) {
				ans[r][c] = ++i;
				r += dr[d];
				c += dc[d];
				if (r < 0 || r >= N || c < 0 || c >= N || ans[r][c] != 0) {
					r -= dr[d];
					c -= dc[d];
					// d = (d+1) % 4;
					d = (d + 1) & 3;
					r += dr[d];
					c += dc[d];
				}
			}
			sb.append("#").append(tc).append("\n");
			for (int[] an : ans) {
				for (int a : an)
					sb.append(a + " ");
				sb.setLength(sb.length() - 1);
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
		br.close();
	}
}
