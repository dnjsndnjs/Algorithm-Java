package y2023.m03.d28;

import java.io.*;

public class Main_bj_5052_전화번호목록 {
	static class Node {
		int cnt = 0;
		Node[] leaf = new Node[10];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			Node root = new Node();
			String ans = "YES";
			for (int i = 0; i < N; i++) {
				String in = br.readLine();
				Node node = root;
				for (int size = in.length(), j = 0; j < size; j++) {
					int tmp = in.charAt(j)-'0';
					if (node.leaf[tmp] == null)
						node.leaf[tmp] = new Node();
					node = node.leaf[tmp];
					if (node.cnt != 0)
						ans = "NO";
				}
				node.cnt++;
				for (int j = 0; j < 10; j++)
					if (node.leaf[j] != null)
						ans = "NO";
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
