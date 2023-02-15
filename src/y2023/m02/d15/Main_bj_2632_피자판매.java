package y2023.m02.d15;

import java.io.*;
import java.util.*;

public class Main_bj_2632_피자판매 {
	static int M, N, S, ans;
	static int[] A, B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		A = new int[2*M];
		B = new int[2*N];
		for (int i = 0; i < M; i++) {
			A[i] = Integer.parseInt(br.readLine());
			A[M+i] = A[i];
		}
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(br.readLine());
			B[N+i] = B[i];
		}
		ans = 0;
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(B));
		subs(1, 0, 1, 0, 0, A[0]);
		subs(1, 0, 0, 0, 1, B[0]);
		System.out.println(ans);
	}
	
	// A[ai] ~ A[al-1], B[bi] ~ B[bl-1] 의 합
	static void subs(int cnt, int ai, int al, int bi, int bl, int sum) {
		if (cnt == M+N) {
			if (sum == S) {
				System.out.printf("cnt:%d ai:%d al:%d bi:%d bl:%d sum:%d%n",cnt,ai,al,bi,bl,sum);
				ans++;
			}
			return;
		}
		subs(cnt+1, ai, al, bi, bl, sum);
		if (sum < S) {
			if (al-ai < M)
				subs(cnt+1, ai, al+1, bi, bl, sum+A[al]);
			if (bl-bi < N)
				subs(cnt+1, ai, al, bi, bl+1, sum+B[bl]);
		} else {
			if (ai < M)
				subs(cnt+1, ai+1, al, bi, bl, sum-A[ai]);
			if (bi < N)
				subs(cnt+1, ai, al, bi+1, bl, sum-B[bi]);
		}
	}
}
