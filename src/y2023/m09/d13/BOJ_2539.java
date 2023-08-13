package y2023.m09.d13;

import java.io.*;
import java.util.*;

// 모자이크
public class BOJ_2539 {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        // 잘못 칠해진 칸 중 가장 높은 행번호를 저장하기 위한 변수
        int maxr = 0;
        // 열번호의 중복을 제거하기 위해 set 사용
        Set<Integer> cset = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            maxr = Math.max(maxr, y);
            cset.add(x);
        }
        // 열번호를 배열로 변환하여 정렬
        Integer[] cpos = cset.toArray(new Integer[0]);
        Arrays.sort(cpos);

        int ans = 0, l = maxr, r = Math.max(R, C), maxc = cpos[cpos.length-1];
        while (l <= r) {
            int mid = (l+r)/2;
            int paper = 0, cover = 0, p = -1;
            // 주어진 장수만큼 색종이로 칸을 가림
            while (paper++ < P) {
                // 가려지지 않은 가장 왼쪽의 칸의 열번호 구하기
                // + 검증하려는 종이의 크기만큼 도화지를 가림
                cover = cpos[++p] + mid - 1;
                // 가려진 가장 오른쪽 열번호를 구하는 이분탐색
                // 양수인 경우 딱 그 칸까지 가려졌으므로 따로 처리하지 않음
                // 음수인 경우 그 칸을 넘어서 가려졌으니 비트 반전후 -1
                // 반복문 처음에 ++p를 통해 다음 열번호(가려지지 않은 가장 왼쪽 열번호)로 넘어감
                p = Arrays.binarySearch(cpos, cover);
                if (p < 0) p = ~p - 1;
                // 주어진 장수를 다 채우기 전에 모든 칸을 가렸다면 break
                if (cover >= maxc) break;
            }
            if (cover < maxc) {
                // 모든 칸을 가리지 못한 경우 종이 크기를 키워야함
                l = mid + 1;
            } else {
                // 모든 칸을 가린 경우 값을 저장하고
                // 최소의 종이 크기를 구하기 위해 종이 크기를 줄임
                ans = mid;
                r = mid - 1;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
