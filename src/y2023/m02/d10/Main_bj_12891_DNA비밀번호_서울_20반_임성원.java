package y2023.m02.d10;

import java.io.*;
import java.util.*;

public class Main_bj_12891_DNA비밀번호_서울_20반_임성원 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int[] min = new int[4];
		int[] num = new int[4];
		String dna = br.readLine();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++)
			min[i] = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		int l = 0;
		for (int r = 0; r < S; r++) {
			num[acgt(dna.charAt(r))]++;
			if (r - l + 1 < P) continue;
			boolean ok = true;
			for (int i = 0; i < 4; i++) {
				if (num[i] < min[i]) {
					ok = false;
					break;
				}
			}
			if (ok) ans++;
			num[acgt(dna.charAt(l++))]--;
		}
		System.out.println(ans);
		br.close();
	}
	
	static int acgt(char c) {
		switch (c) {
		case 'A': return 0;
		case 'C': return 1;
		case 'G': return 2;
		case 'T': return 3;
		}
		return -1;
	}
}
