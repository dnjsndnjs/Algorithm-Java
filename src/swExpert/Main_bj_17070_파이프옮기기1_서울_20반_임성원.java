package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_17070_파이프옮기기1_서울_20반_임성원 {
	static final int[] dx = {0, 1, 1};
	static final int[] dy = {1, 1, 0};
	
	static int N;
	static int[][][] memo;
	static int[][] map;
	
	static int find(int x, int y, int d) {
		// 범위를 넘어가거나 벽에 닿는 경우
		if (x >= N || y >= N || map[x][y] == 1)
			return 0;
		else if (d == 1 && (map[x-1][y] == 1 || map[x][y-1] == 1))
			return 0;
		// 목표 지점에 도달하는 경우
		if (x == N-1 && y == N-1)	{
			memo[x][y][d] = 1;
			return 1;
		}
		int res = memo[x][y][d];
		// memo 값이 존재할 때
		if (res > 0)
			return res;
		// memo 값이 도달할 수 없는 경우
		else if (res < 0)
			return 0;
		// memo 값이 초기값일 때
		res += find(x+dx[d], y+dy[d], d);
		// 위로 45도
		if (d-1 >= 0)
			res += find(x+dx[d-1], y+dy[d-1], d-1);
		// 아래로 45도
		if (d+1 < 3)
			res += find(x+dx[d+1], y+dy[d+1], d+1);
		// 목표에 도달할 수 없으면 -1
		memo[x][y][d] = res != 0 ? res : -1;
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		memo = new int[N][N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(find(0, 1, 0));
	}

}
