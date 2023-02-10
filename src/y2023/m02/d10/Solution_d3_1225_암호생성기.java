package y2023.m02.d10;

import java.io.*;
import java.util.*;

public class Solution_d3_1225_암호생성기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < 8; i++)
				q.offer(Integer.parseInt(st.nextToken()));
			cycle:while (true) {
				for (int i = 1; i <= 5; i++) {
					int n = q.poll();
					n -= i;
					if (n <= 0) {
						n = 0;
						q.offer(n);
						break cycle;
					}
					q.offer(n);
				}
			}
			
			sb.append("#"+tc+" ");
			for (int i = 0; i < 8; i++)
				sb.append(q.poll()+" ");
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

}
