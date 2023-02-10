package y2023.m02.d07;

import java.io.*;
import java.util.*;

public class Solution_d4_1210_Ladder1_서울_20반_임성원 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_0207.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int[][] map = new int[100][100];
			int row = 99, col = 0;
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					map[i][j] = st.nextToken().charAt(0) - '0';
					if (map[i][j] == 2)
						col = j;
				}
			}
			
			while (row > 0) {
				boolean move = false;
				while (col-1 >= 0 && map[row][col-1] == 1) {
					move = true;
					col--;
				}
				while (!move && col+1 < 100 && map[row][col+1] == 1) {
					col++;
				}
				row--;
			}
			sb.append("#").append(tc).append(" ").append(col).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
