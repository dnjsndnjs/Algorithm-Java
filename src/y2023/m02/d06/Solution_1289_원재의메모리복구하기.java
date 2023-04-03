package y2023.m02.d06;

import java.io.*;

public class Solution_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_0206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			int ans = 0;
			int bit = 0;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) - '0' != bit) {
					ans++;
					bit ^= 1;
				}
			}
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}
}
