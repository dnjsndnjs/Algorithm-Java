package y2023.m02.d24;

import java.io.*;
import java.util.*;

public class Main_bj_1759_암호만들기_서울_20반_임성원 {
	static int L, C;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		char[] alpha = new char[C];
		for (int i = 0; i < C; i++)
			alpha[i] = st.nextToken().charAt(0);
		Arrays.sort(alpha);
		StringBuilder word = new StringBuilder();
		word.setLength(L);
		comb(0, 0, 0, 0, alpha, word);
		System.out.print(sb);
		br.close();
	}
	
	static void comb(int cnt, int start, int cn, int pn, char[] alpha, StringBuilder word) {
		if (cnt == L) {
			if (cn >= 2 && pn >= 1) sb.append(word.toString()).append("\n");
			return;
		}
		for (int i = start; i < C; i++) {
			int ncn = cn, npn = pn;
			switch (alpha[i]) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u': npn++; break;
			default: ncn++;
			}
			word.setCharAt(cnt, alpha[i]);
			comb(cnt+1, i+1, ncn, npn, alpha, word);
		}
	}
}
