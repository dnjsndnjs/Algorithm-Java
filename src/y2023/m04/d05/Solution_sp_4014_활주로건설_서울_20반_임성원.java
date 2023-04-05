package y2023.m04.d05;

import java.io.*;
import java.util.*;

public class Solution_sp_4014_활주로건설_서울_20반_임성원 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(new File("res/input_sp_4014.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            l:for (int i = 0; i < N; i++) {
                int len = 1;
                for (int j = 1; j < N; j++) {
                    int diff = map[i][j] - map[i][j-1];
                    if (Math.abs(diff) > 1) continue l;
                    if (diff == 0) {
                        len++;
                    } else if (diff < 0) {
                        if (len < 0) continue l;
                        len = -X+1;
                    } else {
                        if (len < X) continue l;
                        len = 1;
                    }
                }
                if (len < 0) continue l;
                ans++;
            }
            l:for (int i = 0; i < N; i++) {
                int len = 1;
                for (int j = 1; j < N; j++) {
                    int diff = map[j][i] - map[j-1][i];
                    if (Math.abs(diff) > 1) continue l;
                    if (diff == 0) {
                        len++;
                    } else if (diff < 0) {
                        if (len < 0) continue l;
                        len = -X+1;
                    } else {
                        if (len < X) continue l;
                        len = 1;
                    }
                }
                if (len < 0) continue l;
                ans++;
            }
            sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.print(sb);
        br.close();
    }
}
