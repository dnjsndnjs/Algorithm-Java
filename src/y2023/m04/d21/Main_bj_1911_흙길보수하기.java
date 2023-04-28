package y2023.m04.d21;

import java.io.*;
import java.util.*;

public class Main_bj_1911_흙길보수하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] water = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			water[i][0] = Integer.parseInt(st.nextToken());
			water[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(water, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		int last = 0, ans = 0;
		for (int i = 0; i < N; i++) {
			if (last < water[i][0]) {
				last = water[i][0];
			}
			while (last < water[i][1]) {
				last += L;
				ans++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}
