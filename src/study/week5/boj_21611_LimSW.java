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
		// 입력을 받기위한 이차원 배열
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		// 실제 구슬에 대해 저장할 일차원 배열
		int[] ball = new int[N*N];
		int x = N/2, y = N/2, d = 0, size = 0;
		// 회오리를 돌며 구슬의 위치를 1차원화
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
		// 각 숫자별로 폭발한 구슬의 개수를 저장하기 위한 배열
		int[] exp = new int[4];
		// 다음 공의 위치를 계산하기 위한 큐
		Deque<Integer> q = new ArrayDeque<>();
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			// 수열을 통해 1차원 배열에서 +모양의 위치를 찾아 0으로 만듬
			for (int l = 1; l <= s; l++) {
				if (del[d][l] == 0)
					del[d][l] = (4*l+coeff[d])*l;
				ball[del[d][l]] = 0;
			}
			// cnt: 연속된 같은 숫자의 구슬의 개수
			// prev: 이전에 본 구슬의 숫자
			// cur: 지금 보는 구슬의 숫자
			int cnt = 1, prev = 0, cur = 0;
			for (int i = 1; i <= size; i++) {
				cur = ball[i];
				// +위치의 지운 구슬 건너뛰기
				if (cur == 0) continue;
				if (prev == cur) {
					cnt++;
				} else {
					// 맨 처음 prev가 0일때의 처리
					if (prev != 0) {
						q.offer(cnt);
						q.offer(prev);
					}
					prev = cur;
					cnt = 1;
				}
			}
			// 마지막 구슬 추가
			if (prev != 0) {
				q.offer(cnt);
				q.offer(prev);
			}
			// 구슬 폭발
			do {
				// 구슬이 4개 이상인 경우 폭발
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
				// 다시한번 순회하며 구슬 땡겨오면서 계산
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
				// size가 q.size()인 경우는 변화가 없었다는 뜻
			} while (size != q.size());
			Arrays.fill(ball, 0);
			// ball 배열에 q내용 담기
			// N^2보다 더 커지는 경우 q.clear()
			for (size = 1; !q.isEmpty() && size < N*N; size++)
				ball[size] = q.pop();
			q.clear();
			size--;
		}
		// 답 계산
		int ans = 0;
		for (int i = 1; i < 4; i++) {
			ans += i*exp[i];
		}
		System.out.println(ans);
		br.close();
	}
}
