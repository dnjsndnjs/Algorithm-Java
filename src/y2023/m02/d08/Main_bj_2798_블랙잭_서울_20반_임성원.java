package y2023.m02.d08;

import java.io.*;
import java.util.*;

public class Main_bj_2798_블랙잭_서울_20반_임성원 {
	static int N, M, R = 3;
	static int[] cards;
	static int sum, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cards = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			cards[i] = Integer.parseInt(st.nextToken());
		
		sum = 0;
		comb(0, 0);
		System.out.println(ans);
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if (cnt == R) {
			if (sum > ans && sum <= M)
				ans = sum;
			return;
		}
		for (int i = start; i < N; i++) {
			sum += cards[i];
			comb(cnt+1, i+1);
			sum -= cards[i];
		}
	}
}
