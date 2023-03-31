package y2023.m03.d31;

import java.io.*;
import java.util.*;

public class Main_bj_12738_가장긴증가하는부분수열3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int size = 0;
		int[] C = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int p = Arrays.binarySearch(C, 0, size, num);
			if (p < 0) p = ~p;
			C[p] = num;
			if (size == p)
				size++;
		}
		System.out.println(size);
		br.close();
	}
}
