package y2023.m02.d13;

public class ModularTest {
	public static void main(String[] args) {
		int N = 32;
		int n = 0;
		int T = 10;
		int op = (int)1e8;
		int[] arr = new int[N];
		long[] sum = new long[4];
		long start;
		
		for (int tc = 0; tc < T; tc++) {
			start = System.nanoTime();
			for (int i = 0; i < op; i++) {
				n += 5;
				n %= N;
				arr[n]++;
				arr[n]--;
			}
			sum[0] += System.nanoTime() - start;
			
			start = System.nanoTime();
			// bit & 연산: 나누는 수가 2의 제곱수인 경우에만 사용 가능
			for (int i = 0; i < op; i++) {
				n += 5;
				n &= N-1;
				arr[n]++;
				arr[n]--;
			}
			sum[1] += System.nanoTime() - start;
			
			start = System.nanoTime();
			for (int i = 0; i < op; i++) {
				n += 5;
				while (n >= N) n -= N;
				arr[n]++;
				arr[n]--;
			}
			sum[2] += System.nanoTime() - start;
			
			start = System.nanoTime();
			for (int i = 0; i < op; i++) {
				n -= 5;
				while (n < 0) n += N;
				arr[n]++;
				arr[n]--;
			}
			sum[3] += System.nanoTime() - start;
		}
		System.out.println("mod: "+((sum[0] / T) / 1e6));
		System.out.println("and: "+((sum[1] / T) / 1e6));
		System.out.println("if+: "+((sum[2] / T) / 1e6));
		System.out.println("if-: "+((sum[3] / T) / 1e6));
	}
}
