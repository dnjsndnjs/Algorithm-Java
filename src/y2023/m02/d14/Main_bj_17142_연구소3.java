package y2023.m02.d14;

import java.io.*;
import java.util.*;

public class Main_bj_17142_연구소3 {
	static final int[] di = {-1, 1, 0, 0};
	static final int[] dj = {0, 0, -1, 0};
	
	static int N, M, vn, ans;
	static int[][] map;
	static int[] vi, vj;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		// 2의 개수는 M보다 크거나 같고, 10보다 작거나 같은 자연수
		vi = new int[10];
		vj = new int[10];
		vn = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					map[i][j] = 0;
					vi[vn] = i;
					vj[vn] = j;
					vn++;
				}
			}
		}
	}
	
	static void comb(int cnt) {
		
	}
}
