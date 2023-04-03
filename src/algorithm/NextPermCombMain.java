package algorithm;

import java.util.*;

public class NextPermCombMain {
	static int N = 4, R = 3, C = 0;
	static int[] a = { 1, 2, 3, 4 };

	static boolean np() {
		int i = N - 1;
		while (i > 0 && a[i - 1] >= a[i])
			i--;
		if (i == 0)
			return false;

		int j = N - 1;
		while (a[i - 1] >= a[j])
			j--;
		swap(i - 1, j);

		int k = N - 1;
		while (i < k)
			swap(i++, k--);
		return true;
	}

	static void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		do {
			System.out.println(Arrays.toString(a));
		} while (np());
	}
}
