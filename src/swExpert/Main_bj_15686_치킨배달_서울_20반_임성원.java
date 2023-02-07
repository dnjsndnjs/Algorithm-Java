package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_15686_치킨배달_서울_20반_임성원 {
	static int N, M, C, H;
	static boolean[] v = new boolean[13];
	static int[][] cpos = new int[13][];
	static int[][] hpos;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		hpos = new int[2*N][];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = st.nextToken().charAt(0) - '0';
				if (num == 1)
					hpos[H++] = new int[] {i, j};
				if (num == 2) {
					cpos[C++] = new int[] {i, j};
				}
			}
		}
		
		comb(0, 0);
		System.out.println(ans);
	}
	
	static void comb(int cnt, int start) {
		if (cnt == M) {
			calc();
			return;
		}
		for (int i = start; i < C; i++) {
			v[i] = true;
			comb(cnt+1, i+1);
			v[i] = false;
		}
	}
	
	static void calc() {
		int res = 0;
		for (int h = 0; h < H; h++) {
			int home = Integer.MAX_VALUE;
			for (int c = 0; c < C; c++) {
				if (!v[c]) continue;
				int temp = Math.abs(hpos[h][0] - cpos[c][0]);
				temp += Math.abs(hpos[h][1] - cpos[c][1]);
				if (temp < home)
					home = temp;
			}
			res += home;
		}
		if (res < ans)
			ans = res;
	}
}
