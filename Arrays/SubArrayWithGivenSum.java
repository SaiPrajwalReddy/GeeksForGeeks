package Arrays;

public class SubArrayWithGivenSum {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		int arr[] = { 15, 2, 4, 8, 20, 5, 10, 24 };
		int sum = 23;
		subArraySum(arr, arr.length, sum);
	}

	private static void subArraySum(int[] arr, int length, int sum) {
		// TODO Auto-generated method stub
		int current_sum = 0;
		int start = 0;
		int end = 0;
		boolean found = false;
		for (int i = 0; i < arr.length; i++) {
			if (current_sum < sum) {
				while (current_sum < sum && end < arr.length) {
					current_sum = current_sum + arr[end];
					end++;

				}
			}
			if (current_sum == sum) {
				found = true;
				break;
			}
			if (current_sum > sum) {
				while (current_sum > sum && start < arr.length) {
					current_sum = current_sum - arr[start];
					start++;
				}
			}

		}
		if (found) {
			System.out.println("Sum found between indices :" + start + " and " + (end - 1));
		} else {
			System.out.println("No SubArray found with given sum");
		}
	}
}
