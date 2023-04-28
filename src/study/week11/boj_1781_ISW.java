package study.week11;

import java.io.*;
import java.util.*;

public class boj_1781_ISW {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 문제를 저장할 우선순위 큐
		// (기한 asc, 컵라면의 수 desc)으로 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>(N, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				int r = Integer.compare(o1[0], o2[0]);
				if (r == 0) r = -Integer.compare(o1[1], o2[1]);
				return r;
			}
		});
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {a, b});
		}
		// 해결한 문제를 저장할 우선순위 큐
		// (컵라면의 수)로 정렬
		PriorityQueue<int[]> sol = new PriorityQueue<>(N, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		for (int t = 1; !pq.isEmpty(); t++) {
			// 기한이 지난 문제는 스킵
			while (!pq.isEmpty() && pq.peek()[0] < t) {
				// 만약 푼 문제중에 가장 컵라면을 적게 주는 문제보다
				// 더 많은 컵라면을 주는 기한이 지난 문제가 있으면
				// 해당 문제로 교체
				if (!sol.isEmpty() && pq.peek()[1] > sol.peek()[1]) {
					sol.poll();
					sol.offer(pq.poll());
				} else {
					pq.poll();
				}
			}
			// 문제 큐가 비었는지 확인 후 푼 문제 큐에 집어넣는다
			if (pq.isEmpty()) break;
			sol.offer(pq.poll());
		}
		int ans = 0;
		while (!sol.isEmpty())
			ans += sol.poll()[1];
		System.out.println(ans);
		br.close();
	}
}
