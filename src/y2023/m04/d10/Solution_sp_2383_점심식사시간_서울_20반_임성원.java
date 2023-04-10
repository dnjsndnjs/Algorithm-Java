package y2023.m04.d10;

import java.io.*;
import java.util.*;

public class Solution_sp_2383_점심식사시간_서울_20반_임성원 {
	static int ans;

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
			int pcnt = people.size();
			ans = Integer.MAX_VALUE;
			subs(0, 0, pcnt, stair, people);
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb);
		br.close();
	}

	static void subs(int cnt, int v, int N, S[] s, List<P> people) {
		if (cnt == N) {
			int res = Math.max(simul(v, N, s[0], people), simul(v^((1<<N)-1), N, s[1], people));
			if (ans > res)
				ans = res;
			return;
		}
		subs(cnt+1, v|(1<<cnt), N, s, people);
		subs(cnt+1, v, N, s, people);
	}

	static int simul(int v, int N, S stair, List<P> people) {
		if (v == 0) return 0;
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
		return time;
	}
}
