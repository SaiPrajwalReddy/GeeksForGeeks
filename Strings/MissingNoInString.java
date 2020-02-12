package Strings;

public class MissingNoInString {

	public static void main(String[] args) {
		System.out.println(findMissingNumber("9991001"));
	}

	private static int findMissingNumber(String string) {
		// TODO Auto-generated method stub
		int startVal = findIndex(string);
		
		Integer nextVal = startVal + 1;

		while (true) {			
			int index = isSubstring(nextVal.toString(),string);
			if (index == -1)
				return nextVal;
			else
				nextVal++;
		}

	}

	private static int findIndex(String string) {
		// TODO Auto-generated method stub

		Integer val = -1;
		Integer nextVal = -1;
		int j = 0;	
			while (nextVal - val != 1 || nextVal - val != 2) {

				val = Integer.parseInt(string.substring(0, j + 1));
				if (All9s(val.toString()))
					nextVal = Integer.parseInt(string.substring(j + 1, 2 * (j + 1) + 1));
				else
					nextVal = Integer.parseInt(string.substring(j + 1, 2 * (j + 1)));
				if (nextVal - val == 1 || nextVal - val == 2)
					break;
				j++;
				if(j>string.length() || 2*(j+1)>= string.length())
					break;
			}		
		return val;

	}

	private static boolean All9s(String val) {
		// TODO Auto-generated method stub
		for (int i = 0; i < val.length(); i++)
			if (val.charAt(i) != '9')
				return false;
		return true;
	}

	static int isSubstring(String s1, String s2) {		
		int M = s1.length();
		int N = s2.length();

		/* A loop to slide pat[] one by one */
		for (int i = 0; i <= N - M; i++) {
			int j;

			/*
			 * For current index i, check for pattern match
			 */
			for (j = 0; j < M; j++)
				if (s2.charAt(i + j) != s1.charAt(j))
					break;

			if (j == M)
				return i;
		}

		return -1;
	}
}
