package DynamicProgramming;

public class RodCutting {

	public static void main(String args[]) {
		int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));
	}

	private static int cutRod(int[] arr, int size) {
		int res[] = new int[size + 1];
		res[0] = 0;
		int max = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 1; i <= arr.length; i++) {
			temp = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				temp = res[ i-j-1] + arr[j];
				if (temp > max)
					max = temp;
			}
			res[i] = max;
		}

		return res[size];
	}
}
