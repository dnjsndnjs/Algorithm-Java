package y2023.m04.d05;

import java.io.*;
import java.util.*;

public class Main_bj_15961_회전초밥_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] belt = new int[2*N];
		int[] dish = new int[d+1];

		int res = 1;
		dish[c] = 1;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			belt[i] = belt[N+i] = num;
			if (i < k) {
				if (dish[num]++ == 0) res++;
			}
		}

		int ans = res;
		for (int i = 0; i < N; i++) {
			if (--dish[belt[i]] == 0) res--;
			if (dish[belt[i+k]]++ == 0) res++;
			if (ans < res)
				ans = res;
		}
		System.out.println(ans);
		br.close();
	}
}
