package Arrays;

public class RowWithMaxOnes {

	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		System.out.println("Index of row with maximum 1s is " + rowWithMax1s(mat));
	}

	private static int rowWithMax1s(int[][] mat) {
		// TODO Auto-generated method stub
		int index = 0;
		int max = 0;
		for (int i = 0; i < mat.length; i++) {
			index = binarySearch(mat[i], 0, mat[i].length - 1);
			if (index != -1) {
				index = mat[i].length - index;
				if (index > max)
					max = i;
			}
		}
		return max;
	}

	private static int binarySearch(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid >= 1 && arr[mid] == 1 && arr[mid - 1] == 0) || (mid == 0 && arr[mid] == 1)) {
				return mid;
			} else if (arr[mid] == 1)
				return binarySearch(arr, low, mid - 1);
			return binarySearch(arr, mid + 1, high);
		}
		return -1;
	}
}
