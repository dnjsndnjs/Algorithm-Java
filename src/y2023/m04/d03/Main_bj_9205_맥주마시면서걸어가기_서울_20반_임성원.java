package y2023.m04.d03;

import java.io.*;
import java.util.*;

public class Main_bj_9205_맥주마시면서걸어가기_서울_20반_임성원 {
	static final int INF = 1001;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] x = new int[N+2], y = new int[N+2];
			for (int i = 0; i < N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			String ans = bfs(x, y, N) ? "happy" : "sad";
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

	static boolean bfs(int[] x, int[] y, int N) {
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[N+2];
		v[0] = true;
		q.offer(0);
		while (!q.isEmpty()) {
			int i = q.poll();
			if (i == N+1) return true;
			for (int j = 1; j < N+2; j++) {
				if (v[j]) continue;
				int len = Math.abs(x[i]-x[j]) + Math.abs(y[i]-y[j]);
				if (len < INF) {
					v[j] = true;
					q.offer(j);
				}
			}
		}
		return false;
	}
}
