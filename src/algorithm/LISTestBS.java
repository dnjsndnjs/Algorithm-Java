package algorithm;

import java.util.*;

public class LISTestBS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] C = new int[N+1];
		int[] prev = new int[N+1];
		Arrays.fill(C, Integer.MAX_VALUE);
		C[0] = 0;
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			int p = ~Arrays.binarySearch(C, num);
			C[p] = num;
			if (max < p) {
				max = p;
				prev[p-1] = C[p-1];
				prev[p] = num;
			}
		}
//		prev[max] = C[max];
		for (int i = 1; i <= max; i++)
			System.out.print(prev[i]+" ");
		System.out.println();
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

8
2 5 4 7 6 8 1 3
*/