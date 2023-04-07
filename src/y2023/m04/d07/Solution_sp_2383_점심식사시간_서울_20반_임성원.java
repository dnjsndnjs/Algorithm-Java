package y2023.m04.d07;

import java.io.*;
import java.util.*;

public class Solution_sp_2383_점심식사시간_서울_20반_임성원 {
	static class P implements Comparable<P> {
		int i, j, l;
		P(int i, int j) {
			this.i = i;
			this.j = j;
		}
		public int compareTo(P o) {
			return Integer.compare(l, o.l);
		}
		void calc(S s) {
			l = Math.abs(i-s.i)+Math.abs(j-s.j);
		}
	}

	static class S {
		int i, j, k;
		S(int i, int j, int k) {
			this.i = i;
			this.j = j;
			this.k = k;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_sp_2383.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			List<P> people = new ArrayList<>(10);
			int scnt = 0;
			S[] stair = new S[2];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (n == 1) people.add(new P(i, j));
					else if (n != 0) stair[scnt++] = new S(i, j, n);
				}
			}
			int pcnt = people.size(), bit = 1<<pcnt;
			int[][] memo = new int[2][1<<pcnt];
			subs(0, 0, pcnt, stair, people, memo);
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < bit; i++) {
				int tmp = Math.max(memo[0][i], memo[1][(bit-1)^i]);
				if (ans > tmp) ans = tmp;
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb);
		br.close();
	}

	static void subs(int cnt, int v, int N, S[] s, List<P> people, int[][] memo) {
		if (cnt == N) {
			simul(v, N, s[0], people, memo[0]);
			simul(v, N, s[1], people, memo[1]);
			return;
		}
		subs(cnt+1, v|(1<<cnt), N, s, people, memo);
		subs(cnt+1, v, N, s, people, memo);
	}

	static void simul(int v, int N, S stair, List<P> people, int[] memo) {
		if (v == 0) return;
		PriorityQueue<P> pq = new PriorityQueue<>();
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0, b = 1; i < N; i++, b<<=1) {
			if ((v&b) == 0) continue;
			P p = people.get(i);
			p.calc(stair);
			pq.offer(p);
		}
		int time = 0, k = stair.k;
		while (!pq.isEmpty() || !q.isEmpty()) {
			while (!q.isEmpty() && q.peek() <= time)
				q.poll();
			if (!pq.isEmpty() && pq.peek().l >= time) {
				time = pq.peek().l+1;
			} else if (!pq.isEmpty() && q.size() < 3) {
				pq.poll();
				q.offer(time+k);
			} else if (!q.isEmpty())
				time = q.peek();
		}
		memo[v] = time;
	}
}
