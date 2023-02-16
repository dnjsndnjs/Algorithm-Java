package y2023.m02.d16;

import java.io.*;
import java.util.*;

public class Solution_d3_6808_규영이와인영이의카드게임 {
	static final int total = 18 * 19 / 2;
	
	static int win, lose;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=TC; tc++) {
			int[] arr = new int[9];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			win = 0; lose = 0;
			perm(0, arr, 0, new boolean[19]);
			sb.append("#"+tc+" "+win+" "+lose+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	static void perm(int cnt, int[] arr, int score, boolean[] v) {
		if (cnt == 9) {
			if (score > total/2)
				win++;
			else lose++;
			return;
		}
		for (int i = 1; i <= 18; i++) {
			if (Arrays.binarySearch(arr, i) >= 0) continue;
			if (v[i]) continue;
			v[i] = true;
			if (i > arr[cnt])
				score += arr[cnt] + i;
			perm(cnt+1, arr, score, v);
			v[i] = false;
		}
	}
}
