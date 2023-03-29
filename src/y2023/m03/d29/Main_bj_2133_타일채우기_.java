package y2023.m03.d29;

import java.io.*;

public class Main_bj_2133_타일채우기_ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		if ((N&1)==0) {
			N /= 2;
			ans = 3;
			int sum = 4;
			for (int i = 2; i <= N; i++)
				sum += ans = sum * 2 + ans;
		}
		System.out.println(ans);
		br.close();
	}
}
