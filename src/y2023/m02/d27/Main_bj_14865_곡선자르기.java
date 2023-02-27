package y2023.m02.d27;
import java.io.*;
import java.util.*;

public class Main_bj_14865_곡선자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int px = Integer.parseInt(st.nextToken()), fx = px;
		int py = Integer.parseInt(st.nextToken()), fy = py;
		boolean first = true, minus = false;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (px == x && /*py * y < 0*/ ((py < 0 && y > 0) ||(py > 0 && y < 0))) {
				if (first && py > y) {
					first = false;
					minus = true;
				} else if (first) first = false;
				q.offer(x);
			}
			px = x; py = y;
		}
		if (px == fx && /*py * fy < 0*/ ((py < 0 && fy > 0) || (py > 0 && fy < 0)))
			q.offer(px);
		if (minus)
			q.offer(q.poll());
		
		List<int[]> list = new ArrayList<>();
		int cnt = 0;
		while (!q.isEmpty()) {
			cnt++;
			int a = q.poll(), b = q.poll();
			list.add(new int[] {a, cnt});
			list.add(new int[] {b, cnt});
		}
		list.sort((x, y) -> Integer.compare(x[0], y[0]));
		
		int out = 0, in = 0;
		boolean hasin = false;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int[] l : list) {
			if (!stack.isEmpty() && stack.peek() == l[1]) {
				stack.pop();
				if (!hasin) in++;
				if (stack.isEmpty()) out++;
				else hasin = true;
			} else {
				stack.push(l[1]);
				hasin = false;
			}
		}
		System.out.println(out+" "+in);
		br.close();
	}
}
