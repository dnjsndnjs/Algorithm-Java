package y2023.m04.d07;

import java.io.*;
import java.util.*;

public class Solution_sp_2383_점심식사시간_서울_20반_임성원__ {
	static Comparator<P> c1 = new Comparator<P>() {
		public int compare(P o1, P o2) {
			int r = Integer.compare(o1.l1, o2.l1);
			if (r == 0) r = -Integer.compare(o1.l2, o2.l2);
			return r;
		};
	};
	static Comparator<P> c2 = new Comparator<P>() {
		public int compare(P o1, P o2) {
			int r = Integer.compare(o1.l2, o2.l2);
			if (r == 0) r = -Integer.compare(o1.l1, o2.l1);
			return r;
		};
	};

	static class P {
		int i, j, l1, l2;
		P(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_sp_2383.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			// int N = Integer.parseInt(br.readLine());
			// List<P> people = new ArrayList<>(10);
			
		}
		System.out.print(sb);
		br.close();
	}
}
