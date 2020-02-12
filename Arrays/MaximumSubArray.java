package Arrays;

public class MaximumSubArray {

	public static void main(String args[]) {
		int a[] = { 2, 8, -4, -1, -2, 1, 5, 3 };

		maximumSubArray(a);
	}

	private static void maximumSubArray(int[] a) {
		// TODO Auto-generated method stub

		int start = 0;
		int end = 0;
		int max = 0;
		int sum = 0;
		int maxSum = 0;
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				j = i;
				sum = 0;
				while (j < a.length && a[j] > 0) {
					sum += a[j];
					j++;
				}

				if (sum > maxSum) {
					max = j - i - 1;
					start = i;
					end = j - 1;
					maxSum = sum;
				} else {
					if (sum == maxSum) {
						if (j - 1 - 1 > max) {
							max = j - i - 1;
							start = i;
							end = j - 1;
						}
					}
				}
			}

		}
		System.out.println("The maximum subarray is ");
		for (int i = start; i <= end; i++) {
			System.out.print(a[i] + " ");
		}

	}
}
