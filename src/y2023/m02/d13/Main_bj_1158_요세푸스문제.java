package y2023.m02.d13;

import java.io.*;
import java.util.*;

public class Main_bj_1158_요세푸스문제 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		/*
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++)
			q.offer(i);
		*/
		List<Integer> l = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			l.add(i);
		sb.append("<");
		/*
		while (!q.isEmpty()) {
			for (int i = 0; i < K-1; i++)
				q.offer(q.poll());
			sb.append(q.poll()+", ");
		}
		*/
		int idx = 0;
		int size = N;
		while (size > 0) {
			idx += K-1;
			while (idx >= size)
				idx -= size;
			sb.append(l.remove(idx)+", ");
			size--;
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
		br.close();
	}
}
