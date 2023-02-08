package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_16236_아기상어_서울_20반_임성원 {
	static final int[] di = {-1, 0, 0, 1};
	static final int[] dj = {0, -1, 1, 0};
	
	static int N;
	static int[][] map;
	static int curi, curj, size = 2, eat = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					curi = i;
					curj = j;
				}
			}
		}
		int ans = 0;
		List<int[]> list;
		while ((list = bfs()).size() > 0) {
			list.sort((a, b) -> {
				if (a[2] == b[2] && a[0] == b[0])
					return Integer.compare(a[1], b[1]);
				if (a[2] == b[2])
					return Integer.compare(a[0], b[0]);
				return Integer.compare(a[2], a[2]);
			});
			int[] temp = list.get(0);
			curi = temp[0]; curj = temp[1];
			int t = temp[2];
			map[curi][curj] = 9;
			ans += t;
			eat++;
			if (eat == size) {
				eat = 0;
				size++;
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	static List<int[]> bfs() {
		List<int[]> list = new LinkedList<>();
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][N];
		q.add(new int[] {curi, curj, 0});
		map[curi][curj] = 0;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int i = temp[0], j = temp[1], t = temp[2];
			if (v[i][j]) continue;
			if (map[i][j] > size) continue;
			v[i][j] = true;
			if (map[i][j] > 0 && map[i][j] < size) {
				System.out.printf("[%d %d %d] ", i, j, t);
				list.add(temp);
			}
			for (int d = 0; d < 4; d++) {
				i += di[d]; j += dj[d];
				if (i >= 0 && i < N && j >= 0 && j < N && !v[i][j] && map[i][j] <= size)
					q.add(new int[] {i, j, t+1});
				i -= di[d]; j -= dj[d];
			}
		}
		System.out.println();
		return list;
	}
}
