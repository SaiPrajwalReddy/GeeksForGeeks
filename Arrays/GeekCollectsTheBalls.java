package Arrays;

public class GeekCollectsTheBalls {

	public static void main(String args[]) {
		int arr1[] = { 1, 4, 5, 6, 8 };
		int arr2[] = { 2, 3, 4, 6, 9 };

		System.out.println("Maximum Value obtained is " + maxVal(arr1, arr2));
	}

	private static int maxVal(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		int max = 0;
		int i = 0;
		int j = 0;
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;
		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] < arr2[j]) {
				sum1 = sum1 + arr1[i];
				i++;
			} else if (arr1[i] > arr2[j]) {
				sum2 = sum2 + arr2[j];
				j++;
			} else {

				if (sum1 > sum2)
					sum += sum1;
				else
					sum += sum2;

				sum = sum + arr1[i];
				sum1 = 0;
				sum2 = 0;
				i++;
				j++;

			}
			if (sum > max)
				max = sum;
		}

		while (i < arr1.length) {
			sum1 = sum1 + arr1[i];
			i++;
		}

		while (j < arr2.length) {
			sum2 = sum2 + arr2[j];
			j++;
		}
		if (sum1 > sum2)
			sum += sum1;
		else
			sum += sum2;

		if (sum > max)
			max = sum;
		return max;
	}
}
