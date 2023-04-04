package y2023.m04.d04;

import java.io.*;

public class Main_bj_4353_문자열제곱 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		while (!(input = br.readLine()).equals(".")) {
			int N = input.length();
			int[] t = new int[N];
			for (int i = 1, j = 0; i < N; i++) {
				while (j != 0 && input.charAt(i) != input.charAt(j))
					j = t[j-1];
				if (input.charAt(i) == input.charAt(j))
					t[i] = ++j;
			}
			int L = N-t[N-1];
			int ans = N/L;
			if (N%L != 0) ans = 1;
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}

/* 
 * 
 * 
 * 안녕 성원아.. 키보드를 한번 써볼게 
 * ㅗㅓ호ㅓ허허허ㅛㅓㅗㅓㅗㅓ허ㅗㅗㅓㅓㅗㅗㅗㅓㅗㅓㅗㅓㅗ키가 없어서 저암ㄹ 불편하구나...
 * 
 
*/