package DynamicProgramming;

public class MinOperations {

	public static void main(String[] args) {
		int N = 9, P = 5, Q = 1;

		System.out.println(minCost(N, P, Q));
	}

	private static int minCost(int n, int p, int q) {
		// TODO Auto-generated method stub
		int cost = 0;
		while (n > 0) {
			if (n % 2 != 0) {
				cost = cost + p;
				n--;
			} else {
				n = n / 2;

				if (n * p > q) {
					cost = cost + q;
				} else {
					cost = cost + p*n;
				}
			}
		}
		return cost;
	}
}
