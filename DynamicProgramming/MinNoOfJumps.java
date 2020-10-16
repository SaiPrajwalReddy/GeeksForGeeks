package DynamicProgramming;

public class MinNoOfJumps {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 1, 0, 9 };

		System.out.println("Minimum number of jumps to reach end is : " + minJumps(arr, arr.length));
	}

	private static int minJumps(int[] arr, int length) {
		int temp[] = new int[length];

		int i, j;

		if (length == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;

		temp[0] = 0;
		for (i = 1; i < length; i++) {
			temp[i] = Integer.MAX_VALUE;
			for (j = 0; j < i; j++) {
				if (i <= j + arr[j] && temp[j] != Integer.MAX_VALUE) {
					temp[i] = Math.min(temp[i], temp[j] + 1);
					break;
				}
			}
		}
		return temp[length - 1];
	}
}
