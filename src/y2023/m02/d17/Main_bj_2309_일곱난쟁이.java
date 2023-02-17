package y2023.m02.d17;

import java.io.*;
import java.util.*;

public class Main_bj_2309_일곱난쟁이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = 9, check = -100;
		int[] nums = new int[N];
		boolean[] fake = new boolean[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
			check += num;
		}
		Arrays.sort(nums);
		for (int i = 0; i < N; i++) {
			int p = Arrays.binarySearch(nums, check-nums[i]);
			if (p < 0 || p == i) continue;
			fake[i] = fake[p] = true;
			break;
		}
		for (int i = 0; i < N; i++) {
			if (fake[i]) continue;
			sb.append(nums[i]).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
