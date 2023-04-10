package y2023.m04.d10;

import java.io.*;
import java.util.*;

public class Main_bj_2536_버스갈아타기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		Map<Integer, List<int[]>> xline = new HashMap<>();
		Map<Integer, List<int[]>> yline = new HashMap<>();
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int l = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			if (x1 == x2) {
				if (!xline.containsKey(x1)) xline.put(x1, new ArrayList<>());
				xline.get(x1).add(new int[] {l, Math.min(y1, y2), Math.max(y1, y2), x1});
			} else {
				if (!yline.containsKey(y1)) yline.put(y1, new ArrayList<>());
				yline.get(y1).add(new int[] {l, Math.min(x1, x2), Math.max(x1, x2), y1});
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int xs = Integer.parseInt(st.nextToken());
		int ys = Integer.parseInt(st.nextToken());
		int xe = Integer.parseInt(st.nextToken());
		int ye = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[k+1];
		Deque<int[]> q = new ArrayDeque<>();
		for (int[] line : xline.get(xs)) {
			if (!(line[1] <= ys && ys <= line[2])) continue;
			v[line[0]] = true;
			q.offer(line);
		}
		int ans = 0;
		while (!q.isEmpty()) {

		}
		System.out.println(ans);
		br.close();
	}
}
