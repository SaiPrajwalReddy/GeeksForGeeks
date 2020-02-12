package StackAndQueue;

public class MaximumOfAllSubArrays {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 3;
		printKMax(arr, k, arr.length);
	}

	private static void printKMax(int[] arr, int k, int length) {
		// TODO Auto-generated method stub

		for (int j = 0; j < arr.length - k; j++) {

			for (int i = (j + k - 1) / 2 - 1; i >= j; i--) {
				buildHeap(arr, i, j + k);

			}
			System.out.print(arr[j] + " ");
		}

	}

	private static void buildHeap(int[] arr, int index, int endIndex) {
		// TODO Auto-generated method stub
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int smallest = index;
		if (left < endIndex && arr[left] < arr[smallest]) {
			smallest = left;
		}
		if (right < endIndex && arr[right] < arr[smallest]) {
			smallest = right;
		}

		if (smallest != index) {
			int temp = arr[index];
			arr[index] = arr[smallest];
			arr[smallest] = temp;

			buildHeap(arr, smallest, endIndex);
		}
	}
}
