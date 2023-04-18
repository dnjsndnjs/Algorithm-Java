package study.week8;

import java.io.*;
import java.util.*;

public class boj_4358_ISW {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();
		int total = 0;
		String input = br.readLine();
		while (input != null) {
			// input이 null이 되는 경우: 파일 끝에 도달한 경우
			map.put(input, map.getOrDefault(input, 0)+1);
			total++;
			input = br.readLine();
		}
		// 사전 순으로 출력하기 위해 key값들을 정렬
		List<String> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		for (String key : keys) {
			// 키 값을 순회하며 비율을 구하고 서식 문자를 사용하여 소수점 4자리까지 출력
			double per = 100.*map.get(key)/total;
			sb.append(key).append(" ").append(String.format("%.4f%n", per));
		}
		System.out.print(sb);
		br.close();
	}
}
