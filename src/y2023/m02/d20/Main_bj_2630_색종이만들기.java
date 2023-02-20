package y2023.m02.d20;

import java.io.*;
import java.util.*;

public class Main_bj_2630_색종이만들기 {
	static int white, blue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		dq(map, 0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void dq(int[][] map, int r, int c, int N) {
		int sum = 0;
		for (int i = r; i < r+N; i++) {
			for (int j = c; j < c+N; j++)
				sum += map[i][j];
		}
		if (sum == 0)
			white++;
		else if (sum == N*N)
			blue++;
		else {
			N /= 2;
			dq(map, r, c, N);
			dq(map, r, c+N, N);
			dq(map, r+N, c, N);
			dq(map, r+N, c+N, N);
		}
	}
}
