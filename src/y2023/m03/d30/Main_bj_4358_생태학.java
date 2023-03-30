package y2023.m03.d30;

import java.io.*;
import java.util.*;

public class Main_bj_4358_생태학 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();
		int total = 0;
		String input = br.readLine();
		while (input != null) {
			map.put(input, map.getOrDefault(input, 0)+1);
			total++;
			input = br.readLine();
		}
		List<String> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		for (String key : keys) {
			double per = 100.*map.get(key)/total;
			sb.append(key).append(" ").append(String.format("%.4f%n", per));
		}
		System.out.print(sb);
		br.close();
	}
}
