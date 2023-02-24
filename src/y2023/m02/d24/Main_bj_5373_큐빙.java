package y2023.m02.d24;

import java.io.*;
import java.util.*;

/*
면		방향
 2		 1
103		0 2
 4		 3
 5		
 */

public class Main_bj_5373_큐빙 {
	static final char[] color = {'w', 'g', 'o', 'b', 'r', 'y'};
	static final int[][] round = {
		//	 s  d  s  d  s  d  s  d
			{1, 2, 2, 3, 3, 0, 4, 1},
			{5, 0, 2, 0, 0, 0, 4, 0},
			{1, 1, 5, 3, 3, 1, 0, 1},
			{0, 2, 2, 2, 5, 2, 4, 2},
			{1, 3, 0, 3, 3, 3, 5, 1},
			{1, 0, 4, 3, 3, 2, 2, 1}
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			char[][][] cube = makeCube();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int r = 0; r < N; r++) {
				String op = st.nextToken();
				int side = 0, d = 0;
				switch (op.charAt(0)) {
				case 'U': side = 0; break;
				case 'L': side = 1; break;
				case 'B': side = 2; break;
				case 'R': side = 3; break;
				case 'F': side = 4; break;
				case 'D': side = 5; break;
				}
				if (op.charAt(1) == '-') d = 1;
//				System.out.print(op+" "+cube[side][1][1]+" "+d+" ");
				rotate(cube, side, round[side], d);
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++)
					sb.append(cube[0][i][j]);
				sb.append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
	
	static char[][][] makeCube() {
		char[][][] cube = new char[6][3][3];
		for (int c = 0; c < 6; c++) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++)
					cube[c][i][j] = color[c];
			}
		}
		return cube;
	}
	
	static void rotate(char[][][] cube, int s, int[] round, int d) {
		char[][] side = cube[s];
		for (int i = 0; i < 2; i++) {
			int r = 0, c = i, tr, tc;
			char tmp = side[r][c];
			for (int j = 0; j < 3; j++) {
				if (d == 0) {
					tr = 2-c; tc = r;
				} else {
					tr = c; tc = 2-r;
				}
				side[r][c] = side[tr][tc];
				r = tr; c = tc;
			}
			if (d == 0)
				side[i][2] = tmp;
			else
				side[2-i][0] = tmp;
		}
		if (d == 0) {
			for(int i = 2; i >= 0; i--)
				swap(cube[round[i*2]], round[i*2+1], cube[round[(i*2+2)]], round[i*2+3]);
		}
		else {
			for(int i = 0; i < 3; i++)
				swap(cube[round[i*2]], round[i*2+1], cube[round[(i*2+2)]], round[i*2+3]);
		}
	}
	
	static void swap(char[][] a, int aop, char[][] b, int bop) {
		for(int i = 0; i < 3; i++) {
			char tmp1 = 0, tmp2 = 0;
			if (aop == 0) tmp1 = a[i][0];
			if (aop == 1) tmp1 = a[0][2-i];
			if (aop == 2) tmp1 = a[2-i][2];
			if (aop == 3) tmp1 = a[2][i];
			if (bop == 0) {
				tmp2 = b[i][0];
				b[i][0] = tmp1;
			}
			if (bop == 1) {
				tmp2 = b[0][2-i];
				b[0][2-i] = tmp1;
			}
			if (bop == 2) {
				tmp2 = b[2-i][2];
				b[2-i][2] = tmp1;
			}
			if (bop == 3) {
				tmp2 = b[2][i];
				b[2][i] = tmp1;
			}
			if (aop == 0) a[i][0] = tmp2;
			if (aop == 1) a[0][2-i] = tmp2;
			if (aop == 2) a[2-i][2] = tmp2;
			if (aop == 3) a[2][i] = tmp2;
		}
	}
}
