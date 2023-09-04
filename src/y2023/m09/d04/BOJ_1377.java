package y2023.m09.d04;

import java.io.*;
import java.util.*;

// 버블 소트
public class BOJ_1377 {
    static class Num implements Comparable<Num> {
        int v, i;
        public int compareTo(Num o) {
            int r = Integer.compare(v, o.v);
            if (r == 0) r = Integer.compare(i, o.i);
            return r;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Num[] arr = new Num[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Num();
            arr[i].v = Integer.parseInt(br.readLine());
            arr[i].i = i;
        }
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            Num num = arr[i];
            ans = Math.max(ans, num.i - i);
        }
        System.out.println(ans+1);
        br.close();
    }
}
