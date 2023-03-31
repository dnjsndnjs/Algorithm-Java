package algorithm;

import java.io.*;
import java.util.*;

public class PrimPqMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] g = new int[N][N];
		boolean[] v = new boolean[N];
		int[] minEdge = new int[N];
		for (int i = 0 ; i < N; i++) {
			for (int j = 0; j < N; j++) {
				g[i][j] = sc.nextInt();
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
//		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		int res = 0, cnt = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y)->Integer.compare(x[1], y[1]));
		minEdge[0] = 0;
		pq.offer(new int[] {0, 0}); // 정점, 가중치
		System.out.println(Arrays.toString(minEdge));System.out.println();
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int minVertex = cur[0];
			int min = cur[1];
			if (v[minVertex]) continue;
			v[minVertex] = true;
			res += min;
			System.out.println(Arrays.toString(v));
			System.out.println("minVertex="+minVertex);
			System.out.println("min="+min);
			System.out.println("result="+res);
			if (cnt++ == N-1) break;
			for (int j = 0; j < N; j++) {
				if (!v[j] && g[minVertex][j] != 0 && minEdge[j] > g[minVertex][j]) {
					minEdge[j] = g[minVertex][j];
					pq.offer(new int[] {j, g[minVertex][j]});
				}
			}
			System.out.println(Arrays.toString(minEdge));System.out.println();
		}
		System.out.println(res);
		sc.close();
	}
}
