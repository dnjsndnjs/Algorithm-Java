package y2023.m02.d09;

import java.io.*;
import java.util.*;

public class Solution_d2_2001_파리퇴치_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] += map[i-1][j] + map[i][j-1] - map[i-1][j-1];
				}
			}
			int max = 0;
			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					int sum = map[i][j] - map[i-M][j] - map[i][j-M] + map[i-M][j-M];
					if (max < sum) {
						max = sum;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
