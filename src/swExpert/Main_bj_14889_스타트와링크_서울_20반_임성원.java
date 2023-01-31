package swExpert;

import java.util.*;
import java.io.*;

public class Main_bj_14889_스타트와링크_서울_20반_임성원 {
	static int N;
	static int team1, team2;
	static int diff = Integer.MAX_VALUE;
	static int[][] S;
	
	static void backtracking() {
		
	}
	
	static int calc() {
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		backtracking();
		System.out.println(diff);
		br.close();
	}
}
