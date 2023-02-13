package y2023.m02.d13;

import java.io.*;
import java.util.*;

public class Main_bj_20055_컨베이어벨트위의로봇 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] belt = new int[2*N];
		int[] robot = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 2*N; i++)
			belt[i] = Integer.parseInt(st.nextToken());
		
		int zb = 0;
		int ans;
		for (ans = 0; zb < K; ans++) {
			// 벨트 회전
			int b_last = belt[2*N-1];
			for (int i = 2*N-1; i > 0; i--) {
				belt[i] = belt[i-1];
				if (i < N)
					robot[i] = robot[i-1];
			}
			belt[0] = b_last;
			robot[0] = 0;
			// 회전으로 내리는 칸에 간 경우
			robot[N-1] = 0;
			// 로봇 이동
			for (int i = N-1; i > 0; i--) {
				if (robot[i] == 0 && robot[i-1] == 1 && belt[i] != 0) {
					robot[i] = 1;
					robot[i-1] = 0;
					belt[i]--;
					if (belt[i] == 0)
						zb++;
				}
			}
			// 내리는 칸에 간 경우
			robot[N-1] = 0;
			// 로봇 올리기
			if (belt[0] != 0) {
				robot[0] = 1;
				belt[0]--;
				if (belt[0] == 0)
					zb++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}
