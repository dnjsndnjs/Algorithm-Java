package study.week10;

import java.io.*;

public class boj_4354_ISW {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String in = br.readLine(); !in.equals("."); in = br.readLine()) {
			char[] P = in.toCharArray();
			int N = P.length;
			int[] T = new int[N];
			for (int i = 1, j = 0; i < N; i++) {
				while (j != 0 && P[i] != P[j]) j = T[j-1];
				if (P[i] == P[j]) T[i] = ++j;
			}
			int ans = N-T[N-1];
			if (N%ans != 0) ans = 1;
			else ans = N/ans;
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
