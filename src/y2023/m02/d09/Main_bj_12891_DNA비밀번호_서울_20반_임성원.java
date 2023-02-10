package y2023.m02.d09;

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
		dna = dna.replaceAll("A", "0");
		dna = dna.replaceAll("C", "1");
		dna = dna.replaceAll("G", "2");
		dna = dna.replaceAll("T", "3");
		
		int ans = 0;
		int p = 0;
		int l = 0;
		for (int i = 0; i < S; i++) {
			num[dna.charAt(i) - '0']++;
			if (++p < P) continue;
			boolean ok = true;
			for (int j = 0; j < 4; j++)
				if (num[j] < min[j]) ok = false;
			if (ok) ans++;
			num[dna.charAt(l++) - '0']--;
		}
		System.out.println(ans);
		br.close();
	}

}
