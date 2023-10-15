package y2023.m08.d18;

import java.io.*;
import java.util.*;

// 행성 터널
public class BOJ_2887 {
    public static void main(String[] args) throws Exception {
        // 크루스칼 알고리즘 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 행성 배열 [0: x, 1: y, 2: z, 3: 인덱스]
        int[][] P = new int[N][4];
        // union-find를 위한 배열
        int[] root = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++)
                P[i][j] = Integer.parseInt(st.nextToken());
            P[i][3] = root[i] = i;
        }
        // 가장 짧은 간선을 찾기위한 pq
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int j = 0; j < 3; j++) {
            int idx = j;
            // x, y, z 순서로 기준을 잡아 정렬
            Arrays.sort(P, Comparator.comparingInt(o -> o[idx]));
            // 정렬된 축 기준 바로 양옆의 행성과의 거리가 갈 수 있는 거리중 최소가 될 것임
            // => 모든 간선의 길이를 구하지 않아도 됨
            for (int i = 1; i < N; i++) {
                int dist = Math.abs(P[i-1][j] - P[i][j]);
                pq.offer(new int[] {P[i-1][3], P[i][3], dist});
            }
        }
        // ans: 가중치의 합, cnt: 선택한 간선의 개수
        int ans = 0, cnt = 0;
        // 간선이 N-1개 선택되면 모든 행성이 연결
        while (!pq.isEmpty() && cnt < N-1) {
            int[] cur = pq.poll();
            int i = find(cur[0], root);
            int j = find(cur[1], root);
            if (i != j) {
                union(i, j, root);
                ans += cur[2];
                cnt++;
            }
        }
        System.out.println(ans);
        br.close();
    }

    static int find(int i, int[] root) {
        if (root[i] == i) return i;
        return root[i] = find(root[i], root);
    }

    static void union(int i, int j, int[] root) {
        i = find(i, root);
        j = find(j, root);
        if (i < j)
            root[j] = i;
        else
            root[i] = j;
    }
}
