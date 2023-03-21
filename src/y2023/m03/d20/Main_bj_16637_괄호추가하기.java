package y2023.m03.d20;

import java.io.*;

public class Main_bj_16637_괄호추가하기 {
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String in = br.readLine();
		int M = N/2 + 1;
		int[] nums = new int[M];
		char[] ops = new char[M];
		for (int i = 0; i < M; i++) {
			nums[i] = in.charAt(2*i)-'0';
			if (i == M-1) continue;
			ops[i] = in.charAt(2*i+1);
		}
		ans = Integer.MIN_VALUE;
		subs(0, 0, '+', M, nums, ops);
		System.out.println(ans);
		br.close();
	}
	
	static void subs(int cnt, int sum, char op, int N, int[] nums, char[] ops) {
		if (cnt == N) {
			if (ans < sum)
				ans = sum;
			return;
		}
		subs(cnt+1, calc(op, sum, nums[cnt]), ops[cnt], N, nums, ops);
		if (cnt != N-1) {
			int tmp = calc(ops[cnt], nums[cnt], nums[cnt+1]);
			subs(cnt+2, calc(op, sum, tmp), ops[cnt+1], N, nums, ops);
		}
	}
	
	static int calc(char op, int sum, int num) {
		switch(op) {
		case '+': sum += num; break;
		case '-': sum -= num; break;
		case '*': sum *= num; break;
		}
		return sum;
	}
}
