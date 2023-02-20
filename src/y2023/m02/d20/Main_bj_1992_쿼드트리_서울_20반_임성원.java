package y2023.m02.d20;

import java.io.*;

public class Main_bj_1992_쿼드트리_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = in.charAt(j) - '0';
		}
		System.out.println(dq(map, N, 0, 0));
	}
	
	static String dq(int[][] map, int N, int r, int c) {
		StringBuilder sb = new StringBuilder();
		if (N == 1) {
			sb.append(map[r][c]);
		} else {
			int M = N / 2;
			String tr = dq(map, M, r, c);
			String tl = dq(map, M, r, c+M);
			String br = dq(map, M, r+M, c);
			String bl = dq(map, M, r+M, c+M);
			if (tr.length() == 1 && tr.equals(tl) && tl.equals(br) && br.equals(bl))
				sb.append(tr);
			else
				sb.append("(").append(tr).append(tl).append(br).append(bl).append(")");
		}
		return sb.toString();
	}
}
