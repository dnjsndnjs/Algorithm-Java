package y2023.m03.d02;

import java.io.*;
import java.util.*;

public class Solution_d2_14510_나무높이 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_14510.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] trees = new int[N+1];
			int max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if (max < trees[i])
					max = trees[i];
			}
			int[] diff = new int[N];
			for (int i = 0; i < N; i++) {
				diff[i] = max - trees[i];
			}
			int ans = 0, oddn = 0, even = 0;
			for (int i = 0; i < N; i++) {
				even += diff[i]/2;
				oddn += diff[i]%2;
			}
			while (oddn < even-1) {
				oddn += 2;
				even--;
			}
			for (; oddn > 0 && even > 0; oddn--, even--, ans+=2);
			if (oddn > 0) ans += oddn*2-1;
			else ans += 2*even;
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
