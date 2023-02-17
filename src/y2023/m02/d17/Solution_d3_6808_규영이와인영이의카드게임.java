package y2023.m02.d17;

import java.io.*;
import java.util.*;

public class Solution_d3_6808_규영이와인영이의카드게임 {
	static final int N = 9;
	static final int total = N * (2*N+1);
	
	static int win, lose, facto;
	static {
		facto = 1;
		for (int i = 2; i <= N; i++) facto *= i;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=TC; tc++) {
			int[] A = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				A[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(A);
			int[] B = new int[N];
			int idx = 0;
			for (int i = 1; i <= 2*N; i++) {
				if (Arrays.binarySearch(A, i) < 0) B[idx++] = i;
			}
			win = 0; lose = 0;
			perm(N, A, B, 0, 0, new boolean[9], facto);
			sb.append("#"+tc+" "+win+" "+lose+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	
	static void perm(int cnt, int[] A, int[] B, int asc, int bsc, boolean[] v, int facto) {
		if (cnt == 0) {
			if (asc > bsc)
				win++;
			else lose++;
			return;
		}
		if (asc > total/2) {
			win += facto;
			return;
		}
		if (bsc > total/2) {
			lose += facto;
			return;
		}
		facto /= cnt--;
		for (int i = N-1; i >= 0; i--) {
			if (v[i]) continue;
			v[i] = true;
			if (B[i] > A[cnt])
				perm(cnt, A, B, asc, bsc + A[cnt] + B[i], v, facto);
			else
				perm(cnt, A, B, asc + A[cnt] + B[i], bsc, v, facto);
			v[i] = false;
		}
	}
}
