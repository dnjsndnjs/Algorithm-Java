package y2023.m09.d04;

import java.io.*;
import java.util.*;

// 공주님의 정원
public class BOJ_2457 {
    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] accum = new int[13];
    static {
        for (int i = 0; i < 12; i++)
            accum[i+1] = accum[i] + days[i];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] flower = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            flower[i][0] = calc(m, d);
            m = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            flower[i][1] = calc(m, d);
        }
        Arrays.sort(flower, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        int start = calc(3, 1), end = calc(11, 30)+1, ans = 0;
        int idx = 0, pree = start;
        while (pree < end && idx < N) {
            int tmpi = N, tmpe = pree;
            while (idx < N && flower[idx][0] <= pree) {
                if (tmpe < flower[idx][1]) {
                    tmpe = flower[idx][1];
                    tmpi = idx;
                }
                idx++;
            }
            ans++;
            pree = tmpe;
            idx = tmpi+1;
        }
        if (pree < end) ans = 0;
        System.out.println(ans);
        br.close();
    }

    static int calc(int m, int d) {
        return accum[m-1] + d;
    }
}
