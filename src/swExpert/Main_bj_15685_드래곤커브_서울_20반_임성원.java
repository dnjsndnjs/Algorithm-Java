package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_15685_드래곤커브_서울_20반_임성원 {
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, -1, 0, 1};
	
	static int[][] map = new int[101][101];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int[][] curve = new int[(1 << g) + 1][];
			curve[0] = new int[] {x, y};
			curve[1] = new int[] {x+dx[d], y+dy[d]};
			dragon(curve, 0, g);
			for (int[] A : curve) {
				x = A[0]; y = A[1];
				map[y][x] = 1;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] * map[i+1][j] * map[i][j+1] * map[i+1][j+1] != 0)
					ans++;
			}
		}
		System.out.println(ans);
	}
	
	static void dragon(int[][] curve, int g, int G) {
		if (g == G)
			return;
		int l = 1 << g;
		int[] O = curve[l];
		for (int i = 0; i < l; i++) {
			curve[(l << 1) - i] = rotation(curve[i], O);
		}
		dragon(curve, g+1, G);
	}
	
	static int[] rotation(int[] A, int[] O) {
		int x = A[0], y = A[1], a = O[0], b = O[1];
		return new int[] {-y+a+b, x-a+b};
	}
}
