package y2023.m10.d17;

import java.io.*;
import java.util.*;

// 이름 정하기
class BOJ_16900 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char[] S = st.nextToken().toCharArray();
        int K = Integer.parseInt(st.nextToken());
        int N = S.length;

        int[] table = new int[N];
        for (int i = 1, j = 0; i < N; i++) {
            while (j != 0 && S[i] != S[j])
                j = table[j - 1];
            if (S[i] == S[j])
                table[i] = ++j;
        }
        // 50만 * 100만 = 5000억 <- int 범위 초과
        // suffix와 같은 prefix를 최대한 자르고 뒤에 붙이면
        // 가장 짧은 문자열이 나옴 -> N - prefix.length
        long ans = N - table[N - 1];
        ans *= K - 1;
        ans += N;
        System.out.println(ans);
        br.close();
    }
}
