package study.week9;

import java.io.*;

public class boj_16934_ISW {
	static class Node {
		int cnt;
		Node[] next = new Node['z'-'a'+1];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Node root = new Node();
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			Node node = root;
			boolean print = false;
			for (int j = 0; j < in.length(); j++) {
				int idx = in.charAt(j)-'a';
				if (node.next[idx] == null) {
					node.next[idx] = new Node();
					if (!print) {
						sb.append(in.substring(0, j+1)+"\n");
						print = true;
					}
				}
				node = node.next[idx];
			}
			node.cnt++;
			if (!print) {
				sb.append(in);
				if (node.cnt != 1) sb.append(node.cnt);
				sb.append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
