package y2023.m04.d04;

import java.io.*;

public class Main_bj_1786_찾기_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();

		int n = T.length;
		int m = P.length;
		int[] table = new int[m];
		for (int i = 1, j = 0; i < m; i++) {
			while (j != 0 && P[i] != P[j])
				j = table[j-1];
			if (P[i] == P[j])
				table[i] = ++j;
		}

		int ans = 0;
		for (int i = 0, j = 0; i < n; i++) {
			while (j != 0 && T[i] != P[j])
				j = table[j-1];
			if (T[i] == P[j]) j++;
			if (j == m) {
				ans++;
				sb.append(i-j+2).append(" ");
				j = table[j-1];
			}
		}

		System.out.println(ans);
		System.out.println(sb);
		br.close();
	}
}
