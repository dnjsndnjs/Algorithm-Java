package algorithm;

import java.io.*;
import java.util.*;

public class DijkstraMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] g = new int[N][N];
		boolean[] v = new boolean[N];
		int[] dist = new int[N]; // 다익스트라
		for (int i = 0 ; i < N; i++) {
			for (int j = 0; j < N; j++) {
				g[i][j] = sc.nextInt();
			}
			dist[i] = Integer.MAX_VALUE;
		}
//		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		dist[0] = 0;
		System.out.println(Arrays.toString(dist));System.out.println();
		for (int i = 0; i < N; i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if (!v[j] && min > dist[j]) {
					minVertex = j;
					min = dist[j];
				}
			}
			v[minVertex] = true;
			System.out.println(Arrays.toString(v));
			System.out.println("minVertex="+minVertex);
			System.out.println("min="+min);
			if (minVertex == N-1) break;
			for (int j = 0; j < N; j++) {
//				if (!v[j] && g[minVertex][j] != 0 && dist[j] > dist[minVertex]+g[minVertex][j]) {
//					dist[j] = dist[minVertex]+g[minVertex][j];
//				}
				if (!v[j] && g[minVertex][j] != 0 && dist[j] > min+g[minVertex][j]) {
					dist[j] = min+g[minVertex][j];
				}
			}
			System.out.println(Arrays.toString(dist));System.out.println();
		}
		System.out.println(dist[N-1]);
		sc.close();
	}
}
