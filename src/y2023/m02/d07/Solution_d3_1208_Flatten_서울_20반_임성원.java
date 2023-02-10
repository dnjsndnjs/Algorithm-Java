package y2023.m02.d07;

import java.io.*;
import java.util.*;

public class Solution_d3_1208_Flatten_서울_20반_임성원 {
	static int max = 0, min = Integer.MAX_VALUE;
	static int maxi = 0, mini = 0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_0207_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int dump = Integer.parseInt(br.readLine());
			int[] map = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				int num =Integer.parseInt(st.nextToken());
				map[i] = num;
				check(i, num);
			}
			/*
			for (int d = 0; d < dump; d++) {
				map[mini]++;
				map[maxi]--;
				min++;
				max--;
				for (int i = 0; i < 100; i++)
					check(i, map[i]);
				if (max - min <= 1)
					break;
			}
			*/
			Arrays.sort(map);
			for (int d = 0; d < dump; d++) {
				map[0]++;
				int i = 1;
				while (map[i] < map[0]) i++;
				int temp = map[0];
				map[0] = map[i-1];
				map[i-1] = temp;
				
				map[99]--;
				i = 98;
				while (map[i] > map[99]) i--;
				temp = map[99];
				map[99] = map[i+1];
				map[i+1] = temp;
			}
			
			sb.append("#").append(tc).append(" ").append(map[99]-map[0]).append("\n");
		}
		System.out.print(sb.toString());
	}

	static void check(int i, int num) {
		if (num > max) {
			max = num;
			maxi = i;
		}
		if (num < min) {
			min = num;
			mini = i;
		}
	}
}
