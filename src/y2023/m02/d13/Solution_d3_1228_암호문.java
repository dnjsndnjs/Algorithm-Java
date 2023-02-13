package y2023.m02.d13;

import java.io.*;
import java.util.*;

public class Solution_d3_1228_암호문 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				st.nextToken();
				int s = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				for (int j = 0; j < n; j++) {
					list.add(s+j, Integer.parseInt(st.nextToken()));
				}
			}
			sb.append("#"+tc+" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}
