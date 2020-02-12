package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSubsequence {

	public static void main(String args[]) {
		int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
		int n = arr.length;
		System.out.println("Length of the Longest consecutive subsequence is " + findLongestConseqSubseq(arr, n));
	}

	private static int findLongestConseqSubseq(int[] arr, int n) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		int count = 0;
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			mp.put(arr[i], i);
		}

		for (int i = 0; i < arr.length; i++) {
			count = 1;
			if (mp.containsKey(arr[i] - 1)) {
				int val = arr[i] - 1;
				while (mp.containsKey(val)) {
					count++;
					val--;
				}
				if (count > max)
					max = count;

			}
		}
		return max;
	}
}
