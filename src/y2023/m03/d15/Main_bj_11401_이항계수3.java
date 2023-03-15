package y2023.m03.d15;

import java.io.*;
import java.util.*;

public class Main_bj_11401_이항계수3 {
	static final int mod = 1_000_000_007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] arr = {1, 1, 1};
		facto(N, K, arr);
		long ans = arr[2];
		ans *= power(arr[0]*arr[1], mod-2);
		ans %= mod;
		System.out.println(ans);
		br.close();
	}
	
	static void facto(int n, int k, long[] arr) {
		long num = 1;
		if (k > n-k) k = n-k;
		for (int i = 2; i <= n; i++) {
			num *= i;
			num %= mod;
			if (i == k)
				arr[0] = num;
			if (i == n-k)
				arr[1] = num;
		}
		arr[2] = num;
	}
	
	static long power(long x, int y) {
		x %= mod;
		if (y == 0) return 1;
		if (y == 1) return x;
		long res = power(x, y/2);
		res *= res;
		res %= mod;
		if (y % 2 == 1) {
			res *= x;
			res %= mod;
		}
		return res;
	}
}
