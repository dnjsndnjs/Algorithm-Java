package y2023.m04.d07;

import java.io.*;

public class Main_bj_3356_라디오전송 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();

		int[] table = new int[L];
		for (int i = 1, j = 0; i < L; i++) {
			while (j != 0 && S[i] != S[j]) j = table[j-1];
			if (S[i] == S[j]) table[i] = ++j;
		}
		System.out.println(L-table[L-1]);
		br.close();
	}
}
