package y2023.m03.d30;

import java.io.*;
import java.util.*;

public class Main_bj_21921_블로그 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++)
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		int ans = 0, cnt = 0;
		for (int i = X; i <= N; i++) {
			int sum = arr[i]-arr[i-X];
			if (ans < sum) {
				ans = sum;
				cnt = 1;
			} else if (ans == sum)
				cnt++;
		}
		if (ans == 0)
			System.out.println("SAD");
		else {
			System.out.println(ans);
			System.out.println(cnt);
		}
		br.close();
	}
}
