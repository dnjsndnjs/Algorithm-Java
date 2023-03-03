package y2023.m03.d03;

import java.io.*;
import java.util.*;

public class Main_bj_7662_이중우선순위큐 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			tm.clear();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				char op = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				if (op == 'I') {
					tm.put(num, tm.getOrDefault(num, 0)+1);
				} else { // op == 'D'
					int key;
					if (tm.isEmpty())
						continue;
					else if (num == -1)
						key = tm.firstKey();
					else // num == 1
						key = tm.lastKey();
					if (tm.get(key) == 1)
						tm.remove(key);
					else
						tm.put(key, tm.get(key)-1);
				}
			}
			if (tm.isEmpty())
				sb.append("EMPTY\n");
			else
				sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
