package y2023.m03.d30;

import java.io.*;
import java.util.*;

public class Main_bj_2580_스도쿠 {
	static final int N = 9;
	static final int done = Integer.parseInt("1111111110", 2);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[N][N];
		int[] check = new int[3*N];
		int blank = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 0) {
					blank++;
					continue;
				}
				map[i][j] = n;
				check[i] |= 1<<n;
				check[N+j] |= 1<<n;
				check[2*N+(i/3+(j/3)*3)] |= 1<<n;
			}
		}
		back(blank, map, check, sb);
		System.out.print(sb);
		br.close();
	}
	static boolean back(int cnt, int[][] map, int[] check, StringBuilder sb) {
		if (cnt == 0) {
			for (int i = 0; i < 3*N; i++) {
				if (check[i] != done)
					return false;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					sb.append(map[i][j]).append(" ");
				sb.append("\n");
			}
			return true;
		}
		for (int i = 0; i < N; i++) {
			if (check[i] == done) continue;
			for (int j = 0; j < N; j++) {
				if (check[N+j] == done) continue;
				if (check[2*N+(i/3+(j/3)*3)] == done) continue;
				if (map[i][j] != 0) continue;
				for (int k = 1, b = 2; k <= 9; k++, b<<=1) {
					if ((check[i]&b) != 0 || (check[N+j]&b) != 0 || (check[2*N+(i/3+(j/3)*3)]&b) != 0)
						continue;
					map[i][j] = k;
					int[] tmp = {check[i], check[N+j], check[2*N+(i/3+(j/3)*3)]};
					check[i] |= b;
					check[N+j] |= b;
					check[2*N+(i/3+(j/3)*3)] |= b;
					if (back(cnt-1, map, check, sb))
						return true;
					check[i] = tmp[0];
					check[N+j] = tmp[1];
					check[2*N+(i/3+(j/3)*3)] = tmp[2];
					map[i][j] = 0;
				}
				return false;
			}
		}
		return false;
	}
}
