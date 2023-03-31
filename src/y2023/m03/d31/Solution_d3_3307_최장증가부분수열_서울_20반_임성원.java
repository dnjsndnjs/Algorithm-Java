package y2023.m03.d31;

import java.io.*;
import java.util.*;

public class Solution_d3_3307_최장증가부분수열_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_d3_3307.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int max = 0;
			int[] C = new int[N+1];
			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());
				int p = Arrays.binarySearch(C, 0, max+1, num);
				if (p < 0) p = ~p;
				C[p] = num;
				if (max < p)
					max = p;
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
