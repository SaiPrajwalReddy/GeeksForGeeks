package DynamicProgramming;

public class LongestArthematicProgression {

	public static void main(String[] args) {
		int set1[] = { 1, 7, 10, 13, 14, 19 };
		int n1 = set1.length;
		System.out.println(lenghtOfLongestAP(set1, n1));

		int set2[] = { 1, 7, 10, 15, 27, 29 };
		int n2 = set2.length;
		System.out.println(lenghtOfLongestAP(set2, n2));

		int set3[] = { 2, 4, 6, 8, 10 };
		int n3 = set3.length;
		System.out.println(lenghtOfLongestAP(set3, n3));

	}

	private static int lenghtOfLongestAP(int[] set, int n) {
		// TODO Auto-generated method stub
		int temp[] = new int[n];
		int res = -1;
		for (int i = 0; i < n; i++)
			temp[i] = 2;

		for (int j = n - 2; j >= 1; j--) {
			int k = j + 1;
			int i = j - 1;

			while (k < n && i >= 0) {
				if (set[k] + set[i] == 2 * set[j]) {
					temp[j] = Math.max(temp[j], temp[k] + 1);
					res = Math.max(res, temp[j]);
					i--;
					k++;
				} else if (set[k] + set[i] < 2 * set[j])
					k++;
				else
					i--;

			}
		}

		return res;
	}
}
