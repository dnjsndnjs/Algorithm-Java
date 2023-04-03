package y2023.m02.d06;

import java.io.*;

public class Main_bj_17478_재귀함수가뭔가요_서울_20반_임성원 {
	static final String[] output = {
			"\"재귀함수가 뭔가요?\"\n",
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
			"라고 답변하였지.\n"
	};

	static StringBuilder sb;

	static void recur(int d, int num) {
		print____(d);
		sb.append(output[0]);
		if (d == num) {
			print____(d);
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		} else {
			for (int i = 1; i < 4; i++) {
				print____(d);
				sb.append(output[i]);
			}
			recur(d + 1, num);
		}
		print____(d);
		sb.append(output[4]);
	}

	static void print____(int d) {
		for (int j = 0; j < d; j++)
			sb.append("____");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());

		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		recur(0, num);
		sb.setLength(sb.length() - 1);
		System.out.print(sb.toString());
	}

}
