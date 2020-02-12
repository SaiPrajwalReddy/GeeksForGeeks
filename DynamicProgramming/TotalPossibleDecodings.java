package DynamicProgramming;

public class TotalPossibleDecodings {

	public static void main(String[] args) {
		char digits[] = { '1', '2', '3', '4' };
		int n = digits.length;
		System.out.printf("Count is %d", countDecoding(digits, n));
	}

	private static int countDecoding(char[] digits, int n) {
		// TODO Auto-generated method stub
		int count[] = new int[n + 1];
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			count[i] = 0;
			if (digits[i - 1] > '0')
				count[i] = count[i - 1];

			if (digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7')) {
				count[i] = count[i - 2] + count[i];
			}
		}
		return count[n];

	}
}
