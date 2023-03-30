package y2023.m03.d30;

import java.io.*;
import java.util.*;

public class Solution_d4_1251_하나로_서울_20반_임성원 {
	static class Bridge implements Comparable<Bridge> {
		int n;
		long len;
		Bridge(int n, long len) {
			this.n = n;
			this.len = len;
		}
		public int compareTo(Bridge o) {
			return Long.compare(this.len, o.len);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_d4_1251.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] xpos = new int[N], ypos = new int[N];
			StringTokenizer xst = new StringTokenizer(br.readLine(), " ");
			StringTokenizer yst = new StringTokenizer(br.readLine(), " ");
			double E = Double.parseDouble(br.readLine());
			for (int i = 0; i < N; i++) {
				xpos[i] = Integer.parseInt(xst.nextToken());
				ypos[i] = Integer.parseInt(yst.nextToken());
			}
			long[][] g = new long[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					long dx = xpos[i]-xpos[j];
					long dy = ypos[i]-ypos[j];
					g[i][j] = g[j][i] = dx*dx+dy*dy;
				}
			}
			long ans = Math.round(E * primPq(g, N));
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static long primPq(long[][] g, int N) {
		long res = 0, cnt = 0;
		boolean[] v = new boolean[N];
		long[] minE = new long[N];
		Arrays.fill(minE, Long.MAX_VALUE);
		PriorityQueue<Bridge> pq = new PriorityQueue<>();
		
		minE[0] = 0;
		pq.offer(new Bridge(0, 0));
		while (!pq.isEmpty()) {
			Bridge cur = pq.poll();
			int minV = cur.n;
			long min = cur.len;
			if (v[minV]) continue;
			v[minV] = true;
			res += min;
			if (cnt++ == N-1) break;
			for (int j = 0; j < N; j++) {
				if (v[j] || g[minV][j] == 0) continue;
				if (minE[j] > g[minV][j]) {
					minE[j] = g[minV][j];
					pq.offer(new Bridge(j, minE[j]));
				}
			}
		}
		return res;
	}
}
