package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ZeroSubArraySum {

	public static void main(String args[]) {
		int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		int n = arr.length;

		findSubArrays(arr, n);

	}

	private static void findSubArrays(int[] arr, int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			sum += arr[i];

			if (mp.containsKey(sum)) {
				int index = mp.get(sum);
				System.out.println("Subarray found from index " + (index + 1) + " to " + i);
			} else {
				mp.put(sum, 1);
			}

		}
	}

}
