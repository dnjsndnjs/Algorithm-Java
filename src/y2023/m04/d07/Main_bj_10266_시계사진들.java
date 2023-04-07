package y2023.m04.d07;

import java.io.*;
import java.util.*;

public class Main_bj_10266_시계사진들 {
	static final int MD = 360_000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N<<1];
		int[] P = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st1.nextToken());
			P[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(S, 0, N);
		Arrays.sort(P);
		int tmp1 = S[0], tmp2 = P[0];
		for (int i = 1; i < N; i++) {
			S[N+i-1] = S[i-1] = S[i]-S[i-1];
			P[i-1] = P[i]-P[i-1];
		}
		S[2*N-1] = S[N-1] = tmp1+MD-S[N-1];
		P[N-1] = tmp2+MD-P[N-1];

		int[] table = new int[N];
		for (int i = 1, j = 0; i < N; i++) {
			while (j != 0 && P[i] != P[j]) j = table[j-1];
			if (P[i] == P[j]) table[i] = ++j;
		}

		boolean ans = false;
		for (int i = 0, j = 0; i-j < N; i++) {
			while (j != 0 && S[i] != P[j]) j = table[j-1];
			if (S[i] == P[j]) ++j;
			if (j == N) {
				ans = true;
				break;
			}
		}
		System.out.println((ans ? "" : "im") + "possible");
		br.close();
	}
}
