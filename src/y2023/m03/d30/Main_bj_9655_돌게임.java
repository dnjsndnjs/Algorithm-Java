package y2023.m03.d30;

import java.io.*;

public class Main_bj_9655_돌게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String out = "SK";
		if ((N & 1) == 0)
			out = "CY";
		System.out.println(out);
		br.close();
	}
}
