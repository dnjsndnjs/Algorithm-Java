package y2023.m03.d29;

import java.io.*;
import java.util.*;

public class Main_bj_17825_주사위윷놀이 {
	static int ans = 0, end = 100;
	static int[][] map = {
			{},
			{10, 13, 16, 19}, // 5
			{20, 22, 24},     // 10
			{30, 28, 27, 26}, // 15
			{25, 30, 35},
	};
	
	static class Token {
		int line, idx;
		Token() {}
		Token(Token t){
			this.line = t.line;
			this.idx = t.idx;
		}
		boolean equal(Token t) {
			return this.line == t.line && this.idx == t.idx;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] dice = new int[10];
		for (int i = 0; i < 10; i++)
			dice[i] = Integer.parseInt(st.nextToken());
		Token[] tokens = new Token[4];
		for (int i = 0; i < 4; i++) tokens[i] = new Token();
		back(0, 0, dice, tokens);
		System.out.println(ans);
		br.close();
	}
	
	static void back(int cnt, int sum, int[] dice, Token[] t) {
		if (cnt == 10) {
			if (ans < sum)
				ans = sum;
			return;
		}
		i:for (int i = 0; i < 4; i++) {
			if (t[i].idx == end)
				continue;
			int res = sum;
			Token tmp = new Token(t[i]);
			if (t[i].line == 0)
				switch(t[i].idx) {
				case 5:  t[i].line = 1; t[i].idx = 0; break;
				case 10: t[i].line = 2; t[i].idx = 0; break;
				case 15: t[i].line = 3; t[i].idx = 0; break;
				}
			t[i].idx += dice[cnt];
			if (t[i].line != 0 && t[i].line != 4) {
				if (t[i].idx >= map[t[i].line].length) {
					t[i].idx -= map[t[i].line].length;
					t[i].line = 4;
				}
			}
			if (t[i].line == 4) {
				if (t[i].idx >= 3) {
					t[i].idx += 20 - 3;
					t[i].line = 0;
				}
			}
			// 중복확인
			for (int j = 0; j < 4; j++) {
				if (i == j) continue;
				if (t[i].equal(t[j])) {
					t[i] = tmp;
					continue i;
				}
			}
//			System.out.printf("%d %d %d%n", cnt, t[i].line, t[i].idx);
			// 점수계산
			if (t[i].line == 0) {
				if (t[i].idx > 20)
					t[i].idx = end;
				else
					res += t[i].idx*2;
			} else if (t[i].line == 4) {
				res += map[4][t[i].idx];
			} else
				res += map[t[i].line][t[i].idx];
			back(cnt+1, res, dice, t);
			t[i] = tmp;
		}
	}
}
