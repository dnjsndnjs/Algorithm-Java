package algorithm;

import java.io.*;
import java.util.*;

public class PermMain {
	static int N = 4, R = 3, C;
	static int[] a = {1, 2, 3, 4}, b = new int[R];
	static boolean[] v = new boolean[N];
	
	static void perm(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i]) continue;
			v[i] = true;
			b[cnt] = a[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
	
	static void comb(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}
		for (int i = start; i < N; i++) {
			b[cnt] = a[i];
			comb(cnt+1, i+1);
		}
	}

	public static void main(String[] args) throws Exception {
		C = 0;
//		perm(0); // 순서중요
		comb(0, 0); // 순서무관
		System.out.println(C);
	}

}
