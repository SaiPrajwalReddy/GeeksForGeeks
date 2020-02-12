//https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
package Arrays;

public class KthSmallesElement {

	public static void main(String args[]) {
		int arr[] = { 12, 3, 5, 7, 19 };
		int k = 3;
		//int arr[] = { 5, 4, 3, 2, 1 };
		int value = kthSmallestElement(arr, k);
		System.out.println("Kth smallest element is " + value);
	}

	private static int kthSmallestElement(int[] arr, int k) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int root = 0;
		for (int i = n / 2 - 1; i >= 0; i--) {
			buildHeap(arr, i, n);
		}

		for (int i = 0; i < k; i++) {
			root =arr[0];
			arr[0] = arr[n - 1];
			n--;
			buildHeap(arr, 0, n);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		return root;

	}

	private static void buildHeap(int[] arr, int i, int n) {
		// TODO Auto-generated method stub
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int smallest = i;
		if (left < n && arr[left] <= arr[smallest]) {
			smallest = left;
		}
		if (right < n && arr[right] < arr[smallest]) {
			smallest = right;
		}
		if (smallest != i) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			buildHeap(arr, smallest, n);
		}
	}
}
