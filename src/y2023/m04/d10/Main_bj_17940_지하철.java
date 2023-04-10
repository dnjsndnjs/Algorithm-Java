package y2023.m04.d10;

import java.io.*;
import java.util.*;

public class Main_bj_17940_지하철 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] C = new int[N];
		List<List<int[]>> g = new ArrayList<>();
		g.add(new ArrayList<>()); g.add(new ArrayList<>());
		for (int i = 0; i < N; i++) {
			C[i] = Integer.parseInt(br.readLine());
			g.add(new ArrayList<>());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int w = Integer.parseInt(st.nextToken());
				if (w == 0) continue;
				g.get(i).add(new int[] {j, w});
				g.get(j).add(new int[] {i, w});
			}
		}
		System.out.println(dijkstra(M, N, C, g));
		br.close();
	}

	static String dijkstra(int M, int N, int[] C, List<List<int[]>> g) {
		int ans = 0, c = C[0];
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE/2);
		int[] v = new int[N];
		dist[0] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
		PriorityQueue<int[]> next = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
		pq.offer(new int[] {0, 0});
		M:while (v[M] == 0) {
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int minV = cur[0], minD = cur[1];
				if (v[minV] == ans+1) continue;
				v[minV] = ans+1;
				if (dist[minV] > minD)
					dist[minV] = minD;
				if (v[M] != 0) break M;
				for (int[] jw : g.get(minV)) {
					int j = jw[0], w = jw[1];
					if (v[j] == ans+1) continue;
					if (dist[j] > minD+w) {
						if (C[j] == c) {
							dist[j] = minD+w;
							pq.offer(new int[] {j, dist[j]});
						} else {
							next.offer(new int[] {j, minD+w});
						}
					}
				}
			}
			ans++;
			c^=1;
			PriorityQueue<int[]> tmp = pq;
			pq = next;
			next = tmp;
		}
		return ans+" "+dist[M];
	}
}
