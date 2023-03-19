package y2023.m03.d19;

import java.io.*;
import java.util.*;

public class Main_bj_14865_곡선자르기 {
	static class Point implements Comparable<Point> {
		int x, n;
		Point(int x, int n) {
			this.x = x;
			this.n = n;
		}
		public int compareTo(Point o) {
			return Integer.compare(this.x, o.x);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int px = Integer.parseInt(st.nextToken()), sx = px;
		int py = Integer.parseInt(st.nextToken()), sy = py;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());
			if (nx == px && (ny^py) < 0)
				queue.offer(nx);
			px = nx; py = ny;
		}
		if (sx == px && (sy^py) < 0)
			queue.offer(sx);
		if (sy > 0)
			queue.offer(queue.poll());
		
		List<Point> list = new ArrayList<>();
		for (int n = 1; !queue.isEmpty(); n++) {
			list.add(new Point(queue.poll(), n));
			list.add(new Point(queue.poll(), n));
		}
		Collections.sort(list);
		
		int out = 0, in = 0;
		boolean hasin = false;
		Deque<Integer> stack = new ArrayDeque<>();
		for (Point p : list) {
			if (!stack.isEmpty() && stack.peek() == p.n) {
				stack.pop();
				if (!hasin)
					in++;
				if (stack.isEmpty())
					out++;
				hasin = true;
			} else {
				stack.push(p.n);
				hasin = false;
			}
		}
		System.out.println(out+" "+in);
		br.close();
	}
}
