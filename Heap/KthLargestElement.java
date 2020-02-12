package Heap;

import java.util.Scanner;

public class KthLargestElement {

	public static void main(String args[]) {

		int k = 3;
		int arr[] = new int[k];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = (k - 1) / 2; i >= 0; i--)
			buildMinHeap(arr, i, k);

		while (true) {
			System.out.println("kth largest element in stream is " + arr[0]);
			System.out.println("Do you wish to continue");

			String val = sc.next();

			if (val.equalsIgnoreCase("NO"))
				break;

			System.out.println("Enter the next element in the stream ");
			int value = sc.nextInt();

			if (value < arr[0]) {
				continue;
			} else {
				arr[0] = value;
				buildMinHeap(arr, 0, k);
			}
		}

		System.out.println("After Sorting the array is ");
		for (int i = 0; i < k; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	private static void buildMinHeap(int[] arr, int i, int n) {
		// TODO Auto-generated method stub
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int smallest = i;

		if (left < n && arr[left] < arr[smallest])
			smallest = left;
		if (right < n && arr[right] < arr[smallest])
			smallest = right;

		if (smallest != i) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;

			buildMinHeap(arr, smallest, n);
		}
	}
}
