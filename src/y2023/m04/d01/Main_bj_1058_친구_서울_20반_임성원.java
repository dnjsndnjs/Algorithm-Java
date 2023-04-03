package y2023.m04.d01;

import java.io.*;

public class Main_bj_1058_친구_서울_20반_임성원 {
	static final int INF = 10_0000_0000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < N; j++) {
				if (in.charAt(j) == 'Y')
					dist[i][j] = 1;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (dist[i][j] != 0) {
					num[i]++;
					continue;
				}
				for (int k = 0; k < N; k++) {
					if (dist[i][k]*dist[k][j] != 0) {
						num[i]++;
						break;
					}
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++)
			if (ans < num[i])
				ans = num[i];
		System.out.println(ans);
		br.close();
	}
}