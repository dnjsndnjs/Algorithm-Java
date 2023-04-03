package y2023.m02.d07;

import java.io.*;

public class Solution_d3_2805_농작물수확하기_서울_20반_임성원 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_0207.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				int k = Math.abs(N / 2 - i);
				for (int j = k; j < N - k; j++)
					ans += s.charAt(j) - '0';
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

}
