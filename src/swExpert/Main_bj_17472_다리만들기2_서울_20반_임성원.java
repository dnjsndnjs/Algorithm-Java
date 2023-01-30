package swExpert;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/17472

public class Main_bj_17472_다리만들기2_서울_20반_임성원 {
    static final int[] di = { -1, 0, 1, 0 };
    static final int[] dj = { 0, -1, 0, 1 };

    static int N, M;
    static int[] island;
    static int[][] map;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static void bfs(int X, int Y, int num) {
        // 같은 섬을 찾기 위한 함수 // num: 섬 인덱스
        // queue 생성, 초기화
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] { X, Y });
        while (!q.isEmpty()) {
            // 큐의 다음 요소를 가져옴
            int[] now = q.poll();
            int nx = now[0], ny = now[1];
            // 현재 요소가 이미 탐색한 곳인지 확인
            if (map[nx][ny] > 0)
                continue;
            map[nx][ny] = num;
            // 4방탐색 +
            for (int d = 0; d < 4; d++) {
                int dx = nx + di[d], dy = ny + dj[d];
                // 범위 밖이거나 이미 탐색한 곳, 바다는 건너뜀
                if (!inRange(dx, dy))
                    continue;
                if (map[dx][dy] >= 0)
                    continue;
                q.add(new int[] { dx, dy });
            }
        }
    }

    static void printMap() {
        // 디버깅용 map 출력 함수
        System.out.println("map: ");
        for (int[] ma : map) {
            for (int m : ma) {
                System.out.print(m + " ");
            }
            System.out.println();
        }
        System.out.println("island: " + Arrays.toString(island));
    }

    public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_17472.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lines = br.readLine().split(" ");
        N = Integer.parseInt(lines[0]);
        M = Integer.parseInt(lines[1]);
        // 섬 구분 위한 배열 (인덱스: 섬 번호, [0]: 섬의 갯수, [1~6]: 해당 섬의 섬 그룹 번호)
        island = new int[7];
        map = new int[N][M];
        // 정답을 담기 위한 변수
        int res = 0;
        for (int i = 0; i < N; i++) {
            lines = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                // 섬 구분을 위해 -1로 초기화
                map[i][j] = -(lines[j].charAt(0) - '0');
            }
        }
//		debug
//		printMap();
        // 섬 구분
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] < 0) {
                    bfs(i, j, ++island[0]);
                    island[island[0]] = island[0];
                }
            }
        }
//		debug
//		printMap();
        // 길이가 짧은 다리를 먼저 사용하기 위한 우선순위 큐
        // 다리: int배열([0]: 다리의 길이, [1~2]: 다리가 연결하는 두 섬)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        // 다리 건설
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    continue;
                int from = map[i][j];
                // 우 방향으로 다리 건설
                int l = 1;
                while (inRange(i, j + l) && map[i][j + l] == 0) {
                    l++;
                }
                if (inRange(i, j + l) && l - 1 >= 2) {
                    int to = map[i][j + l--];
                    pq.add(new int[] { l, from, to });
                }
                // 하 방향으로 다리 건설
                l = 1;
                while (inRange(i + l, j) && map[i + l][j] == 0) {
                    l++;
                }
                if (inRange(i + l, j) && l - 1 >= 2) {
                    int to = map[i + l--][j];
                    pq.add(new int[] { l, from, to });
                }
            }
        }
        // 길이가 짧은 다리 먼저 사용
        while (!pq.isEmpty()) {
            int[] b = pq.poll();
//			debug
//			System.out.println("\n"+Arrays.toString(b));
            // 이미 다리로 연결된 섬인지 확인
            int i1 = b[1], g1 = island[i1];
            int i2 = b[2], g2 = island[i2];
            if (g1 == g2)
                continue;
            res += b[0];
            // 연결된 섬끼리 같은 숫자를 가지도록 함
            for (int i = 1; i < island[0] + 1; i++) {
                if (island[i] == g2) {
                    island[i] = g1;
                }
            }
//			debug
//			printMap();
//			System.out.println("res: "+res);
        }
        // 모든 섬이 연결 안되는 경우
        for (int i = 2; i < island[0] + 1; i++) {
            if (island[1] != island[i]) {
                res = -1;
            }
        }
        // 정답 출력
        System.out.println(res);
        br.close();
    }
}
