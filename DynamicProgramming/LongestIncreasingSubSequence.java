package DynamicProgramming;

public class LongestIncreasingSubSequence {

	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis(arr, n) + "\n");
	}

	private static int lis(int[] arr, int n) {
		// TODO Auto-generated method stub
		int temp[] = new int[n];
		int max = 0;

		for (int i = 0; i < n; i++)
			temp[i] = 1;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && temp[i] < temp[j] + 1) {
					temp[i] = temp[j] + 1;
				}
			}
		}

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > max)
				max = temp[i];
		}

		return max;
	}
}
