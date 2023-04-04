package y2023.m04.d04;

import java.io.*;
import java.util.*;

public class Main_bj_2458_키순서 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] g = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			g[a][b] = 1;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (g[i][j] == 0)
						g[i][j] = g[i][k]*g[k][j];
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++)
				sum+=g[i][j]+g[j][i];
			if (sum == N-1)
				ans++;
		}
		System.out.print(ans);
		br.close();
	}
}
