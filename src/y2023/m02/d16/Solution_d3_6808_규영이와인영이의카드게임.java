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
			int[] A = new int[9];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++)
				A[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(A);
			int[] B = new int[9];
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (Arrays.binarySearch(A, i) < 0) B[idx++] = i;
			}
			win = 0; lose = 0;
			perm(0, A, B, 0, new boolean[9]);
			sb.append("#"+tc+" "+win+" "+lose+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	static void perm(int cnt, int[] A, int[] B, int score, boolean[] v) {
		if (cnt == 9) {
			if (score > total/2)
				lose++;
			else win++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (v[i]) continue;
			v[i] = true;
			if (B[i] > A[cnt])
				perm(cnt+1, A, B, score + A[cnt] + B[i], v);
			else
				perm(cnt+1, A, B, score, v);
			v[i] = false;
		}
	}
}
