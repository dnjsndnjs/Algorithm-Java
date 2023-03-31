package y2023.m03.d31;

import java.io.*;
import java.util.*;

public class Main_bj_14002_가장긴증가하는부분수열4 {
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

/*
8
1 3 4 2 5 3 4 5

10
8 2 4 3 6 11 7 10 14 5

7
1 5 6 2 3 4 7

4
10 10 10 10

5
2 3 2 4 1

6
1 5 6 2 3 4

6
1 3 5 7 2 3
*/