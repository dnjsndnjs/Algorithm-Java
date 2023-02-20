package y2023.m02.d20;

import java.io.*;
import java.util.*;

public class Solution_d4_3316_동아리실관리하기 {
	static final int big = 1_000_000_007;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_d4_3316.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			String in = br.readLine();
			int N = in.length()-1;
			int option = 0;
			if (in.charAt(0) != 'A') option = 2;
			int ans = subs(0, in, N, option);
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static int subs(int cnt, String in, int N, int option) {
		int res = 0;
		if (cnt == N) {
			switch (option) {
			case 0: res = 8; break;
			case 1: res = 4; break;
			case 2: res = 6; break;
			case 3: res = 7; break;
			}
		} else if (in.charAt(cnt) != in.charAt(cnt+1)) {
			res += 4 * subs(cnt+1, in, N, 0);
			res += 1 * subs(cnt+1, in, N, 1);
			res += 2 * subs(cnt+1, in, N, 2);
			res += 1 * subs(cnt+1, in, N, 3);
		} else {
			res += 2 * subs(cnt+1, in, N, 0);
			res += 1 * subs(cnt+1, in, N, 2);
			res += 1 * subs(cnt+1, in, N, 3);
		}
		if (res >= big) res %= big;
		return res;
	}
}
