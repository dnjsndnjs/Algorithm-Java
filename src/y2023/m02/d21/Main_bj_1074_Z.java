package y2023.m02.d21;

import java.io.*;
import java.util.*;

public class Main_bj_1074_Z {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		System.out.println(dq(N, r, c ,0 ,0));
		br.close();
	}
	
	static int dq(int N, int r, int c, int i, int j) {
		if (N == 0)
			return 0;
		int res = 0;
		int half = 1 << --N, square = half << N;
		if (r >= i + half) {
			res += square << 1;
			i += half;
		}
		if (c >= j + half) {
			res += square;
			j += half;
		}
		res += dq(N, r, c, i, j);
		return res;
	}
}
