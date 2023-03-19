package study.week6;

import java.io.*;
import java.util.*;

public class boj_23290_LimSW {
	// 8방
	static final int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	// 4방
	static final int[] di = {-1, 0, 1, 0};
	static final int[] dj = {0, -1, 0, 1};
	static final int N = 4;
	
	static int max;
	static int[] root;
	
	// 물고기 클래스
	static class Fish {
		int x, y, d;
		Fish() {};
		Fish(Fish f){
			this.x = f.x;
			this.y = f.y;
			this.d = f.d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		// map: 좌표에 있는 물고기의 수
		// blood: 피냄새의 위치
		int[][] map = new int[N][N];
		int[][] blood = new int[N][N];
		// 물고기를 리스트에 저장
		List<Fish> list = new ArrayList<>(M*S);
		
		for (int i = 0; i < M; i++) {
			Fish tmp = new Fish();
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
			// 복제 + 물고기 이동
			// 임시 리스트에 지금의 물고기 목록 저장
			// 임시 맵에 좌표에 있는 물고기 숫자 저장
			List<Fish> tlist = new ArrayList<>(M);
			int[][] tmap = new int[N][N];
			for (Fish f : list) {
				// 물고기 이동
				Fish tmp = new Fish(f);
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
			// max가 0인 경우를 고려하기 위해 -1로 초기화
			max = -1;
			root = new int[3];
			// 상어 움직임
			dfs(sx, sy, 0, 0, tmap, new int[3]);
			for (int i = 0; i < 3; i++) {
				sx += di[root[i]]; sy += dj[root[i]];
				if (tmap[sx][sy] != 0) {
					tmap[sx][sy] = 0;
					blood[sx][sy] = 3;
				}
			}
			// 복제 반영
			// 리스트에 추가
			for (int size = tlist.size(), i = 0; i < size; i++) {
				Fish f = tlist.get(i);
				if (tmap[f.x][f.y] == 0) continue;
				list.add(f);
			}
			// 좌표에 물고기 숫자 추가 + blood 카운트 감소
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
		// cnt == 0: 상어의 시작 위치
		if (cnt != 0) {
			sum += tmp;
			map[i][j] = 0;
		}
		// root에 진행하는 방향을 저장
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
