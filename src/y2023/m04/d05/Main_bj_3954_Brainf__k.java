package y2023.m04.d05;

import java.io.*;
import java.util.*;

public class Main_bj_3954_Brainf__k {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		while (TC--> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			char[] code = br.readLine().toCharArray();
			char[] input = br.readLine().toCharArray();
			int[] mem = new int[M];
			int[] jump = new int[C];
			Deque<Integer> s = new ArrayDeque<>();
			for (int i = 0; i < C; i++) {
				if (code[i] == '[') s.push(i); else
				if (code[i] == ']') {
					jump[i] = s.pop();
					jump[jump[i]] = i;
				}
			}

			int ml = 0;
			for (int cp = 0, mp = 0, ip = 0, t = 0; cp < C && t < 100_000_000; cp++, t++) {
				char op = code[cp];
				switch (op) {
				case '-': mem[mp]=(mem[mp]-1)&255; break;
				case '+': mem[mp]=(mem[mp]+1)&255; break;
				case '<': mp--; if (mp < 0) mp = M-1; break;
				case '>': mp++; if (mp == M) mp = 0; break;
				case '[': if (mem[mp] == 0) cp = jump[cp]; break;
				case ']':
					if (mem[mp] != 0) {
						if (t > 50_000_000 && ml < cp) ml = cp;
						cp = jump[cp];
					} break;
				case ',':
					if (ip < I) mem[mp] = input[ip++];
					else mem[mp] = 255;
				}
			}
			if (ml != 0)
				sb.append("Loops "+jump[ml]+" "+ml+"\n");
			else
				sb.append("Terminates\n");
		}
		System.out.print(sb);
		br.close();
	}
}
