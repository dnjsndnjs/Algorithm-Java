package study.week10;

import java.io.*;

public class boj_1205_ISW {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] P = br.readLine().toCharArray();
		int[] T = new int[N];
		for (int i = 1, j = 0; i < N; i++) {
			while (j != 0 && P[i] != P[j]) j = T[j-1];
			if (P[i] == P[j]) T[i] = ++j;
		}
		System.out.println(N-T[N-1]);
		br.close();
	}
}
