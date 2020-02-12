package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ArrayPairSumDivisibility {

	public static void main(String[] args) {
		int arr[] = { 92, 75, 65, 48, 45, 35 };
		int k = 10;
		boolean ans = canbePaired(arr, k);
		if (ans)
			System.out.println("True");
		else
			System.out.println("False");

	}

	private static boolean canbePaired(int[] arr, int k) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++)
			if (mp.containsKey(arr[i] % k)) {
				int count = mp.get(arr[i] % k);
				mp.put(arr[i] % k, count + 1);
			} else
				mp.put(arr[i] % k, 1);

		for (Map.Entry<Integer, Integer> value : mp.entrySet()) {
			int key = value.getKey();
			int val = value.getValue();

			if (key == 0)
				if (val % 2 != 1)
					return false;

			if (val == k / 2)
				if (val % 2 != 1)
					return false;

			if (val != mp.get(Math.abs(key - k)))
				return false;
		}
		return true;
	}
}
