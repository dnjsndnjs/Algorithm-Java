package y2023.m02.d17;

import java.io.*;
import java.util.*;

public class Main_bj_3040_백설공주와일곱난쟁이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = 9, check = -100;
		int[] nums = new int[N];
		int[] sort = new int[N];
		boolean[] fake = new boolean[100];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
			sort[i] = num;
			check += num;
		}
		Arrays.sort(sort);
		for (int i = 0; i < N; i++) {
			int p = Arrays.binarySearch(sort, check-nums[i]);
			if (p < 0) continue;
			if (nums[i] == sort[p]) continue;
			fake[nums[i]] = fake[sort[p]] = true;
			break;
		}
		for (int i = 0; i < N; i++) {
			if (fake[nums[i]]) continue;
			sb.append(nums[i]).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
