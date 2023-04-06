package y2023.m04.d06;

import java.io.*;
import java.util.*;

public class Main_bj_16134_조합 {
    static final int P = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[] fac = new long[N+1];
        fac[0] = 1;
        for (int i = 1; i <= N; i++)
            fac[i] = (fac[i-1]*i)%P;
        long tmp = (fac[N]*pow(fac[N-R], P-2))%P;
        tmp = (tmp*pow(fac[R], P-2))%P;
        System.out.println(tmp);
        br.close();
    }

    static long pow(long x, int y) {
        long res = 1;
        while (y != 0) {
            if ((y&1) != 0)
                res = (res*x)%P;
            y /= 2;
            x = (x*x)%P;
        }
        return res;
    }
}
