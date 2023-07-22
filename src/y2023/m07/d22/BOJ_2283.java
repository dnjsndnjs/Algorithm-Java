package y2023.m07.d22;

import java.io.*;
import java.util.*;

// 구간 자르기
public class BOJ_2283 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int inf = 1_000_000;
        int[] arr = new int[inf+1];
        for (int i = 0; i < N; i++) {
            // 각 직선마다 시작점에서 끝점까지 돌면서
            // 걸치는 구간에 +1
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = a; j < b; j++) {
                arr[j]++;
            }
        }

        int s = 0, e = 0, sum = 0;
        while (s < inf) {
            // 투포인터
            if (sum == K) break;
            if (sum < K) {
                if (e > inf) {
                    // 구간의 최대를 넘어가면 0 0 으로 종료
                    s = e = 0;
                    break;
                }
                sum += arr[e];
                e++;
            } else {
                sum -= arr[s];
                s++;
            }
        }
        System.out.printf("%d %d", s, e);
        br.close();
    }
}
