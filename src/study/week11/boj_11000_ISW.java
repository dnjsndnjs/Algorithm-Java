package study.week11;

import java.io.*;
import java.util.*;

public class boj_11000_ISW {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] lect = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			lect[i][0] = Integer.parseInt(st.nextToken());
			lect[i][1] = Integer.parseInt(st.nextToken());
		}
		// 강의를 (시작시간, 종료시간)으로 정렬
		Arrays.sort(lect, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				int r = Integer.compare(o1[0], o2[0]);
				if (r == 0) r = Integer.compare(o1[1], o2[1]);
				return r;
			}
		});
		// 배정한 강의실의 종료시간을 저장할 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>(N);
		for (int i = 0; i < N; i++) {
			int s = lect[i][0], e = lect[i][1];
			// 큐의 최상단이 현재보는 강의의 시작시간보다 같거나 크면
			// 해당 강의를 진행한 강의실을 사용해도 됨
			if (!pq.isEmpty() && pq.peek() <= s) {
				pq.poll();
				pq.offer(e);
			} else {
			// 그렇지 않다면 새로운 강의실이 필요함
				pq.offer(e);
			}
		}
		// 큐의 크기 = 필요한 강의실의 최소 개수
		System.out.println(pq.size());
		br.close();
	}
}
