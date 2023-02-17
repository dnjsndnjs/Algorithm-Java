package y2023.m02.d17;

import java.io.*;

public class Main_bj_2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int n = N / 5;
		int r = N % 5;
		while (r % 3 != 0 && n >= 0) {
			n--;
			r += 5;
		}
		int ans = n+r/3;
		if (n < 0) ans = -1;
		System.out.println(ans);
	}
}
