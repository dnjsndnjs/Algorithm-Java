package y2023.m02.d08;

import java.io.*;
import java.util.*;

public class Main_bj_11659_구간합구하기4_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++)
			nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(nums[j]-nums[i-1]).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
