package y2023.m03.d22;

import java.io.*;

public class Main_bj_12904_A와B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		char[] sarr = S.toCharArray();
		char[] tarr = T.toCharArray();
		
		for (int n = tarr.length; n > sarr.length; n--) {
			char op = tarr[n-1];
			if (op == 'B') {
				for (int i = 0; i < (n-1)/2; i++) {
					tarr[i] ^= tarr[n-2-i];
					tarr[n-2-i] ^= tarr[i];
					tarr[i] ^= tarr[n-2-i];
				}
			}
//			for (int i = 0; i < n-1; i++)
//				System.out.print(tarr[i]);
//			System.out.println();
		}
		int ans = 1;
		for (int i = 0; i < sarr.length; i++) {
			if (tarr[i] != sarr[i]) {
				ans = 0;
				break;
			}
		}
		System.out.println(ans);
		br.close();
	}
}
