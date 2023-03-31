package algorithm;

import java.io.*;
import java.util.*;

public class TopologySortTest {
	static class Node {
		int vertex;
		Node link;
		Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	static int N, M;
	static int[] inDegree;
	static Node[] adjList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N+1];
		inDegree = new int[N+1];
		
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}
		
		ArrayList<Integer> list = topologySort();
		if (list.size() == N) {
			for (int v: list)
				System.out.print(v+" ");
			System.out.println();
		} else {
			System.out.println("cycle");
		}
		br.close();
	}
	
	static ArrayList<Integer> topologySort() {
		ArrayList<Integer> orderList = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) queue.offer(i);
		} // 진입차수가 0인 정점 큐에 넣기
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			orderList.add(cur);
			// 현재 정점 기준으로 인접정점 처리
			for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
				if (--inDegree[temp.vertex] == 0)
					queue.offer(temp.vertex);
			}
		}
		return orderList;
	}
}
