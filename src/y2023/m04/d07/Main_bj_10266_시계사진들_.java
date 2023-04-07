package y2023.m04.d07;

import java.io.*;
import java.util.*;

public class Main_bj_10266_시계사진들_ {
	static final int MD = 360_000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[MD<<1];
		int[] P = new int[MD];
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st1.nextToken());
			S[idx+MD] = S[idx] = 1;
			P[Integer.parseInt(st2.nextToken())] = 1;
		}

		int[] table = new int[MD];
		for (int i = 1, j = 0; i < MD; i++) {
			while (j != 0 && P[i] != P[j]) j = table[j-1];
			if (P[i] == P[j]) table[i] = ++j;
		}

		boolean ans = false;
		for (int i = 0, j = 0; i-j < MD; i++) {
			while (j != 0 && S[i] != P[j]) j = table[j-1];
			if (S[i] == P[j]) ++j;
			if (j == MD) {
				ans = true;
				break;
			}
		}
		System.out.println((ans ? "" : "im") + "possible");
		br.close();
	}
}
