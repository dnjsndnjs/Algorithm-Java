package y2023.m02.d15;

import java.io.*;
import java.util.*;

public class Main_bj_11286_절댓값힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int r = Integer.compare(Math.abs(o1), Math.abs(o2));
			if (r == 0) return Integer.compare(o1, o2);
			return r;
		});
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
			else
				pq.offer(num);
		}
		System.out.print(sb.toString());
		br.close();
	}
}
