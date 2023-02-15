package y2023.m02.d15;

import java.io.*;
import java.util.*;

public class Main_bj_2667_단지번호붙이기 {
	static final int[] di = {-1, 1, 0, 0};
	static final int[] dj = {0, 0, -1, 1};
	
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = -(in.charAt(j)-'0');
		}
		for (int[] m : map) System.out.println(Arrays.toString(m));
		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] < 0) list.add(bfs(i, j, ++cnt));
			}
		}
		list.sort((o1, o2) -> Integer.compare(o1, o2));
		sb.append(cnt).append("\n");
		for (int i = 0; i < cnt; i++)
			sb.append(list.get(i)).append("\n");
		System.out.print(sb.toString());
		br.close();
		for (int[] m : map) System.out.println(Arrays.toString(m));
	}
	
	static int bfs(int i, int j, int cnt) {
		int res = 0;
		Deque<int[]> q = new ArrayDeque<>();
		map[i][j] = cnt;
		q.offer(new int[] {i, j});
		while (q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0]; j = ij[1];
			res++;
			for (int d = 0; d < 4; d++) {
				int ni = i+di[d], nj = j+dj[d];
				if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
				if (map[ni][nj] >= 0) continue;
				map[ni][nj] = cnt;
				q.offer(new int[] {ni, nj});
			}
		}
		return res;
	}
}
