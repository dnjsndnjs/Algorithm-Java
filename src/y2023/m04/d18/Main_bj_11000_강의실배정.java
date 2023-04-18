package y2023.m04.d18;

import java.io.*;
import java.util.*;

public class Main_bj_11000_강의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] lect = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			lect[i][0] = Integer.parseInt(st.nextToken());
			lect[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(lect, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				int r = Integer.compare(o1[0], o2[0]);
				if (r == 0) r = Integer.compare(o1[1], o2[1]);
				return r;
			}
		});
		PriorityQueue<Integer> pq = new PriorityQueue<>(N);
		for (int i = 0; i < N; i++) {
			int s = lect[i][0], e = lect[i][1];
			if (!pq.isEmpty() && pq.peek() <= s) {
				pq.poll();
				pq.offer(e);
			} else {
				pq.offer(e);
			}
		}
		System.out.println(pq.size());
		br.close();
	}
}
