package y2023.m03.d07;

import java.io.*;
import java.util.*;

public class Solution_5658_보물상자비밀번호_서울_20반_임성원 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_5658.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Comparator<Integer> C = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return -Integer.compare(o1, o2);
			}
		};
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int M = N / 4;
			String in = br.readLine();
			in += in;
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				for (int k = 0; k < 4; k++) {
					int tmp = Integer.parseInt(in.substring(i+k*M, i+k*M+M), 16);
					int p = Collections.binarySearch(list, tmp, C);
					if (p < 0)
						list.add(~p, tmp);
				}
			}
			sb.append("#").append(tc).append(" ").append(list.get(K-1)).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
