package y2023.m02.d10;

import java.io.*;
import java.util.*;

public class Solution_d4_1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int ans = 1;
			ArrayDeque<Character> stack = new ArrayDeque<>();
			stack:for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				if (c == ')' || c == ']' || c == '}' || c == '>') {
					// 아스키 코드에서 () 는 1차이, [], {}, <> 는 2 차이
					if (c == ')') c += 1;
					c -= 2;
					if (!stack.isEmpty() && c == stack.peek())
						stack.pop();
					else {
						ans = 0;
						break stack;
					}
				} else
					stack.push(c);
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}
