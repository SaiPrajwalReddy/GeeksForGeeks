package Heap;

public class HeapSort {

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		heapSort(arr, arr.length);
	}

	private static void heapSort(int[] arr, int length) {
		// TODO Auto-generated method stub

		for (int i = (length - 1) / 2; i >= 0; i--)
			buildMaxHeap(arr, i, length);

		for (int i = length - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			buildMaxHeap(arr, 0, i);

		}

		System.out.println("After Sorting the array is ");
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	private static void buildMaxHeap(int[] arr, int i, int n) {
		// TODO Auto-generated method stub
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;

		if (left < n && arr[left] > arr[largest])
			largest = left;
		if (right < n && arr[right] > arr[largest])
			largest = right;

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			buildMaxHeap(arr, largest, n);
		}
	}

}
