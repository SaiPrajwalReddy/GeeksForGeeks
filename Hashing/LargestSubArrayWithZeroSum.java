package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum {

	public static void main(String args[]) {
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		int n = arr.length;
		System.out.println("Length of the longest 0 sum " + "subarray is " + maxLenSubArray(arr, n));
	}

	private static int maxLenSubArray(int[] arr, int n) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		int sum = 0;
		int maximum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
			if(sum == 0)
				maximum = i+1;
			
			if (mp.containsKey(sum)) {
				int index = mp.get(sum);
				if (i - index > maximum)
					maximum = i - index;
			} else {
				mp.put(sum, i);
			}
		}

		return maximum;
	}
}
