package y2023.m03.d31;

import java.io.*;
import java.util.StringTokenizer;

public class Main_bj_16987_계란으로계란치기 {
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] eggs = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		back(0, 0, N, eggs);
		System.out.println(ans);
		br.close();
	}

	static void back(int cnt, int sum, int N, int[][] eggs) {
		if (cnt == N) {
			if (ans < sum)
				ans = sum;
			return;
		}
		int Scnt = eggs[cnt][0];
		if (Scnt <= 0) {
			back(cnt+1, sum, N, eggs);
			return;
		}
		boolean recur = false;
		for (int i = 0; i < N; i++) {
			if (i == cnt) continue;
			if (eggs[i][0] <= 0) continue;
			int Si = eggs[i][0];
			recur = true;
			eggs[i][0] -= eggs[cnt][1];
			eggs[cnt][0] -= eggs[i][1];
			int tmp = 0;
			if (eggs[i][0] <= 0) tmp++;
			if (eggs[cnt][0] <= 0) tmp++;
			back(cnt+1, sum+tmp, N, eggs);
			eggs[i][0] = Si;
			eggs[cnt][0] = Scnt;
		}
		if (!recur)
			back(cnt+1, sum, N, eggs);
	}
}
