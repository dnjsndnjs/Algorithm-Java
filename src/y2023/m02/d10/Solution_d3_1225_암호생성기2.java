package y2023.m02.d10;

import java.io.*;
import java.util.*;

public class Solution_d3_1225_암호생성기2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[8];
			for (int i = 0; i < 8; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int idx = 0;
			cycle:while (true) {
				for (int i = 1; i <= 5; i++) {
					arr[idx] -= i;
					if (arr[idx] <= 0) {
						arr[idx] = 0;
						break cycle;
					}
					idx = (idx + 1) & 7; // = (idx + 1) % 8;
				}
			}
			sb.append("#"+tc+" ");
			for (int i = 1; i <= 8; i++)
				sb.append(arr[(idx + i) & 7]).append(" ");
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}
