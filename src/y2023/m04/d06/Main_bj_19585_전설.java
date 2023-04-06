package y2023.m04.d06;

import java.io.*;
import java.util.*;

public class Main_bj_19585_전설 {
	static class Node {
		boolean end;
		Node[] child = new Node['z'-'a'+1];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		Node color = new Node();
		Set<String> nick = new HashSet<>();
		for (int i = 0; i < C; i++)
			insert(color, br.readLine());
		for (int i = 0; i < N; i++)
			nick.add(br.readLine());

		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			if (find(color, nick, br.readLine()))
				sb.append("Yes\n");
			else sb.append("No\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	static void insert(Node root, String carr) {
		Node node = root;
		for (int size = carr.length(), i = 0; i < size; i++) {
			int idx = carr.charAt(i)-'a';
			if (node.child[idx] == null)
				node.child[idx] = new Node();
			node = node.child[idx];
		}
		node.end = true;
	}

	static boolean find(Node root, Set<String> nick, String s) {
		int size = s.length();
		Node node = root;
		for (int i = 0; node != null;) {
			if (node.end) {
				if (nick.contains(s.substring(i))) return true;
			}
			if ( i == 1000 || i == size) break;
			node = node.child[s.charAt(i++)-'a'];
		}
		return false;
	}
}
