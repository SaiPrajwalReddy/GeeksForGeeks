package Arrays;

public class ThreeWayPartition {

	public static void main(String[] args) {

		int arr[] = { 1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32 };

		threeWayPartition(arr, 10, 20);

		System.out.println("Modified array ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");

		}
	}

	private static void threeWayPartition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub

		int start = 0;
		int end = arr.length - 1;
		int temp = 0;

		for (int i = 0; i <= end;) {
			
			if (arr[i] < low) {
				temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;
				start++;
				i++;
			} else if (arr[i] > high) {
				temp = arr[i];
				arr[i] = arr[end];
				arr[end] = temp;
				end--;
			} else {
				i++;
			}
		}
	}
}
