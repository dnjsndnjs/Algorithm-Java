package y2023.m03.d03;

import java.io.*;
import java.util.*;

/*
 * 모든 점에서 dfs를 돌리면 시간 초과가 나게됨
 * 임의의 한점에서 dfs를 돌려 가장 먼 점을 찾고
 * 가장 먼점에서 dfs를 돌리면 2번의 dfs로 답을 구할 수 있음
 */

public class Main_bj_1167_트리의지름 {
	static int ans, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		List<int[]>[] g = new List[V];
		int[] cnt = new int[V];
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int f = Integer.parseInt(st.nextToken())-1;
			g[f] = new ArrayList<>();
			while (true) {
				int t = Integer.parseInt(st.nextToken())-1;
				if (t < 0) break;
				int w = Integer.parseInt(st.nextToken());
				g[f].add(new int[] {t, w});
				cnt[f]++;
			}
		}
		ans = 0;
		dfs(0, 0, g, new boolean[V]);
		dfs(max, 0, g, new boolean[V]);
		System.out.println(ans);
		br.close();
	}
	
	static void dfs(int i, int sum, List<int[]>[] g, boolean[] visit) {
		visit[i] = true;
//		System.out.println(i+" "+sum);
		for (int[] jw : g[i]) {
			int j = jw[0], w = jw[1];
			if (visit[j]) continue;
			dfs(j, sum+w, g, visit);
		}
		if (ans < sum) {
			ans = sum;
			max = i;
		}
	}
}
