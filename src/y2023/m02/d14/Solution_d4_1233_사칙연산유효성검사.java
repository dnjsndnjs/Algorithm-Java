package y2023.m02.d14;

import java.io.*;
import java.util.*;

public class Solution_d4_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				if (ans == 0) continue;
				int n = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				boolean isNum = '0' <= c && c <= '9';
				if (2*n <= N) {
					// parent
					if (isNum)
						ans = 0;
				} else {
					// child
					if (!isNum)
						ans = 0;
				}
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
