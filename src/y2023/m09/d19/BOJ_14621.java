package y2023.m09.d19;

import java.io.*;
import java.util.*;

// 나만 안되는 연애
public class BOJ_14621 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] male = new boolean[N];
        int[] root = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            // 남초 학교이면 true, 아니면 false
            male[i] = st.nextToken().charAt(0) == 'M';
            root[i] = i;
        }
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            // 연결된 두 대학이 남초, 여초인 경우에만 pq에 넣는다
            if (male[u] != male[v])
                pq.offer(new int[] {u, v, d});
        }
        // 크루스칼 알고리즘
        int ans = 0, cnt = 0;
        while (!pq.isEmpty() && cnt != N-1) {
            int[] cur = pq.poll();
            int u = cur[0], v = cur[1], d = cur[2];
            u = find(u, root);
            v = find(v, root);
            if (u != v) {
                ans += d;
                cnt ++;
                union(u, v, root);
            }
        }
        // cnt: 연결된 도로 가 N-1개가 아닌 경우
        // => 모든 대학이 연결되지 않는 경우
        if (cnt != N-1) ans = -1;
        System.out.println(ans);
        br.close();
    }

    static int find(int x, int[] root) {
        if (root[x] == x) return x;
        return root[x] = find(root[x], root);
    }
    static void union(int a, int b, int[] root) {
        a = find(a, root);
        b = find(b, root);
        root[b] = a;
    }
}
