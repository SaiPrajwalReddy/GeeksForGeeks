package Arrays;

public class SumOfMiddleElements {

	public static void main(String[] args) {
		int ar1[] = { 1, 12, 15, 26, 38 };
		int ar2[] = { 2, 13, 17, 30, 45 };

		int n1 = ar1.length;
		int n2 = ar2.length;
		if (n1 == n2)
			System.out.println("Median is " + getMedian(ar1, ar2, n1));
		else
			System.out.println("arrays are of unequal size");
	}

	private static int getMedian(int[] ar1, int[] ar2, int n1) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		int mid = 0;
		int mid1 = 0;
		int count = 0;
		while (i < n1 && j < n1) {

			if (ar1[i] < ar2[j]) {
				if (count == n1 - 1) {
					mid = ar1[i];
				} else if (count == n1) {
					mid1 = ar1[i];
				}
				i++;
				count++;
			} else {
				if (count == n1 - 1) {
					mid = ar2[j];
				} else if (count == n1) {
					mid1 = ar2[j];
				}
				j++;
				count++;
			}
			System.out.print(ar1[i] + " " + ar2[j] + " " + count + " " + mid + " " + mid1 + " ");
			System.out.println();
			if (mid != 0 && mid1 != 0)
				break;

		}

		while (i < n1) {
			if (count == n1 - 1) {
				mid = ar1[i];
			} else if (count == n1) {
				mid1 = ar1[i];
			}
			i++;
			count++;
		}

		while (j < n1) {
			if (count == n1 - 1) {
				mid = ar2[j];
			} else if (count == n1) {
				mid1 = ar2[j];
			}
			j++;
			count++;

		}
		return (mid + mid1) / 2;
	}
}
