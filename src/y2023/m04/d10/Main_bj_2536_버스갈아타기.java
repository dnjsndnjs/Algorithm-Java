package y2023.m04.d10;

import java.io.*;
import java.util.*;

public class Main_bj_2536_버스갈아타기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// int m = Integer.parseInt(st.nextToken());
		// int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		int[][] line = new int[k+1][];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int l = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			if (x1 > x2) {x1^=x2; x2^=x1; x1^=x2;}
			if (y1 > y2) {y1^=y2; y2^=y1; y1^=y2;}
			line[l] = new int[] {x1, y1, x2, y2};
		}

		st = new StringTokenizer(br.readLine(), " ");
		int xs = Integer.parseInt(st.nextToken());
		int ys = Integer.parseInt(st.nextToken());
		int xe = Integer.parseInt(st.nextToken());
		int ye = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[k+1];
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= k; i++) {
			int[] bus = line[i];
			if (bus[0] <= xs && xs <= bus[2] && bus[1] <= ys && ys <= bus[3]) {
				v[i] = true;
				q.offer(i);
			}
		}
		int ans = 0;
		q:while (!q.isEmpty()) {
			ans++;
			for (int size = q.size(); size--> 0;) {
				int i = q.poll();
				int[] bus = line[i];
				if (bus[0] <= xe && xe <= bus[2] && bus[1] <= ye && ye <= bus[3]) break q;
				for (int j = 1; j <= k; j++) {
					if (v[j] || i == j) continue;
					if (cross(bus, line[j])) {
						v[j] = true;
						q.offer(j);
					}
				}
			}
		}
		System.out.println(ans);
		br.close();
	}

	static long ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		return (x1*y2+x2*y3+x3*y1)-(x2*y1+x3*y2+x1*y3);
	}

	static boolean cross(int[] a, int[] b) {
		int x1 = a[0], y1 = a[1], x2 = a[2], y2 = a[3];
		int x3 = b[0], y3 = b[1], x4 = b[2], y4 = b[3];
		long ccw123 = ccw(x1, y1, x2, y2, x3, y3);
		long ccw124 = ccw(x1, y1, x2, y2, x4, y4);
		long ccw341 = ccw(x3, y3, x4, y4, x1, y1);
		long ccw342 = ccw(x3, y3, x4, y4, x2, y2);
		if ((ccw123*ccw124) == 0 && (ccw341*ccw342) == 0){
			boolean b1 = x3 <= x2;
			if (x3 == x2) b1 = y3 <= y2;
			boolean b2 = x1 <= x4;
			if (x1 == x4) b2 = y1 <= y4;
			return b1 && b2;
		}
		return (ccw123*ccw124) <= 0 && (ccw341*ccw342) <= 0;
	}
}
