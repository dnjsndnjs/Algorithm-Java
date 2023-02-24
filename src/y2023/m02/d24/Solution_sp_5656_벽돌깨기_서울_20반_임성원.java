package y2023.m02.d24;

import java.io.*;
import java.util.*;

public class Solution_sp_5656_벽돌깨기_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
	
	static int N, W, H;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_sp_5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			
		}
		System.out.print(sb);
		br.close();
	}
	
	static void prod(int cnt, int[] ball, int[][] map) {
		if (cnt == N) {
			
			return;
		}
		for (int i = 0; i < W; i++) {
			ball[cnt] = i;
			prod(cnt+1, ball, map);
		}
	}
	
	static void simul(int[] ball, int[][] map) {
		
	}
}
