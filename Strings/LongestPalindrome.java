package Strings;

public class LongestPalindrome {

	public static void main(String args[]) {

		String str = "forgeeksskeegfor";
		longestPalindromicSubstring(str);
	}

	private static void longestPalindromicSubstring(String str) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = 0;
		int maximum = 0;
		for (int i = 0; i < str.length(); i++) {
			int k = i - 1;
			int j = i + 1;

			while (k >= 0 && j < str.length() && str.charAt(k) == str.charAt(j)) {

				if (j - k + 1 > maximum) {
					maximum = j - k + 1;
					start = k;
					end = j;
				}

				k--;
				j++;
			}

			k = i - 1;
			j = i;

			while (k >= 0 && j < str.length() && str.charAt(k) == str.charAt(j)) {
				if (j - k + 1 > maximum) {
					maximum = j - k + 1;
					start = k;
					end = j;
				}

				k--;
				j++;
			}

		}

		for (int i = start; i <= end; i++) {
			System.out.print(str.charAt(i));
		}
	}
}
