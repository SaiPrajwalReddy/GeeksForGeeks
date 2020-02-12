package Arrays;

public class LeftSideSmallerRightSideGreater {

	public static void main(String args[]) {
		int arr[] = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };

		System.out.println("The element is " + findElement(arr));
	}

	private static int findElement(int[] arr) {
		// TODO Auto-generated method stub
		int leftMin[] = new int[arr.length];
		int rightMax[] = new int[arr.length];
		int n = arr.length;
		leftMin[0] = -1;
		rightMax[n-1] = -1;
		int minimum = arr[0];
		int maximum = arr[arr.length - 1];
		for (int i = 1; i < n; i++) {
			if (arr[i] > minimum) {
				leftMin[i] = minimum;
			} else {
				minimum = arr[i];
				leftMin[i] = -1;
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] < maximum) {
				rightMax[i] = maximum;
			} else {
				maximum = arr[i];
				rightMax[i] = -1;
			}
		}

		for (int i = 0; i < n; i++) {
			if (leftMin[i] != -1 && rightMax[i] != -1)
				return arr[i];
		}
		return 0;
	}
}
