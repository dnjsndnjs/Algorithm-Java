package y2023.m09.d12;

import java.io.*;
import java.util.*;

// 사냥꾼
public class BOJ_8983 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] shots = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++)
            shots[i] = Integer.parseInt(st.nextToken());
        // 이분탐색을 위한 정렬
        Arrays.sort(shots);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 동물과의 거리
            int l = y;
            // 이분탐색으로 가장 가까운 사대 찾기
            int p = Arrays.binarySearch(shots, x);
            if (p < 0) {
                p = ~p;
                // 동물이 가장 왼쪽 사대보다 왼쪽에 있을 때
                if (p == 0)
                    l += shots[0] - x;
                // 동물이 두개의 사대 사이에 있을 때
                else if (p < M)
                    l += Math.min(shots[p] - x, x - shots[p - 1]);
                // 동물이 가장 오른쪽 사대보다 오른쪽에 있을 때
                else
                    l += x - shots[M - 1];
            } // else: 사대와 x좌표가 일치할때
            if (l <= L) ans++;
        }
        System.out.println(ans);
        br.close();
    }
}
