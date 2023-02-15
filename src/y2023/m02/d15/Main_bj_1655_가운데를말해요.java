package y2023.m02.d15;

import java.io.*;
import java.util.*;

public class Main_bj_1655_가운데를말해요 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> lpq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> hpq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (lpq.isEmpty())
				lpq.offer(num);
			else if (num <= lpq.peek())
				lpq.offer(num);
			else
				hpq.offer(num);
			int diff = lpq.size() - hpq.size();
			if (diff > 1)
				hpq.offer(lpq.poll());
			if (diff < 0)
				lpq.offer(hpq.poll());
			sb.append(lpq.peek()).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
