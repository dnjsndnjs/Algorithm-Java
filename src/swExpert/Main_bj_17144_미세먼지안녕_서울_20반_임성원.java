package swExpert;

import java.util.*;
import java.io.*;

public class Main_bj_17144_미세먼지안녕_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_17144.txt"));
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();

		int mc = -1, mr1 = 0, mr2 = 0;
		int total = 2;

		int[][] room = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int num = sc.nextInt();
				room[i][j] = num;
				total += num;
				if (num < 0) {
					if (mc < 0) {
						mc = j;
						mr1 = i;
					} else {
						mr2 = i;
					}
				}
//				System.out.print(num+"\t");
			}
//			System.out.println();
		}
//		System.out.println();

		for (int t = 0; t < T; t++) {
			int[][] temp = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					int dust = room[i][j];
					if (dust < 0) {
						temp[i][j] = dust;
						continue;
					}
					int d = dust / 5;
					if (i > 0 && room[i - 1][j] != -1) {
						temp[i - 1][j] += d;
						dust -= d;
					}
					if (i < R - 1 && room[i + 1][j] != -1) {
						temp[i + 1][j] += d;
						dust -= d;
					}
					if (j > 0 && room[i][j - 1] != -1) {
						temp[i][j - 1] += d;
						dust -= d;
					}
					if (j < C - 1 && room[i][j + 1] != -1) {
						temp[i][j + 1] += d;
						dust -= d;
					}
					temp[i][j] += dust;
				}
			}
//			for(int i = 0; i < R; i++) {
//				for(int j = 0; j < C; j++) {
//					System.out.print(temp[i][j]+"\t");
//				}
//				System.out.println();
//			}
//			System.out.println();

			if (mc > 0) {
				total -= temp[mr1][mc - 1] + temp[mr2][mc - 1];
			} else {
				total -= temp[mr1 - 1][mc] + temp[mr2 + 1][mc];
			}

			for (int n = mc - 1; n > 0; n--) {
				temp[mr1][n] = temp[mr1][n - 1];
				temp[mr2][n] = temp[mr2][n - 1];
			}
			if (mc > 0) {
				temp[mr1][0] = temp[mr1 - 1][0];
				temp[mr2][0] = temp[mr2 + 1][0];
			}
			for (int n = mr1 - 1; n > 0; n--) {
				temp[n][0] = temp[n - 1][0];
			}
			for (int n = mr2 + 1; n < R - 1; n++) {
				temp[n][0] = temp[n + 1][0];
			}
			for (int n = 0; n < C - 1; n++) {
				temp[0][n] = temp[0][n + 1];
				temp[R - 1][n] = temp[R - 1][n + 1];
			}
			for (int n = 0; n < mr1; n++) {
				temp[n][C - 1] = temp[n + 1][C - 1];
			}
			for (int n = R - 1; n > mr2; n--) {
				temp[n][C - 1] = temp[n - 1][C - 1];
			}
			for (int n = C - 1; n > mc + 1; n--) {
				temp[mr1][n] = temp[mr1][n - 1];
				temp[mr2][n] = temp[mr2][n - 1];
			}
			if (mc == C - 1) {
				temp[mr1 - 1][mc] = 0;
				temp[mr2 + 1][mc] = 0;
			} else {
				temp[mr1][mc + 1] = 0;
				temp[mr2][mc + 1] = 0;
			}
			room = temp;
//			for(int i = 0; i < R; i++) {
//				for(int j = 0; j < C; j++) {
//					System.out.print(room[i][j]+"\t");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(total);
	}
}
