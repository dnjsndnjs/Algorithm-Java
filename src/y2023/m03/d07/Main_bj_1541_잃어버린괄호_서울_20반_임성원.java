package y2023.m03.d07;

import java.io.*;

public class Main_bj_1541_잃어버린괄호_서울_20반_임성원 {
	static int p, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		N = exp.length();
		int ans = calc(exp);
		while (p < N) {
			ans -= calc(exp);
		}
		System.out.println(ans);
		br.close();
	}
	
	static int calc(String exp) {
		int res = 0;
//		System.out.println("start: "+p);
		while (p < N) {
			int num = 0;
			int n = 0;
			while (p < N && 0 <= (n = exp.charAt(p++)-'0') && n < 10) {
				num *= 10;
				num += n;
			}
			res += num;
			if (n+'0' == '-') break;
		}
//		System.out.println("end: "+p);
//		System.out.println(res);
		return res;
	}
}
