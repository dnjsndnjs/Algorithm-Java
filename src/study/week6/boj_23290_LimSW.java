package study.week6;

import java.io.*;
import java.util.*;

public class boj_23290_LimSW {
	static final int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static final int[] di = {-1, 0, 1, 0};
	static final int[] dj = {0, -1, 0, 1};
	static final int N = 4;
	
	static int max;
	static int[] root;
	
	static class Shark {
		int x, y, d;
		Shark() {};
		Shark(Shark s){
			this.x = s.x;
			this.y = s.y;
			this.d = s.d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int[][] blood = new int[N][N];
		List<Shark> list = new ArrayList<>(M*S);
		
		for (int i = 0; i < M; i++) {
			Shark tmp = new Shark();
			st = new StringTokenizer(br.readLine(), " ");
			tmp.x = Integer.parseInt(st.nextToken())-1;
			tmp.y = Integer.parseInt(st.nextToken())-1;
			tmp.d = Integer.parseInt(st.nextToken())-1;
			list.add(tmp);
			map[tmp.x][tmp.y]++;
		}
		st = new StringTokenizer(br.readLine(), " ");
		int sx = Integer.parseInt(st.nextToken())-1;
		int sy = Integer.parseInt(st.nextToken())-1;
		
		for (int turn = 0; turn < S; turn++) {
			List<Shark> tlist = new ArrayList<>(M);
			int[][] tmap = new int[N][N];
			for (Shark s : list) {
				Shark tmp = new Shark(s);
				for (int dd = 0; dd < 8; dd++) {
					int d = tmp.d-dd;
					if (d < 0) d += 8;
					int nx = tmp.x+dx[d], ny = tmp.y+dy[d];
					if (!(0 <= nx && nx < N && 0 <= ny && ny < N)) continue;
					if (blood[nx][ny] != 0 || (sx == nx && sy == ny)) continue;
					tmp.d = d; tmp.x = nx; tmp.y = ny;
					break;
				}
				tmap[tmp.x][tmp.y]++;
				tlist.add(tmp);
			}
			max = -1;
			root = new int[3];
			dfs(sx, sy, 0, 0, tmap, new int[3]);
			for (int i = 0; i < 3; i++) {
				sx += di[root[i]]; sy += dj[root[i]];
				if (tmap[sx][sy] != 0) {
					tmap[sx][sy] = 0;
					blood[sx][sy] = 3;
				}
			}
			for (int size = tlist.size(), i = 0; i < size; i++) {
				Shark s = tlist.get(i);
				if (tmap[s.x][s.y] == 0) continue;
				list.add(s);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] += tmap[i][j];
					if (blood[i][j] != 0) blood[i][j]--;
				}
			}
		}
		System.out.println(list.size());
		br.close();
	}
	
	static void dfs(int i, int j, int sum, int cnt, int[][] map, int[] r) {
		int tmp = map[i][j];
		if (cnt != 0) {
			sum += tmp;
			map[i][j] = 0;
		}
		if (cnt == 3) {
			if (max < sum) {
				max = sum;
				for (int k = 0; k < 3; k++)
					root[k] = r[k];
			}
			map[i][j] = tmp;
			return;
		}
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
			r[cnt] = d;
			dfs(ni, nj, sum, cnt+1, map, r);
		}
		if (cnt != 0)
			map[i][j] = tmp;
	}
}
