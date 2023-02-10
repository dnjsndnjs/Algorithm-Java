package y2023.m02.d08;

import java.io.*;
import java.util.*;

public class Main_bj_11660_구간합구하기5_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] nums = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++)
				nums[i][j] = nums[i-1][j] + nums[i][j-1] - nums[i-1][j-1] + Integer.parseInt(st.nextToken());
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int ans = nums[x2][y2] - nums[x1][y2] - nums[x2][y1] + nums[x1][y1];
			sb.append(ans).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
