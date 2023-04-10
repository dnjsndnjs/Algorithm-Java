package y2023.m04.d10;

import java.io.*;
import java.util.*;

public class Main_bj_7432_디스크트리 {
	static class Trie {
		Map<String, Trie> child = new TreeMap<>();
		void print(int level, StringBuilder sb) {
			for (String s : child.keySet()) {
				for (int i = 0; i < level; i++) sb.append(" ");
				sb.append(s).append("\n");
				Trie next = child.get(s);
				if (next != null) next.print(level+1, sb);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Trie root = new Trie();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "\\");
			Trie node = root;
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				if (!node.child.containsKey(s)) node.child.put(s, new Trie());
				node = node.child.get(s);
			}
		}
		StringBuilder sb = new StringBuilder();
		root.print(0, sb);
		System.out.print(sb);
		br.close();
	}
}
