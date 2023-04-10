package y2023.m04.d10;

import java.io.*;

public class Main_bj_1205_광고 {
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
