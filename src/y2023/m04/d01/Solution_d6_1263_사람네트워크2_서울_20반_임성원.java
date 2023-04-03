package y2023.m04.d01;

import java.io.*;
import java.util.*;

public class Solution_d6_1263_사람네트워크2_서울_20반_임성원 {
	static final int INF = 1000_0000;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_d6_1263.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[][] dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.parseInt(st.nextToken());
					if (dist[i][j] == 0)
						dist[i][j] = INF;
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k) continue;
					for (int j = 0; j < N; j++) {
						if (i == j || j == k) continue;
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			int ans = INF;
			for (int i = 0; i < N; i++) {
				int tmp = 0;
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					tmp += dist[i][j];
				}
				if (ans > tmp)
					ans = tmp;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
