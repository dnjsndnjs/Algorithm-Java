package y2023.m02.d22;

import java.io.*;
import java.util.*;

public class Solution_sp_5644_무선충전_서울_20반_임성원 {
	static final int[] dx = {0, 0, 1, 0, -1}, dy = {0, -1, 0, 1, 0};
	
	static class BC {
		int x, y, c, p;
		BC(String in){
			StringTokenizer st = new StringTokenizer(in, " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_sp_5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int ax= 1, ay = 1, bx = 10, by = 10;
			int[] ap = new int[M+1], bp = new int[M+1];
			st = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) {
				ap[i] = Integer.parseInt(st.nextToken());
				bp[i] = Integer.parseInt(st2.nextToken());
			}
			BC[] charger = new BC[A];
			for (int i = 0; i < A; i++) {
				charger[i] = new BC(br.readLine());
			}
			int ans = 0;
			for (int t = 0; t <= M; t++) {
				ax += dx[ap[t]]; ay += dy[ap[t]];
				bx += dx[bp[t]]; by += dy[bp[t]];
				boolean[] ac = new boolean[A], bc = new boolean[A];
				for (int i = 0; i < A; i++) {
					if (Math.abs(ax-charger[i].x)+Math.abs(ay-charger[i].y) <= charger[i].c) ac[i] = true;
					if (Math.abs(bx-charger[i].x)+Math.abs(by-charger[i].y) <= charger[i].c) bc[i] = true;
				}
				ans += charge(A, ac, bc, charger);
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static int charge(int A, boolean[] ac, boolean[] bc, BC[] bcs) {
		int res = 0;
		for(int i = 0; i < A; i++) {
			for (int j = i; j < A; j++) {
				if (!ac[i] && !ac[j] && !bc[i] && !bc[j]) continue;
				int tmp = 0;
				if (ac[i]) tmp += bcs[i].p;
				if (bc[j] && i != j) tmp += bcs[j].p;
				if (res < tmp) res = tmp;
				tmp = 0;
				if (bc[i]) tmp += bcs[i].p;
				if (ac[j] && i != j) tmp += bcs[j].p;
				if (res < tmp) res = tmp;
			}
		}
		return res;
	}
}
