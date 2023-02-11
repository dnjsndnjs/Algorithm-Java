package y2023.m02.d11;

import java.io.*;
import java.util.*;

public class Main_bj_1062_가르침 {
	static final int an = 'z'-'a'+1;
	
	static int N, K, ans;
	static boolean[] learn, chars;
	static String[] words;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		learn = new boolean[an];
		chars = new boolean[an];
		words = new String[N];
		learn['a'-'a'] = true;
		learn['c'-'a'] = true;
		learn['i'-'a'] = true;
		learn['n'-'a'] = true;
		learn['t'-'a'] = true;
		K -= 5;
		
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
			int last = words[i].length() - 4;
			for (int j = 4; j < last; j++) {
				int idx = words[i].charAt(j) - 'a';
				if (learn[idx] || chars[idx]) continue;
				chars[idx] = true;
			}
		}
		if (K < 0) {
			System.out.println(0);
			System.exit(0);
		}
		if (K + 5 >= an) {
			System.out.println(N);
			System.exit(0);
		}
		ans = 0;
		subset(0, 0);
		System.out.println(ans);
		br.close();
	}

	static void subset(int cnt, int size) {
		if (cnt == an || size == K) {
			count();
			return;
		}
		if (!learn[cnt] && chars[cnt]) {
			learn[cnt] = true;
			subset(cnt+1, size+1);
			learn[cnt] = false;
		}
		subset(cnt+1, size);
	}
	
	static void count() {
		int cnt = 0;
		word:for (String word : words) {
			int last = word.length() - 4;
			for (int i = 4; i < last; i++) {
				int idx = word.charAt(i) - 'a';
				if (!learn[idx]) continue word;
			}
			cnt++;
		}
		if (ans < cnt)
			ans = cnt;
	}
}
