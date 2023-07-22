package y2023.m07.d22;

import java.io.*;

// 고냥이
public class BOJ_16472 {
    static final int ar = 'z'-'a'+1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] alpha = new int[ar];
        char[] carr = br.readLine().toCharArray();
        int count = 0, l = carr.length, s = 0, e = 0, ans = 0;

        while (s < l) {
            if (e == l) {
                ans = Math.max(ans, e-s);
                break;
            }
            int c = carr[e] - 'a';
            if (alpha[c] != 0) {
                alpha[c]++;
                e++;
            } else if (count < N) {
                alpha[c]++;
                count++;
                e++;
            } else {
                ans = Math.max(ans, e-s);
                c = carr[s++] - 'a';
                if (--alpha[c] == 0) count--;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
