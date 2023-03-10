package y2023.m03.d10;

import java.io.*;
import java.util.*;

public class Main_bj_1764_듣보잡 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<String> ans = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++)
			set.add(br.readLine());
		for (int i = 0; i < M; i++) {
			String in = br.readLine();
			if (set.contains(in))
				ans.add(in);
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for (String s : ans)
			System.out.println(s);
		br.close();
	}
}
