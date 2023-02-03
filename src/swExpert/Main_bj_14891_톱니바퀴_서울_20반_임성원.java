package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_14891_톱니바퀴_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] gears = new int[4][8];
		int[] tops = new int[4];
		
		for (int i = 0; i < 4; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				gears[i][j] = chars[j] - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int g = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken());
			
			int[] turns = new int[4];
			turns[g] = t;
			for (int i = g-1; i >= 0; i--) {
				int g1 = (tops[i+1] + 6) % 8;
				int g2 = (tops[i] + 2) % 8;
				int v1 = gears[i+1][g1];
				int v2 = gears[i][g2];
				if (v1 == v2) break;
				turns[i] = -turns[i+1];
			}
			for (int i = g+1; i < 4; i++) {
				int g1 = (tops[i-1] + 2) % 8;
				int g2 = (tops[i] + 6) % 8;
				int v1 = gears[i-1][g1];
				int v2 = gears[i][g2];
				if (v1 == v2) break;
				turns[i] = -turns[i-1];
			}
			for (int i = 0; i < 4; i++) {
				tops[i] += -turns[i] + 8;
				tops[i] %= 8;
			}
		}

		int res = 0;
		for (int i = 0; i < 4; i++) {
			res += gears[i][tops[i]] << i;
		}
		System.out.println(res);
	}
}
