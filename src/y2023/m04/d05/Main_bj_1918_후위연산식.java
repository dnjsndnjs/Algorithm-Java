package y2023.m04.d05;

import java.io.*;
import java.util.*;

public class Main_bj_1918_후위연산식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] in = br.readLine().toCharArray();
		int N = in.length;
		Deque<Character> stack = new ArrayDeque<>();
		recur(0, N, in, stack);
		while (!stack.isEmpty()) sb.append(stack.pollLast());
		System.out.println(sb);
		br.close();
	}

	static int recur(int i, int N, char[] in, Deque<Character> stack) {
		Deque<Character> prev = new ArrayDeque<>();
		for (int cnt = 0; i < N; i++) {
			char cur = in[i];
			if (cur == ')')
				return i;
			if (cur == '(') {
				i = recur(i+1, N, in, stack);
				continue;
			}
			if ('A' <= cur && cur <= 'Z') {
				stack.push(cur);
				continue;
			}
			if (cur == '*' || cur =='/') {
				int tmp = cnt;
				while (!stack.isEmpty() && tmp-->0 && (stack.peek() == '+' || stack.peek() == '-'))
					prev.push(stack.pop());
			}
			if (++i < N && in[i] == '(')
				i = recur(i+1, N, in, stack);
			else stack.push(in[i]);
			stack.push(cur);
			cnt++;
			while (!prev.isEmpty())
				stack.push(prev.pop());
		}
		return i;
	}
}
