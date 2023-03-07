package y2023.m03.d06;

import java.io.*;

public class Main_bj_9663_NQueen {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = recur(0, N, new int[N]);
		System.out.println(ans);
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
