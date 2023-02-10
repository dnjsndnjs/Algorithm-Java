package y2023.m02.d09;

import java.io.*;
import java.util.*;

public class Main_bj_2961_도영이가만든맛있는음식_서울_20반_임성원 {
	static int N;
	static int[] S, B;
	static boolean[] set;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		set = new boolean[N];
		for (int i = 0; i < N; i++)
			subset(i+1, S[i], B[i]);
		System.out.println(min);
		br.close();
	}
	
	static void subset(int cnt, int ssum, int bsum) {
		if (cnt == N) {
			int diff = Math.abs(ssum - bsum);
			if (min > diff)
				min = diff;
			return;
		}
		set[cnt] = true;
		subset(cnt+1, ssum, bsum);
		set[cnt] = false;
		subset(cnt+1, ssum * S[cnt], bsum + B[cnt]);
	}
}
