package y2023.m03.d03;

import java.io.*;
import java.util.*;

public class Main_bj_11279_최대힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				sb.append(pq.peek() != null ? pq.poll() : 0).append("\n");
			else
				pq.offer(num);
		}
		System.out.print(sb);
		br.close();
	}
}
