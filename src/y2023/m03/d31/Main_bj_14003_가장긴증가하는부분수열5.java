package y2023.m03.d31;

import java.io.*;
import java.util.*;

public class Main_bj_14003_가장긴증가하는부분수열5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int size = 0;
		int[] C = new int[N];
		int[] num = new int[N];
		int[] idx = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			int p = Arrays.binarySearch(C, 0, size, num[i]);
			if (p < 0) p = ~p;
			C[p] = num[i];
			idx[i] = p;
			if (size == p)
				size++;
		}
		sb.append(size).append("\n");
		Deque<Integer> stack = new ArrayDeque<>();
		for (int p = size-1, i = N; p >= 0; p--) {
			while (--i > 0 && idx[i] != p);
			stack.push(num[i]);
		}
		sb.append(stack.pop());
		while (!stack.isEmpty())
			sb.append(" ").append(stack.pop());
		System.out.println(sb);
		br.close();
	}
}
