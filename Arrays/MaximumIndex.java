package Arrays;

public class MaximumIndex {

	public static void main(String[] args) {
		MaximumIndex max = new MaximumIndex();
		int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		int n = arr.length;
		int maxDiff = max.maxIndexDiff(arr, n);
		System.out.println(maxDiff);
	}

	private int maxIndexDiff(int[] arr, int n) {
		// TODO Auto-generated method stub
		int leftMin[] = new int[n];
		int rightMax[] = new int[n];

		leftMin[0] = arr[0];
		rightMax[n - 1] = arr[n - 1];

		for (int i = 1; i < n; i++)
			leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
		for (int i = n - 2; i >= 0; i--)
			rightMax[i] = Math.max(rightMax[i + 1], arr[i]);

		int i = 0, j = 0, max = 0;

		while (i < n && j < n) {
			if (leftMin[i] < rightMax[j]) {
				max = j - i ;
				if (j - i  > max)
					max = j - i ;
				j = j + 1;
			} else {
				i = i + 1;
			}
		}

		return max;
	}
}
