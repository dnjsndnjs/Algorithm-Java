package y2023.m04.d04;

import java.io.*;

public class Main_bj_1305_광고 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		char[] p = br.readLine().toCharArray();

		int[] table = new int[L];
		for (int i = 1, j = 0; i < L; i++) {
			while (j != 0 && p[i] != p[j]) j = table[j-1];
			if (p[i] == p[j]) table[i] = ++j;
		}
		System.out.println(L-table[L-1]);
		br.close();
	}
}
