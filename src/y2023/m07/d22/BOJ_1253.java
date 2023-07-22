package y2023.m07.d22;

import java.io.*;
import java.util.*;

// 좋다
public class BOJ_1253 {
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0)+1);
            arr[i] = num;
        }
        Arrays.sort(arr);
        ans = 0;
        map.forEach((key, value) -> ans += twoPointer(key, value, arr) ? value : 0);
        System.out.println(ans);
        br.close();
    }

    static boolean twoPointer(int num, int count, int[] arr) {
        int s = 0, e = arr.length-1;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum < num) {
                s++;
            } else if (sum > num) {
                e--;
            } else {
                int condition = num == 0 ? 3 : 2;
                if ((arr[s] == 0 || arr[s] == num) && count < condition){
                    s++;
                    e--;
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
