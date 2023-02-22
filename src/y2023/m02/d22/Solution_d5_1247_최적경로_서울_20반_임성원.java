package y2023.m02.d22;

import java.io.*;
import java.util.*;

public class Solution_d5_1247_최적경로_서울_20반_임성원 {
	static int N, ans;
	static int[] xpos, ypos;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d5_1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			xpos = new int[N+2]; ypos = new int[N+2];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N+2; i++ ) {
				xpos[i] = Integer.parseInt(st.nextToken());
				ypos[i] = Integer.parseInt(st.nextToken());
			}
			v = new boolean[N+2];
			ans = Integer.MAX_VALUE;
			perm(0, 1, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static void perm(int cnt, int idx, int sum) {
		if (sum > ans) return;
		if (cnt == N) {
			sum += Math.abs(xpos[0]-xpos[idx]) + Math.abs(ypos[0]-ypos[idx]);
			if (ans > sum) ans = sum;
			return;
		}
		for (int i = 2; i <= N+1; i++) {
			if (v[i]) continue;
			v[i] = true;
			int len = Math.abs(xpos[i]-xpos[idx]) + Math.abs(ypos[i]-ypos[idx]);
			perm(cnt+1, i, sum+len);
			v[i] = false;
		}
	}
}
