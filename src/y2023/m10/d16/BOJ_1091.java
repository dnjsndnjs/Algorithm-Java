package y2023.m10.d16;

import java.io.*;
import java.util.*;

// 카드 섞기
public class BOJ_1091 {
    // 원본 카드 순서를 저장
    static int[] base;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 카드 순서
        int[] card = new int[N];
        // 섞을 때 가게되는 위치
        int[] index = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st1.nextToken());
            index[i] = Integer.parseInt(st2.nextToken());
        }

        int ans = 0;
        // 원본을 저장
        base = card;
        // 원하는 순서가 될때까지 반복
        for (; !check(card, N); ans++) {
            card = shuffle(card, index, N);
            // 새로운 순서가 원본과 같다면 cycle 발생 -> -1
            if (cycle(card, N)) {
                ans = -1;
                break;
            }
        }
        System.out.println(ans);
        br.close();
    }

    static boolean check(int[] card, int N) {
        for (int i = 0; i < N; i++)
            if (card[i] != i % 3)
                return false;
        return true;
    }

    static int[] shuffle(int[] card, int[] index, int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++)
            res[index[i]] = card[i];
        return res;
    }

    static boolean cycle(int[] card, int N) {
        for (int i = 0; i < N; i++)
            if (base[i] != card[i])
                return false;
        return true;
    }
}
