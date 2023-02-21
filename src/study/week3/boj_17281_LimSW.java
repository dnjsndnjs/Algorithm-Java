package study.week3;

import java.io.*;
import java.util.*;

public class boj_17281_LimSW {
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
		// 순열
		perm(0);
		System.out.println(ans);
		br.close();
	}
	
	static void perm(int cnt) {
		if (cnt == P) {
			simul();
			return;
		}
		// 4번 타자는 1번(0)으로 고정
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
		// turn: 이닝, seq: 이번 타순, out: 아웃된 횟수, run: 베이스 위치의 주자
		int turn = 0, seq = 0, out = 0, res = 0;
		int[] run = new int[3];
		while (turn < N) {
			int hit = play[turn][player[seq++]];
			if (seq >= P) seq -= P; // <- seq %= 9
			if (hit == 0)
				out++;
			else if (hit == 4) {
				// 홈런: 나와 있는 주자 수만큼 점수에 더하고 타자의 수 1을 더함
				res++;
				for (int i = 0; i < 3; i++) {
					res += run[i];
					run[i] = 0;
				}
			} else {
				// 안타, 2루타, 3루타: 타수만큼 주자들을 앞으로 이동.
				// 홈을 밟으면 점수에 추가
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
				// 3명이 아웃되면 주자위치를 초기화하고 이닝 진행
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
