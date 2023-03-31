package algorithm;

import java.io.*;
import java.util.*;

public class SubsMain {
	static int N = 4, R = 3, C = 0;
	static int[] a = {1, 2, 3, 4}, b = new int[R];
	static boolean[] v = new boolean[N];
	
	static void subs(int cnt, int sum) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print((v[i] ? a[i] : "X")+" ");
			}
			System.out.println("sum="+sum);
			C++;
			return;
		}
		v[cnt] = true;
		subs(cnt+1, sum+a[cnt]);
		v[cnt] = false;
		subs(cnt+1, sum);
	}

	static void subs(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print((v[i] ? a[i] : "X")+" ");
			}
			System.out.println();
			C++;
			return;
		}
		v[cnt] = true;
		subs(cnt+1);
		v[cnt] = false;
		subs(cnt+1);
	}
	
	public static void main(String[] args) throws Exception {
		C = 0;
//		subs(0); // 2^n 부분집합(subsets, power set)
		subs(0, 0);
		System.out.println(C);
	}
}
