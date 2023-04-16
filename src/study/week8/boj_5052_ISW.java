package study.week8;

import java.io.*;

public class boj_5052_ISW {
	static class Node {
		// 해당 노드가 한 전화번호의 끝인 경우 +1
		int cnt = 0;
		// 전화번호는 0~9까지 10개의 숫자로 구성됨 -> 해쉬맵을 사용하지 않아도 됨
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
					// 지금 보고 있는 전화번호가 끝나지 않았는데
					// 중간에 이미 완성된 전화번호가 있는 경우
					if (node.cnt != 0)
						ans = "NO";
				}
				node.cnt++;
				// 지금 보고 있는 전화번호가 끝났는데
				// 이후에 이어지는 전화번호가 존재하는 경우
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
