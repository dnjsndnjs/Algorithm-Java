package y2023.m04.d06;

import java.io.*;
import java.util.*;

public class Solution_sp_2382_미생물격리_서울_20반_임성원 {
	static final int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};

	static class Virus implements Comparable<Virus> {
		int i, j, size, d;
		Virus(int i, int j, int size, int d) {
			this.i = i;
			this.j = j;
			this.size = size;
			this.d = d;
		}
		public int compareTo(Virus o) {
			return -Integer.compare(this.size, o.size);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_sp_2382.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int total = 0;

			PriorityQueue<Virus> pq = new PriorityQueue<>();
			PriorityQueue<Virus> next = new PriorityQueue<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				map[a][b] = c;
				total += c;
				pq.offer(new Virus(a, b, c, d-1));
			}

			while (M--> 0) {
				while (!pq.isEmpty()) {
					Virus v = pq.poll();
					v.size = map[v.i][v.j];
					map[v.i][v.j] = 0;

					v.i+=di[v.d]; v.j+=dj[v.d];
					if (v.i == 0 || v.i == N-1 || v.j == 0 || v.j == N-1) {
						total -= v.size;
						v.size /= 2;
						total += v.size;
						if (v.d%2==0) v.d++;
						else v.d--;
					}
					next.offer(v);
				}
				while (!next.isEmpty()) {
					Virus v = next.poll();
					if (v.size == 0) continue;
					map[v.i][v.j] += v.size;
					if (map[v.i][v.j] != v.size) continue;
					pq.offer(v);
				}
			}
			sb.append("#"+tc+" "+total+"\n");
		}
		System.out.print(sb);
		br.close();
	}
}
