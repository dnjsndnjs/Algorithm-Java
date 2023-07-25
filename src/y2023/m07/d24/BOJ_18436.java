package y2023.m07.d24;

import java.io.*;
import java.util.*;

// 수열과 쿼리 37
public class BOJ_18436 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] tree = new int[4*N]; // 세그트리 홀수의 개수 저장
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        init(tree, 0, N-1, 1, nums);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 입력의 인덱스가 1부터 시작임에 유의
            if (a == 1) {
                int diff = c%2 - nums[b-1]%2;
                if (diff != 0)
                    update(tree, 0, N-1, 1, b-1, diff);
                nums[b-1] = c;
            } else if (a == 2) {
                sb.append(c-b+1-sum(tree, 0, N-1, 1, b-1, c-1)).append('\n');
            } else {
                sb.append(sum(tree, 0, N-1, 1, b-1, c-1)).append('\n');
            }
        }
        System.out.print(sb);
        br.close();
    }

    static int init(int[] tree, int s, int e, int n, int[] nums) {
        if (s == e)
            return tree[n] = nums[s] % 2;
        int m = (s+e)/2;
        return tree[n] = init(tree, s, m, n*2, nums) + init(tree, m+1, e, n*2+1, nums);
    }

    static void update(int[] tree, int s, int e, int n, int i, int diff) {
        if (i < s || e < i)
            return;
        tree[n] += diff;
        if (s == e)
            return;
        int m = (s+e)/2;
        update(tree, s, m, n*2, i, diff);
        update(tree, m+1, e, n*2+1, i, diff);
    }

    static int sum(int[] tree, int s, int e, int n, int l, int r) {
        if (r < s || e < l)
            return 0;
        if (l <= s && e <= r)
            return tree[n];
        int m = (s+e)/2;
        return sum(tree, s, m, n*2, l, r) + sum(tree, m+1, e, n*2+1, l, r);
    }
}
