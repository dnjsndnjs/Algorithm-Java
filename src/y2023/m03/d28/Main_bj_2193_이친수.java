package y2023.m03.d28;

import java.io.*;

public class Main_bj_2193_이친수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long ans = 1, plus = 0;
		for (int i = 1; i < N; i++) {
			plus += ans;
			ans ^= plus;
			plus ^= ans;
			ans ^= plus;
		}
		System.out.println(ans);
		br.close();
	}
}
