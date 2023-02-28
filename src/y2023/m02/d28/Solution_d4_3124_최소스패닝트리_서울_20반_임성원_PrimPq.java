package y2023.m02.d28;

import java.io.*;
import java.util.*;

public class Solution_d4_3124_최소스패닝트리_서울_20반_임성원_PrimPq {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<int[]>[] g = new List[N+1];
			int[] minE = new int[N+1];
			for (int i = 1; i <= N; i++) {
				g[i] = new ArrayList<>();
				minE[i] = Integer.MAX_VALUE;
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				g[a].add(new int[] {b, w});
				g[b].add(new int[] {a, w});
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
			boolean[] v = new boolean[N+1];
			long sum = 0;
			int cnt = 0;
			minE[1] = 0;
			pq.offer(new int[] {1, 0});
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int minV = cur[0];
				int minW = cur[1];
				if (v[minV]) continue;
				v[minV] = true;
				sum += minW;
				if (cnt++ == N-1) break;
				for (int[] j : g[minV]) {
					if (v[j[0]] || minE[j[0]] <= j[1]) continue;
					minE[j[0]] = j[1];
					pq.offer(j);
				}
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
