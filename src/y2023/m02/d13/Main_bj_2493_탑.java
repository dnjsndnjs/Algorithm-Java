package y2023.m02.d13;

import java.io.*;
import java.util.*;

public class Main_bj_2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] tower = new int[N];
		int[] ans = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			tower[i] = Integer.parseInt(st.nextToken());
		
		Deque<int[]> stack = new ArrayDeque<>();
		for (int i = N-1; i >= 0; i--) {
			while (!stack.isEmpty() && tower[i] >= stack.peek()[0]) {
				int[] top = stack.poll();
				ans[top[1]] = i+1;
			}
			stack.push(new int[] {tower[i], i});
		}
		for (int i = 0; i < N; i++)
			sb.append(ans[i]+" ");
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		br.close();
	}
}
