package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_14890_경사로_서울_20반_임성원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int res = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			int hr = map[i][0];
			int hc = map[0][i];
			// 높이가 일정한 길이
			int lr = 1;
			int lc = 1;
			for (int j = 1; j < N; j++) {
				int next = map[i][j];
				if (hr > 0) {
					// 높이가 일정한 경우
					if (hr == next) {
						lr++;
						// 단차가 2 이상인 경우
					} else if (Math.abs(hr - next) > 1) {
						hr = 0;
						// 아래로 내려가는 경사로를 놓을 수 없는 경우
					} else if (lr < 0) {
						hr = 0;
						// 위로 올라가는 경우
					} else if (next > hr) {
						hr = next;
						lr = -L + 1;
						// 위로 올라가는 경사로를 놓을 수 없는 경우
						if (lr < L)
							hr = 0;
						// 아래로 내려가는 경우
					} else if (next < hr) {
						hr = next;
						lr = -L + 1;
					}
				}
				next = map[j][i];
				if (hc > 0) {
					if (hc == next) {
						lc++;
					} else if (Math.abs(hc - next) > 1) {
						hc = 0;
					} else if (lc < 0) {
						hc = 0;
					} else if (next > hc) {
						hc = next;
						lc = -L + 1;
						if (lc < L)
							hc = 0;
					} else if (next < hc) {
						hc = next;
						lc = -L + 1;
					}
				}
			}
			if (hr > 0 && lr > 0)
				res++;
			if (hc > 0 && lc > 0)
				res++;
			if (hr > 0 && lr > 0)
				System.out.println("row-" + i);
			if (hc > 0 && lc > 0)
				System.out.println("col-" + i);
		}
		System.out.println(res);
		br.close();
	}
}
