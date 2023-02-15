package y2023.m02.d15;

import java.io.*;
import java.util.*;

public class Main_bj_2563_색종이_서울_20반_임성원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		int[][] map = new int[100][100];
		for (int k = 0; k < N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (map[r+i][c+j] != 0) continue;
					map[r+i][c+j] = 1;
					ans++;
				}
			}
		}
		System.out.println(ans);
		br.close();
	}
}
