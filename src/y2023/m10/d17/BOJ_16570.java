package y2023.m10.d17;

import java.io.*;
import java.util.*;

// 앞뒤가 맞는 수열
public class BOJ_16570 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 앞에서부터 자르게 되므로 순서를 역순으로 변경
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // kmp 테이블을 생성
        int[] table = new int[N];
        for (int i = 1, j = 0; i < N; i++) {
            while (j != 0 && arr[i] != arr[j])
                j = table[j - 1];
            if (arr[i] == arr[j])
                table[i] = ++j;
        }
        // kmp 테이블의 i값은 0 ~ i까지의 문자열(뒤에서부터 자른 문자열)에서
        // prefix와 suffix가 같은 최대의 길이
        // 문제에서 요구하는 max값이 됨
        // 미리 역순으로 받았기 때문에 앞에서부터 자른 문자열이 됨
        int max = 0, cnt = 0;
        for (int i = 0; i < N; i++) {
            if (max < table[i]) {
                max = table[i];
                cnt = 1;
            } else if (max == table[i])
                cnt++;
        }
        if (max == 0)
            System.out.println(-1);
        else
            System.out.println(max + " " + cnt);
        br.close();
    }
}
