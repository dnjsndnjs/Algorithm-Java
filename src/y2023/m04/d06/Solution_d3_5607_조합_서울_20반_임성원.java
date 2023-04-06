package y2023.m04.d06;

import java.io.*;
import java.util.*;

public class Solution_d3_5607_조합_서울_20반_임성원 {
	static final int P = 12_3456_7891;

	static long[] fac = new long[100_0001];
	static int max;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_d3_5607.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		fac[0] = 1;
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			sb.append("#"+tc+" "+func(N, Math.min(R, N-R))+"\n");
		}
		System.out.print(sb);
		br.close();
	}

	static long func(int N, int R) {
		if (R == 0) return 1;
		if (max < N) {
			for (int i = max+1; i <= N; i++)
				fac[i] = (fac[i-1]*i)%P;
			max = N;
		}
		long res = (fac[N]*pow(fac[R], P-2))%P;
		return (res*pow(fac[N-R], P-2))%P;
	}

	static long pow(Long x, int y) {
		if (y == 1) return x;
		long res = pow(x, y/2);
		res = (res*res)%P;
		if ((y&1)!=0)
			res = (res*x)%P;
		return res;
	}
}
