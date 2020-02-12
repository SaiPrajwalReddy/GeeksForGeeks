package Strings;

public class LongestEvenLengthSubString {

	static public void main(String[] args) {
		String str = "123123";
		System.out.println("Length of the substring is " + findLength(str, str.length()));
	}

	private static int findLength(String str, int length) {
		// TODO Auto-generated method stub

		int lsum = 0;
		int rsum = 0;
		int max = 0;
		for (int k = 0; k < length - 1; k++) {
			int i = k;
			int j = k + 1;
			lsum = 0;
			rsum = 0;
			while (i >= 0 && j < length) {
				lsum = lsum + str.charAt(i) - '0';
				rsum = rsum + str.charAt(j) - '0';

				if (lsum == rsum)
					if (j - i + 1 > max)
						max = j - i + 1;
				i--;
				j++;

			}
		}
		return max;
	}
}
