package study.week8;

import java.io.*;
import java.util.*;

public class boj_17825_ISW {
	static int ans = 0, end = 100;
	// 갈림길 정보 하드 코딩
	static int[][] map = {
			{},
			{10, 13, 16, 19}, // 5
			{20, 22, 24},     // 10
			{30, 28, 27, 26}, // 15
			{25, 30, 35},
	};
	
	static class Token {
		// line: 지금 지나는 길, idx: 길 위의 위치
		int line, idx;
		Token() {}
		Token(Token t){
			this.line = t.line;
			this.idx = t.idx;
		}
		// 이미 말이 있는 위치에 도착하는지 확인하기 위한 함수
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
	
	// 백트래킹
	static void back(int cnt, int sum, int[] dice, Token[] t) {
		if (cnt == 10) {
			if (ans < sum)
				ans = sum;
			return;
		}
		i:for (int i = 0; i < 4; i++) {
			// 도착한 경우
			// 중복확인의 용이성을 위해 end를 100으로 설정
			if (t[i].idx == end)
				continue;
			int res = sum;
			// 복원을 위해 딥카피로 저장
			Token tmp = new Token(t[i]);
			// 갈림길 조건 검사
			if (t[i].line == 0)
				switch(t[i].idx) {
				case 5:  t[i].line = 1; t[i].idx = 0; break;
				case 10: t[i].line = 2; t[i].idx = 0; break;
				case 15: t[i].line = 3; t[i].idx = 0; break;
				}
			t[i].idx += dice[cnt];
			// 1~3번길에서 중간(25)을 넘어서는 경우
			// 4번길로 넘어가는 코드
			if (t[i].line != 0 && t[i].line != 4) {
				if (t[i].idx >= map[t[i].line].length) {
					t[i].idx -= map[t[i].line].length;
					t[i].line = 4;
				}
			}
			// 4번길에서 넘어가는 코드
			if (t[i].line == 4) {
				// 4번길에서 도착 직전칸(40)에 가는 경우와
				// 0번길에서 (40)칸에 도착하는 경우는 같은 경우
				if (t[i].idx >= 3) {
					t[i].idx += 20 - 3;
					t[i].line = 0;
				}
			}
			// 중복확인
			for (int j = 0; j < 4; j++) {
				if (i == j) continue;
				if (t[i].equal(t[j])) {
					// 중복인 경우 복원 후 continue
					t[i] = tmp;
					continue i;
				}
			}
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
			// 재귀 후 복원
			back(cnt+1, res, dice, t);
			t[i] = tmp;
		}
	}
}
