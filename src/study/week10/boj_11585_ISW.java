package study.week10;

import java.io.*;
import java.util.*;

public class boj_11585_ISW {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		char[] P = new char[N], S = new char[2*N];
		for (int i = 0; i < N; i++) {
			P[i] = st1.nextToken().charAt(0);
			S[N+i] = S[i] = st2.nextToken().charAt(0);
		}

		int[] T = new int[N];
		for (int i = 1, j = 0; i < N; i++) {
			while (j != 0 && P[i] != P[j]) j = T[j-1];
			if (P[i] == P[j]) T[i] = ++j;
		}

		int ans = 0;
		for (int i = 0, j = 0; i-j < N; i++) {
			while (j != 0 && S[i] != P[j]) j = T[j-1];
			if (S[i] == P[j]) j++;
			if (j == N) {
				ans++;
				j = T[j-1];
			}
		}
		int r = gcd(N, ans);
		System.out.printf("%d/%d%n", ans/r, N/r);
		br.close();
	}

	static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a%b);
	}
}
