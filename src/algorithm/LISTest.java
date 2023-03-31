package algorithm;

import java.util.*;

public class LISTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && LIS[i] < LIS[j]+1)
					LIS[i] = LIS[j]+1;
			}
			if (max < LIS[i])
				max = LIS[i];
		}
		System.out.println(max);
		sc.close();
	}
}


/*
6
3 2 6 4 5 1
==>3

10
8 2 4 3 6 11 7 10 14 5
==>6
*/