package y2023.m02.d27;

import java.io.*;
import java.util.*;

public class Solution_d4_1238_Contact_서울_20반_임성원 {
	static int max, ans;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			List<Integer>[] g = new List[101];
			boolean[] v = new boolean[101];
			for (int i = 1; i <= 100; i++) g[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i+=2) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				g[a].add(b);
			}
			max = 0;
			ans = 0;
			bfs(s, g, v);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static void bfs(int i, List<Integer>[] g, boolean[] v) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(new int[] {i, 0});
		while (!q.isEmpty()) {
			int[] it = q.poll();
			i = it[0];
			int t = it[1];
			if (max < t) {
				max = t;
				ans = i;
			} else if (max == t && ans < i) {
				ans = i;
			}
			for (int j : g[i]) {
				if (v[j]) continue;
				v[j] = true;
				q.offer(new int[] {j, t+1});
			}
		}
	}
}
