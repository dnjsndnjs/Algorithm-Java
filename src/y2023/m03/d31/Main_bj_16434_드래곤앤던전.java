package y2023.m03.d31;

import java.io.*;
import java.util.*;

public class Main_bj_16434_드래곤앤던전 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long atk = Integer.parseInt(st.nextToken());
		long max = 0;
		long dmg = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			long a = Integer.parseInt(st.nextToken());
			long h = Integer.parseInt(st.nextToken());
			if (t == 1) {
				long fn = (h-1)/atk;
				dmg += fn*a;
			} else {
				atk += a;
				dmg -= h;
				if (dmg < 0) dmg = 0;
			}
			if (max < dmg)
				max = dmg;
		}
		System.out.println(max+1);
		br.close();
	}
}

/*

3 3
1 1 49
2 3 1
1 3 100

8 3 
1 1 31
1 1 31
1 1 31
1 1 31
1 1 31
1 1 31
2 3 70
1 3 100
=61

*/