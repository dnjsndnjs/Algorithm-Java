package study.week5;

import java.io.*;
import java.util.*;

public class boj_21611_LimSW {
	static final int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static final int[] coeff = {3, -1, -3, 1};
	
	static int[][] del = new int[4][25];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int[] ball = new int[N*N];
		int x = N/2, y = N/2, d = 0, size = 0;
		l:for (int l = 1; l <= N; l++) {
			for (int k = 0; k < 2; k++) {
				for (int i = 0; i < l; i++) {
					if (x == 0 && y == 0) break l;
					x += dx[d]; y += dy[d];
					int num = map[x][y];
					if (num == 0) break l;
					ball[++size] = num;
				}
				if (++d == 4) d = 0;
			}
		}
		int[] exp = new int[4];
		Deque<Integer> q = new ArrayDeque<>();
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			for (int l = 1; l <= s; l++) {
				if (del[d][l] == 0)
					del[d][l] = (4*l+coeff[d])*l;
				ball[del[d][l]] = 0;
			}
			int cnt = 1, prev = 0, cur = 0;
			for (int i = 1; i <= size; i++) {
				cur = ball[i];
				if (cur == 0) continue;
				if (prev == cur) {
					cnt++;
				} else {
					if (prev != 0) {
						q.offer(cnt);
						q.offer(prev);
					}
					prev = cur;
					cnt = 1;
				}
			}
			if (prev != 0) {
				q.offer(cnt);
				q.offer(prev);
			}
			do {
				size = q.size();
				for (int i = 0; i < size; i+=2) {
					cnt = q.poll();
					cur = q.poll();
					if (cnt >= 4) {
						exp[cur] += cnt;
					} else {
						q.offer(cnt);
						q.offer(cur);
					}
				}
				
				prev = 0;
				cnt = 0;
				int tmp = 0;
				size = q.size();
				for (int i = 0; i < size; i+=2) {
					tmp = q.poll();
					cur = q.poll();
					if (prev == cur) {
						cnt += tmp;
					} else {
						if (prev != 0) {
							q.offer(cnt);
							q.offer(prev);
						}
						cnt = tmp;
						prev = cur;
					}
				}
				q.offer(cnt);
				q.offer(prev);
			} while (size != q.size());
			Arrays.fill(ball, 0);
			for (size = 1; !q.isEmpty() && size < N*N; size++)
				ball[size] = q.pop();
			q.clear();
			size--;
		}
		int ans = 0;
		for (int i = 1; i < 4; i++) {
			ans += i*exp[i];
		}
		System.out.println(ans);
		br.close();
	}
}
