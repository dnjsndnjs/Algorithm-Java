package y2023.m04.d03;

import java.io.*;
import java.util.*;

public class Solution_sp_4013_특이한자석_서울_20반_임성원 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("res/input_sp_4013.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] gear = new int[4][8];
			int[] top = new int[4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++)
					gear[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int k = 0; k < N; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int idx = Integer.parseInt(st.nextToken())-1;
				int[] d = new int[4];
				d[idx] = -Integer.parseInt(st.nextToken());
				for (int i = idx-1; i >= 0; i--) {
					if(gear[i][(top[i]+2)%8] != gear[i+1][(top[i+1]-2+8)%8])
						d[i] = -d[i+1];
					else break;
				}
				for (int i = idx+1; i < 4; i++) {
					if(gear[i-1][(top[i-1]+2)%8] != gear[i][(top[i]-2+8)%8])
						d[i] = -d[i-1];
					else break;
				}
				for (int i = 0; i < 4; i++) {
					top[i] = (top[i]+d[i]+8)%8;
				}
			}
			int ans = 0;
			for (int i = 0; i < 4; i++)
				ans |= gear[i][top[i]] << i;
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
