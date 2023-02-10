package swExpert;

import java.io.*;
import java.util.*;

public class Main_bj_17140_이차원배열과연산_서울_20반_임성원 {
	static int r, c, k;
	static int rlen = 3, clen = 3;
	static int[][] map = new int[100][100];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for (ans = 0; ans <= 100; ans++) {
			if (map[r][c] == k) break;
			
			int next = 0;
			// R
			int repeat = rlen;
			int opr = 0, opc = 1;
			// C
			if (rlen < clen) {
				opr = 1; opc = 0;
				repeat = clen;
			}
			for (int i = 0; i < repeat; i++) {
				int l = oper(opc*i, opr*i, opr, opc);
				if (next < l)
					next = l;
			}
			if (rlen < clen)
				rlen = next;
			else
				clen = next;
		}
		if (ans > 100) ans = -1;
		System.out.println(ans);
		br.close();
	}
	
	static int oper(int sr, int sc, int dr, int dc) {
		int len = 0;
		int[] num = new int[101];
		int repeat = clen;
		if (dr != 0) repeat = rlen;
		for (int i = 0, r = sr, c = sc; i < repeat; i++, r += dr, c += dc) {
			num[map[r][c]]++;
			map[r][c] = 0;
		}
		List<int[]> list = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			if (num[i] == 0) continue;
			list.add(new int[] {i, num[i]});
		}
		list.sort((x, y) -> {
			if (x[1] == y[1])
				return Integer.compare(x[0], y[0]);
			return Integer.compare(x[1], y[1]);
		});
		int r = sr, c = sc;
		for (int[] arr : list) {
			map[r][c] = arr[0];
			r += dr; c += dc;
			map[r][c] = arr[1];
			r += dr; c += dc;
			len += 2;
			if (r == 100 || c == 100) break;
		}
		return len;
	}
}
