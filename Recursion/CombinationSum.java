package Recursion;

public class CombinationSum {

	public static void main(String args[]) {
		int arr[] = { 2, 4, 6, 8 };
		int k = 8;
		int result[] = new int[4];
		findCombinationSum(arr, k, result, 0, 0, 8);
	}

	private static void findCombinationSum(int[] arr, int k, int[] result, int j, int i, int sum) {
		// TODO Auto-generated method stub
		if (sum == 0) {
			for (int s = 0; s < j; s++)
				System.out.print(result[s] + " ");

			System.out.println();
			return;
		}

		if (sum < 0)
			return;

		while (i < arr.length && sum - arr[i] >= 0) {
			result[j++] = arr[i];

			findCombinationSum(arr, k, result, j, i, sum - arr[i]);

			i++;
			j--;
		}
	}
}
