package y2023.m02.d09;

import java.io.*;

public class Main_bj_2023_신기한소수_서울_20반_임성원 {
	static int N;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i < 10; i++)
			prod(1, i);
		System.out.print(sb.toString());
		br.close();
	}
	
	static void prod(int cnt, int num) {
		if (!prime(num))
			return;
		if (cnt == N) {
			sb.append(num+"\n");
			return;
		}
		for (int i = 0; i < 10; i++) {
			prod(cnt+1, num*10 + i);
		}
	}
	
	static boolean prime(int num) {
		if (num <= 1) return false;
		int root = (int) Math.sqrt(num)+1;
		for (int i = 2; i < root; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}
