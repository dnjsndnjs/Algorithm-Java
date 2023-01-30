package swExpert;

import java.util.*;

public class Main_bj_14502_연구소_서울_20반_임성원 {
    static final int[] di = { -1, 1, 0, 0 };
    static final int[] dj = { 0, 0, -1, 1 };

    static int N, M;
    static int[][] map;
    static int max;
    static int blank;
    static List<int[]> virus;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static void simul() {
        int[][] tmap = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                tmap[i][j] = map[i][j];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int total = blank - 3;
        q.addAll(virus);
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1];
            if (tmap[x][y] == 3)
                continue;
            tmap[x][y] = 3;
            total--;
            if (max > total) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + di[i], ny = y + dj[i];
                if (!inRange(nx, ny) || tmap[nx][ny] != 0)
                    continue;
                q.add(new int[] { nx, ny });
            }
        }
        if (total > max) {
            max = total;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        max = 0;
        blank = 0;
        virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 1)
                    blank++;
                if (map[i][j] == 2)
                    virus.add(new int[] { i, j });
            }
        }

        for (int i = 0; i < N * M - 2; i++) {
            if (map[i / M][i % M] != 0)
                continue;
            map[i / M][i % M] = 1;
            for (int j = i + 1; j < N * M - 1; j++) {
                if (map[j / M][j % M] != 0)
                    continue;
                map[j / M][j % M] = 1;
                for (int k = j + 1; k < N * M; k++) {
                    if (map[k / M][k % M] != 0)
                        continue;
                    map[k / M][k % M] = 1;
                    simul();
                    map[k / M][k % M] = 0;
                }
                map[j / M][j % M] = 0;
            }
            map[i / M][i % M] = 0;
        }
        System.out.println(max);
        sc.close();
    }
}
