package swExpert;

import java.util.*;
import java.io.*;

public class Main_bj_14889_스타트와링크_서울_20반_임성원 {
	static int N;
	static int res = Integer.MAX_VALUE;
	static int[][] S;
	static int[] visit;
	
	static void backtracking(int d, int n) {
		if (d == N/2) {
			calc();
			return;
		}
		if (n > N) {
			return;
		}
		for(int i = n+1; i < N+1; i++) {
			visit[i] = 1;
			backtracking(d+1, i);
			visit[i] = 0;
		}
	}

	static void calc() {
		int[] score = new int[2];
		for (int i = 1; i < N; i++) {
			for (int j = i+1; j < N+1; j++) {
				if (visit[i] == visit[j]) {
					score[visit[i]] += S[i][j] + S[j][i];
				}
			}
		}
		int diff = Math.abs(score[0] - score[1]);
		if (diff < res) res = diff;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		S = new int[N+1][N+1];
		visit = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N+1; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		backtracking(0, 0);
		System.out.println(res);
		br.close();
	}
}
