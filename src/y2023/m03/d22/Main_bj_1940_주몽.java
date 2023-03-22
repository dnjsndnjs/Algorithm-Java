package y2023.m03.d22;

import java.io.*;
import java.util.*;

public class Main_bj_1940_주몽 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		
		int ans = 0;
		int s = 0, e = N-1;
		while (s < e) {
			int m = nums[s]+nums[e];
			if (m > M) {
				e--;
			} else if (m < M) {
				s++;
			} else {
				ans++;
				s++;
				e--;
			}
		}
		System.out.println(ans);
		br.close();
	}
}
