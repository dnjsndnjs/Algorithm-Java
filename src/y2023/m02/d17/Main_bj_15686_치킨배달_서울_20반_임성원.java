package y2023.m02.d17;

import java.io.*;
import java.util.*;

public class Main_bj_15686_치킨배달_서울_20반_임성원 {
	static int N, M, C, H, ans;
	static int[][] cpos, hpos, spos;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// C: 치킨집의 수, H: 집의 수
		C = 0; H = 0;
		cpos = new int[13][];
		hpos = new int[2*N][];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					hpos[H++] = new int[] {i, j};
				if (num == 2 )
					cpos[C++] = new int[] {i, j};
			}
		}
		ans = Integer.MAX_VALUE;
		spos = new int[M][];
		comb(0, 0);
		System.out.println(ans);
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if (cnt == M) {
			int tmp = calc();
			if (ans > tmp)
				ans = tmp;
			return;
		}
		for (int i = start; i < C; i++) {
			spos[cnt] = cpos[i];
			comb(cnt+1, i+1);
		}
	}
	
	static int calc() {
		int sum = 0;
		for (int i = 0; i < H; i++) {
			int res = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				int tmp = Math.abs(hpos[i][0]-spos[j][0]);
				tmp += Math.abs(hpos[i][1]-spos[j][1]);
				if (res > tmp)
					res = tmp;
			}
			sum += res;
		}
		return sum;
	}
}
