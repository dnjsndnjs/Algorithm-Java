package y2023.m02.d21;

import java.io.*;
import java.util.*;

public class Main_bj_17281_야구공 {
	static int N, P = 9, ans = 0;
	static int[][] play;
	static int[] player = new int[P];
	static boolean[] v = new boolean[P];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		play = new int[N][P];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < P; j++)
				play[i][j] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.println(ans);
		br.close();
	}
	
	static void perm(int cnt) {
		if (cnt == P) {
			simul();
			return;
		}
		if (cnt == 3) {
			perm(cnt+1);
			return;
		}
		for (int i = 1; i < P; i++) {
			if (v[i]) continue;
			v[i] = true;
			player[cnt] = i;
			perm(cnt+1);
			v[i] = false;
		}
	}
	
	static void simul() {
		int turn = 0, seq = 0, out = 0, res = 0;
		int[] run = new int[3];
		while (turn < N) {
			int hit = play[turn][player[seq++]];
			if (seq >= P) seq -= P;
			if (hit == 0)
				out++;
			else if (hit == 4) {
				res++;
				for (int i = 0; i < 3; i++) {
					res += run[i];
					run[i] = 0;
				}
			} else {
				for (int i = 3-1; i >= 0; i--) {
					if (run[i] == 0) continue;
					int j = i+hit;
					run[i] = 0;
					if (j >= 3) res++;
					else run[j] = 1;
				}
				run[hit-1] = 1;
			}
			if (out == 3) {
				for (int i = 0; i < 3; i++)
					run[i] = 0;
				turn++;
				out = 0;
				continue;
			}
		}
		if (ans < res)
			ans = res;
	}
}
