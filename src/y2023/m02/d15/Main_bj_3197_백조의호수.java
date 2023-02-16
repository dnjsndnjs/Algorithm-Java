package y2023.m02.d15;

import java.io.*;
import java.util.*;

/*
 * 
1. 시간 초과 :
얼음을 녹이는 함수와 백조가 만나는지 확인하는 함수 모두 BFS로 구현하신 경우, 
넓은 맵을 매번 탐색하기 때문에 시간이 많이 걸릴 수 밖에 없습니다.
프로그램 전체를 통틀어 얼음을 녹이는 함수의 BFS와 백조가 만나는지 확인하는 
함수의 BFS가 각각 한번만 진행되어야 합니다.
현재의 얼음을 녹이는 큐와 다음 날에 녹일 얼음을 담아둘 버퍼 큐를 사용하여 
이를 해결할 수 있습니다.
마찬가지로, 현재의 백조가 돌아다니는 영역을 저장할 큐와 다음 날에 백조가 
돌아다닐 버퍼 큐를 통해 이를 해결할 수 있습니다.
다음 날에 탐색할 노드를 버퍼 큐에 넣고 다음 날이 되면 버퍼 큐를 큐에 복사해 보세요.
2. 메모리 초과 :
 큐에 너무 많은 정보가 들어가게 되면 메모리 초과가 일어납니다. 방문 체크의 
 조건이 무엇인지, 큐에 어떤 노드들이 들어가고 있는지, 혹시 불필요한 노드가 
 큐에 들어가고 있지는 않은지 다시 한번 깐깐하게 살펴보세요.
버퍼 큐를 사용한 후에는 while(!Q.empty()) Q.pop(); 을 통해 버퍼 큐를 전부 
비워 메모리 공간을 확보해 주시는 것도 좋습니다.

3.  입력을 받으며 동시에 처리할 수 있는 것 :
 입력을 받음과 동시에 물 '.' 을 큐에 넣어놓거나, 얼음 'X'을 큐에 넣어놓는다면 
 얼음을 녹이는 함수의 첫 BFS 실행시에 큐에 넣어질 노드를 미리 준비해둘 수 있습니다. 
 큐에 물을 넣을지 얼음을 넣을지는 여러분이 설계한 '가장자리의 조건'에 따라 달라질 수 있습니다.
 */

public class Main_bj_3197_백조의호수 {
	static final int[] di = {1, -1, 0, 0};
	static final int[] dj = {0, 0, -1, 1};
	
	static int R, C;
	static int[][] map;
	Deque<int[]> water, buffer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int scnt = 0, si = 0, sj = 0, gi = 0, gj = 0;
		for (int i = 0; i < R; i++) {
			String in = br.readLine();
			for (int j = 0; j < C; j++) {
				if (in.charAt(j) == 'L') {
					map[i][j] = 0;
					if (scnt == 0) {
						si = i; sj = j; scnt++;
					} else {
						gi = i; gj = j;
					}
				} else if (in.charAt(j) == 'X')
					map[i][j] = 1;
			}
		}
		for (int[] m : map) System.out.println(Arrays.toString(m)); System.out.println();
		System.out.println();
		br.close();
	}
	
	static void bfs(int i, int j, boolean[][] v) {
		Deque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] {i, j});
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0]; j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i+di[d], nj = j+dj[d];
				if (!(0 <= ni && ni < R && 0 <= nj && nj < C && !v[ni][nj])) continue;
				v[ni][nj] = true;
				q.offer(new int[] {ni, nj});
			}
		}
	}
}
