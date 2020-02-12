package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctEleInEveryWindow {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, k = 4;

		countDistinctEle(arr, arr.length, k);
	}

	private static void countDistinctEle(int[] arr, int length, int k) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		int distinct = 0;
		for (int i = 0; i < k; i++) {
			if (mp.containsKey(arr[i])) {
				int count = mp.get(arr[i]);
				mp.put(arr[i], count + 1);

			} else {
				mp.put(arr[i], 1);
				distinct++;
			}
		}
		System.out.println("Distinct elements in array of size k are:");
		System.out.print(distinct+" ");
		for (int i = k; i < arr.length; i++) {

			int count = mp.get(arr[i - k]);

			if (count == 1) {
				mp.remove(arr[i - k]);
				distinct--;
			} else
				mp.put(arr[i-k], count - 1);

			if (mp.containsKey(arr[i])) {
				int ct = mp.get(arr[i]);
				mp.put(arr[i], ct + 1);

			} else {
				mp.put(arr[i], 1);
				distinct++;
			}

			System.out.print(distinct+" ");
		}
	}
}
