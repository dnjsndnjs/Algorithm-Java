package y2023.m03.d06;

import java.io.*;

public class Solution_d3_2806_NQueen {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_2806.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int ans = recur(0, N, new int[N]);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static int recur(int cnt, int N, int[] pos) {
		if (cnt == N)
			return 1;
		int res = 0;
		col:for (int col = 0; col < N; col++) {
			for (int j = 0; j < cnt; j++) {
				if (col == pos[j]) continue col;
				if (Math.abs(cnt-j) == Math.abs(col-pos[j])) continue col;
			}
			pos[cnt] = col;
			res += recur(cnt+1, N, pos);
		}
		return res;
	}
}
