package y2023.m03.d07;

import java.io.*;
import java.util.*;

public class Main_bj_21611_마법사상어와블리자드_서울_20반_임성원 {
	static final int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static final int[] dd = {3, 1, 0, 2};
	
	static int[][] del;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int[] exp = new int[4];
		int ans = 0;
		for (int i = 1; i < 4; i++) {
			ans += i*exp[i];
		}
		System.out.println(ans);
		br.close();
	}
}
