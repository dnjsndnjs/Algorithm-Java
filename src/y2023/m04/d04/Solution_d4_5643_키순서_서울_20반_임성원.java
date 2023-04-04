package y2023.m04.d04;

import java.io.*;
import java.util.*;

public class Solution_d4_5643_키순서_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_d4_5643.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[][] g = new int[N][N];
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
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
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb);
		br.close();
	}
}
