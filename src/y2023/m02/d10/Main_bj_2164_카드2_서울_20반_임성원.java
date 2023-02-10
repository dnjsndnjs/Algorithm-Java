package y2023.m02.d10;

import java.io.*;
import java.util.*;

public class Main_bj_2164_카드2_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++)
			q.add(i);
		while (!q.isEmpty()) {
			ans = q.poll();
			if (q.isEmpty())
				break;
			q.add(q.poll());
		}
		System.out.println(ans);
		br.close();
	}
}
