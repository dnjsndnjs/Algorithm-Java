package y2023.m02.d08;

import java.io.*;
import java.util.*;

public class Main_bj_15652_N과M4_서울_20반_임성원 {
	static int N, M;
	static int[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		comb(0, 1);
		System.out.print(sb.toString());
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int a : arr)
				sb.append(a).append(" ");
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			arr[cnt] = i;
			comb(cnt+1, i);
		}
	}
}
