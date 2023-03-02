package study.week4;

import java.io.*;
import java.util.*;

public class boj_19238_LimSW {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
	
	// nx, ny -> 택시가 다음에 이동할 장소의 좌표
	static int N, M, F, nx, ny;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		
		// 손님의 정보를 저장
		// 손님의 위치 x,y, 목적지의 x,y
		List<int[]> people = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] tmp = new int[4];
			for (int j = 0; j < 4; j++)
				tmp[j] = Integer.parseInt(st.nextToken())-1;
			map[tmp[0]][tmp[1]] = -1;
			people.add(tmp);
		}
		
		for (int i = 0; i < M; i++) {
			// 가장 가까운 손님찾기
			int f = bfs(x, y, map, 0);
			if (f == -1) {
				F = -1;
				break;
			}
			F -= f;
			x = nx; y = ny;
			map[x][y] = 0;
			// 태운 손님의 목적지 설정
			int p = 0;
			for (p = 0; p < M-i; p++) {
				int[] tmp = people.get(p);
				if (tmp[0] == x && tmp[1] == y) {
					nx = tmp[2]; ny = tmp[3];
					break;
				}
			}
			// 손님을 태웠으므로 list에서 지우기
			people.remove(p);
			// 목적지로 이동
			f = bfs(x, y, map, 1);
			if (f == -1) {
				F = -1;
				break;
			}
			F += f;
			x = nx; y = ny;
		}
		System.out.println(F);
		br.close();
	}
	
	// 손님을 찾기 위한 bfs와 목적지에 도달하기 위한 bfs를 하나의 함수로 하기 위한 option
	// option 0: 손님을 찾을때, 1: 목적지까지의 거리를 구할때
	static int bfs(int i, int j, int[][] map, int option) {
		boolean[][] v = new boolean[N][N];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		int res = Integer.MAX_VALUE, dist = 0;
		q.offer(new int[] {i, j, dist});
		while(!q.isEmpty()) {
			int[] ijd = q.poll();
			i = ijd[0]; j = ijd[1]; dist = ijd[2];
			// 현재 보는 점이 지금 가진 연료로 도달할 수 없거나
			// 가장 가까운 손님이 있는 거리보다 멀때 break
			if (dist > F || dist > res) break;
			if (option == 0 && map[i][j] == -1) {
				// 손님을 찾고 있으면서 손님이 있는 위치에 도달했을때
				// 아직 한번도 손님을 만나적이 없으면 nx, ny 초기화
				if (res == Integer.MAX_VALUE) {
					nx = N; ny = N;
				}
				res = dist;
				if (nx > i) {
					nx = i;
					ny = j;
				} else if (nx == i && ny > j) {
					ny = j;
				}
			}
			if (option == 1 && i == nx && j == ny) {
				// 목적지를 찾아 가면서 목적지에 도달 했을때
				return dist;
			}
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) continue;
				if (v[ni][nj] || map[ni][nj] == 1) continue;
				v[ni][nj] = true;
				q.offer(new int[] {ni, nj, dist+1});
			}
		}
		// 손님을 만난적이 있으면 res값을 없다면 -1을 반환
		if (res != Integer.MAX_VALUE) return res;
		return -1;
	}
}
