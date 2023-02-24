package y2023.m02.d24;

import java.io.*;
import java.util.*;

public class Main_bj_13023_ABCDE_서울_20반_임성원 {
	static int N, M, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<Integer>[] g = new List[N];
		for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		boolean[] v = new boolean[N];
		ans = 0;
		for (int i = 0; i < N; i++) {
			v[i] = true;
			perm(1, i, g, v);
			v[i] = false;
		}
		System.out.println(ans);
		br.close();
	}
	
	static void perm(int cnt, int i, List<Integer>[] g, boolean[] v) {
		if (ans != 0) return;
		if (cnt == 5) {
			ans = 1;
			return;
		}
		for (int j : g[i]) {
			if (v[j]) continue;
			v[j] = true;
			perm(cnt+1, j, g, v);
			v[j] = false;
		}
	}
}
