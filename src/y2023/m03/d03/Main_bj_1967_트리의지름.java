package y2023.m03.d03;

import java.io.*;
import java.util.*;

public class Main_bj_1967_트리의지름 {
	static int ans, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<int[]>[] g = new List[N];
		for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			g[p].add(new int[] {c, w});
			g[c].add(new int[] {p, w});
		}
		
		ans = 0;
		dfs(0, 0, g, new boolean[N]);
		dfs(max, 0, g, new boolean[N]);
		System.out.println(ans);
		br.close();
	}
	
	static void dfs(int i, int sum, List<int[]>[] g, boolean[] v) {
		if (ans < sum) {
			ans = sum;
			max = i;
		}
		v[i] = true;
		for (int[] jw : g[i]) {
			int j = jw[0], w = jw[1];
			if (v[j]) continue;
			dfs(j, sum+w, g, v);
		}
	}
}
