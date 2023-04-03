package algorithm;

import java.util.*;

public class PrimMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] g = new int[N][N];
		boolean[] v = new boolean[N];
		int[] minEdge = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				g[i][j] = sc.nextInt();
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		// Arrays.fill(minEdge, Integer.MAX_VALUE);

		int res = 0, cnt = 0;
		minEdge[0] = 0;
		System.out.println(Arrays.toString(minEdge));
		System.out.println();
		for (int i = 0; i < N; i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if (!v[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			v[minVertex] = true;
			res += min;
			System.out.println(Arrays.toString(v));
			System.out.println("minVertex=" + minVertex);
			System.out.println("min=" + min);
			System.out.println("result=" + res);
			if (cnt++ == N - 1)
				break;
			for (int j = 0; j < N; j++) {
				if (!v[j] && g[minVertex][j] != 0 && minEdge[j] > g[minVertex][j]) {
					minEdge[j] = g[minVertex][j];
				}
			}
			System.out.println(Arrays.toString(minEdge));
			System.out.println();
		}
		System.out.println(res);
		sc.close();
	}
}
