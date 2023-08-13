package y2023.m09.d13;

import java.io.*;
import java.util.*;

// 보석 도둑
public class BOJ_1202 {
    static class Gem {
        int M, V;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 가벼운 무게 순 pq
        Queue<Gem> weight = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.M, o2.M));
        // 높은 가치 순 pq
        Queue<Gem> value = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1.V, o2.V));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Gem gem = new Gem();
            gem.M = Integer.parseInt(st.nextToken());
            gem.V = Integer.parseInt(st.nextToken());
            weight.add(gem);
        }
        int[] bag = new int[K];
        for (int i = 0; i < K; i++)
            bag[i] = Integer.parseInt(br.readLine());
        // 가방 크기 오름차순 정렬
        Arrays.sort(bag);

        // 넣을 수 있는 보석의 최대 개수 * 보석의 최대 가치 = 300,000,000,000
        // => int 범위 초과 => long 사용
        long ans = 0;
        for (int C : bag) {
            // 무게pq가 비지 않고 나올 보석의 무게가 가방 크기보다 작은 동안 반복
            while (!weight.isEmpty() && weight.peek().M <= C)
                value.offer(weight.poll());
            // 가치pq가 비지 않은 경우
            if (!value.isEmpty())
                ans += value.poll().V;
        }
        System.out.println(ans);
        br.close();
    }
}
