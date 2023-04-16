package study.week8;

import java.io.*;
import java.util.*;

public class boj_14725_ISW {
	static class Node {
		// 층
		int level = 0;
		// 이 노드에서 연결된 다음 층의 노드들을 저장하는 해시맵
		HashMap<String, Node> map = new HashMap<>();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Node root = new Node();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			Node node = root;
			for (int j = 0; j < M; j++) {
				String s = st.nextToken();
				// 다음 층에 s에 해당하는 먹이의 방이 없는 경우
				if (!node.map.containsKey(s)) {
					node.map.put(s, new Node());
					node.map.get(s).level = node.level+1;
				}
				node = node.map.get(s);
			}
		}
		// 출력이 많을 것 같아서 BufferedWriter 사용
		toString(root, sb);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void toString(Node node, StringBuilder sb) {
		List<String> list = new ArrayList<>(node.map.keySet());
		Collections.sort(list);
		for (String s : list) {
			for (int i = 0; i < node.level; i++)
				sb.append("--");
			sb.append(s).append("\n");
			toString(node.map.get(s), sb);
		}
	}
}
