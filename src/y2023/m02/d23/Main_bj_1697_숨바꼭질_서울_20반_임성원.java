package y2023.m02.d23;

import java.io.*;
import java.util.*;

public class Main_bj_1697_숨바꼭질_서울_20반_임성원 {
	static final int R = 100_001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] pos = new int[R];
		bfs(N, K, pos);
		System.out.println(pos[K]-1);
		br.close();
	}
	
	static void bfs(int i, int K, int[] pos) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		pos[i] = 1;
		q.offer(i);
		while (!q.isEmpty()) {
			i = q.poll();
			int time = pos[i] + 1;
			for (int j = 0; j < 3; j++) {
				int ni = i;
				switch (j) {
				case 0: ni -= 1; break;
				case 1: ni += 1; break;
				case 2: ni *= 2; break;
				}
				if (!(0 <= ni && ni < R)) continue;
				if (pos[ni] != 0 && pos[ni] <= time) continue;
				pos[ni] = time;
				if (ni == K) return;
				q.offer(ni);
			}
		}
	}
}
