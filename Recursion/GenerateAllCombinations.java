package Recursion;

public class GenerateAllCombinations {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int r = 3;

		generateAllCombinations(arr, r, arr.length);
	}

	private static void generateAllCombinations(int[] arr, int r, int length) {
		// TODO Auto-generated method stub
		int result[] = new int[r];

		generateCombOfKsize(arr, result, 0, length - 1, 0, r);
	}

	private static void generateCombOfKsize(int[] arr, int[] result, int start, int j, int index, int r) {
		// TODO Auto-generated method stub

		if (index == r) {
			for (int i = 0; i < r; i++)
				System.out.print(result[i] + " ");

			System.out.println();
			return;
		}

		if (index >= r || start > j)
			return;
		// System.out.println(" "+index+" "+start+" "+r+" "+index+" ");
		result[index] = arr[start];
		generateCombOfKsize(arr, result, start + 1, j, index + 1, r);
		generateCombOfKsize(arr, result, start + 1, j, index, r);
	}
}
