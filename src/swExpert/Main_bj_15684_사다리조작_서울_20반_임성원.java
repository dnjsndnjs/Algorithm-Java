package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_15684_사다리조작_서울_20반_임성원 {
	static int N, M, H;
	static int[][] lines;
	static int change;
	static int ans;
	/*
	static void recur(int n) {
		if (change > 3)
			return;
		if (n == N && check()) {
			if (change < ans)
				ans = change;
			return;
		}
		System.out.println(n+" "+check());
		recur(n+1);
		for (int h = 0; h < H; h++) {
			if (lines[n][h] == 0 && lines[n+1][h] == 0) {
				lines[n][h] = 1;
				lines[n+1][h] = -1;
				change++;
				recur(n);
				change--;
				lines[n][h] = 0;
				lines[n+1][h] = 0;
			}
		}
	}
	
	static boolean check(int n) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int l : lines[n]) {
			if (!stack.isEmpty() && stack.peek() == l)
				stack.pop();
			else if (l != 0)
				stack.push(l);
		}
		return stack.isEmpty();
	}
	*/
	static void recur(int n, int cnt, int size) {
		if (cnt == size) {
			if (check()) {
				System.out.println(size);
				System.exit(0);
			}
			return;
		}
		for (int i = n; i < N; i++) {
			for (int h = 0; h < H; h++) {
				if (lines[i][h] != 0)
					continue;
				if (lines[i+1][h] != 0)
					continue;
				lines[i][h] = 1;
				lines[i+1][h] = -1;
				recur(i, cnt+1, size);
				lines[i][h] = 0;
				lines[i+1][h] = 0;
			}
		}
	}
	
	static boolean check() {
		for (int i = 1; i <= N; i++) {
			int n = i;
			for (int h = 0; h < H; h++) {
				n += lines[n][h];
			}
			if (n != i)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		lines = new int[N+1][H];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lines[b][a-1] = 1;
			lines[b+1][a-1] = -1;
		}
		
		change = 0;
		ans = 4;
		for (int i = 0; i <= 3; i++)
			recur(1, 0, i);
		System.out.println(-1);
	}
}
