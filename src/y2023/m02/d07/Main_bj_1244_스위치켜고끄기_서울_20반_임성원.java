package y2023.m02.d07;

import java.io.*;
import java.util.*;

public class Main_bj_1244_스위치켜고끄기_서울_20반_임성원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] sw = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++)
			sw[i] = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int g = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (g == 1) {
				for (int i = n; i <= N; i += n)
					sw[i] ^= 1;
			} else {
				for (int i = 0; n-i >= 1 && n+i <= N; i++) {
					if (sw[n-i] != sw[n+i])
						break;
					sw[n-i] = sw[n+i] ^= 1;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(sw[i]);
			if (i % 20 == 0)
				sb.append("\n");
			else
				sb.append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
