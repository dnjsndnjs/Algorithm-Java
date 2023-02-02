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
					if (hr == next) {
						lr++;
					} else if (hr - next == -1) {
						if (lr < L) {
							hr = 0;
						} else {
							hr = next;
							lr = 1;
						}
					} else if (hr - next == 1) {
						if (lr < 0) {
							hr = 0;
						} else {
							hr = next;
							lr = -L + 1;
						}
					} else {
						hr = 0;
					}
				}
				next = map[j][i];
				if (hc > 0) {
					if (hc == next) {
						lc++;
					} else if (hc - next == -1) {
						if (lc < L) {
							hc = 0;
						} else {
							hc = next;
							lc = 1;
						}
					} else if (hc - next == 1) {
						if (lc < 0) {
							hc = 0;
						} else {
							hc = next;
							lc = -L + 1;
						}
					} else {
						hc = 0;
					}
				}
			}
			if (hr > 0 && lr >= 0)
				res++;
			if (hc > 0 && lc >= 0)
				res++;
		}
		System.out.println(res);
		br.close();
	}
}
