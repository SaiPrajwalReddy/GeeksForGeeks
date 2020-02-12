package Arrays;

public class LargestNumByKSwaps {

	static StringBuffer max;

	public static void main(String args[]) {
		String str1 = "129814999";

		int k = 4;
		StringBuffer str = new StringBuffer(str1);
		max = str;
		findMaximumNum(str, k, max);
		System.out.println(max);

	}

	private static void findMaximumNum(StringBuffer str, int k, StringBuffer max) {
		// TODO Auto-generated method stub
		if (k == 0)
			return;
		for (int i = 0; i < str.length() - 1; i++)
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) < str.charAt(j)) {
					swap(str, i, j);
					if (Integer.parseInt(str.toString()) > Integer.parseInt(max.toString()))
						max = str;
					findMaximumNum(str, k - 1, max);
					swap(str, i, j);

				}
			}

	}

	private static void swap(StringBuffer str, int i, int j) {
		// TODO Auto-generated method stub
		str.setCharAt(i, str.charAt(j));
		str.setCharAt(j, str.charAt(i));

	}
}
