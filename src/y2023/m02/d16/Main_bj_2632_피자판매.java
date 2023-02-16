package y2023.m02.d16;

import java.io.*;
import java.util.*;

/*
 * 연속적인 값의 합이 필요한 경우 누적합을 사용할 것.
 *  (투포인트가 떠올랐다면 누적합으로 다시 생각하자)
 *  
 * 값이 정렬된 상태라면 반복문에 조건을 쓰기보다
 *  binary search를 사용하여 횟수 줄이기.
 *  
 * 들어갈 값의 범위가 정해져 있다면 map을 사용하는 것보다
 *  배열을 사용하는게 더 빠르고 메모리도 적음.
 * 
 * 원형의 자료는 배열 길이를 2배로 잡고 같은 걸 중복으로 더하지 않게 범위 관리할것
 */

public class Main_bj_2632_피자판매 {
	static int M, N, S, ans;
	static int[] A, B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[2*M+1]; // 원형
		int[] B = new int[2*N+1];
		int[] Acomb = new int[S+1];
		int[] Bcomb = new int[S+1];
		
		for (int i = 1; i <= M; i++) {
			A[i] = Integer.parseInt(br.readLine());
			A[M+i] = A[i];
		}
		for (int i = 1; i <= 2*M; i++)
			A[i] += A[i-1];
		for (int i = 1; i <= N; i++) {
			B[i] = Integer.parseInt(br.readLine());
			B[N+i] = B[i];
		}
		for (int i = 1; i <= 2*N; i++)
			B[i] += B[i-1];
		
		Acomb[0] = 1; Bcomb[0] = 1;
		if (A[M] <= S) Acomb[A[M]] = 1;
		if (B[N] <= S) Bcomb[B[N]] = 1;
		for (int i = M+1; i <= 2*M; i++) {
			int p = Arrays.binarySearch(A, A[i]-S);
			if (p < 0) p = ~p;
			if (p <= i-M) p = i-M+1;
			for (int j = p; j < i; j++) Acomb[A[i]-A[j]]++;
		}
		for (int i = N+1; i <= 2*N; i++) {
			int p = Arrays.binarySearch(B, B[i]-S);
			if (p < 0) p = ~p;
			if (p <= i-N) p = i-N+1;
			for (int j = p; j < i; j++) Bcomb[B[i]-B[j]]++;
		}
		
		ans = 0;
		for (int i = 0 ; i <= S; i++) {
			ans += Acomb[i] * Bcomb[S-i];
		}
//		System.out.println(Arrays.toString(A));
//		System.out.println(Acomb);
//		System.out.println(Arrays.toString(B));
//		System.out.println(Bcomb);
		System.out.println(ans);
	}
}
