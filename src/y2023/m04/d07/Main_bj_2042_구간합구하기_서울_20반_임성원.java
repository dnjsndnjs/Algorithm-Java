package y2023.m04.d07;

import java.io.*;
import java.util.*;

public class Main_bj_2042_구간합구하기_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] nums = new long[N+1], tree = new long[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Long.parseLong(br.readLine());
			update(i, nums[i], tree);
		}
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				long diff = c-nums[(int) b];
				update((int) b, diff, tree);
				nums[(int) b] = c;
			} else {
				sb.append(sum((int) c, tree)-sum((int) b-1, tree)).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}

	static long sum(int i, long[] tree) {
		long ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= -i&i;
		}
		return ans;
	}

	static void update(int i, long diff, long[] tree) {
		int N = tree.length;
		while (i < N) {
			tree[i] += diff;
			i += -i&i;
		}
	}
}
