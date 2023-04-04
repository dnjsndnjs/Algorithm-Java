package y2023.m04.d04;

import java.io.*;
import java.util.*;

public class Main_bj_1339_단어수학 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int['Z'-'A'+1];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = in.length()-1, num = 1; j >= 0; j--, num*=10)
				alpha[in.charAt(j)-'A'] += num;
		}
		Arrays.sort(alpha);
		int ans = 0;
		for (int i = 'Z'-'A', num = 9; i >= 0; i--, num--)
			ans += num*alpha[i];
		System.out.println(ans);
		br.close();
	}
}
