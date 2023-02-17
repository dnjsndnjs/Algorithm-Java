package y2023.m02.d17;

import java.io.*;
import java.util.*;

public class Main_bj_1931_회의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[][] meeting = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(meeting, (o1, o2) -> {
			int r = Integer.compare(o1[1], o2[1]);
			if (r == 0) return Integer.compare(o1[0], o2[0]);
			return r;
		});
		int ans = 0, end = 0;
		for (int i = 0; i < N; i++) {
			if (meeting[i][0] < end) continue;
			end = meeting[i][1];
			ans++;
		}
		System.out.println(ans);
		br.close();
	}
}
