package DynamicProgramming;

public class EditDistance {

	public static void main(String args[]) {
		String str1 = "sunday";
		String str2 = "saturday";
		System.out.println(editDistDP(str1, str2, str1.length(), str2.length()));
	}

	private static int editDistDP(String str1, String str2, int length1, int length2) {
		// TODO Auto-generated method stub
		int temp[][] = new int[length1+1][length2+1];

		for (int i = 0; i <= length1; i++)
			for (int j = 0; j <= length2; j++) {
				if (i == 0)
					temp[i][j] = j;
				else if (j == 0)
					temp[i][j] = i;
				else if (str1.charAt(i - 1) == str2.charAt(j - 1))
					temp[i][j] = temp[i - 1][j - 1];
				else
					temp[i][j] = min(temp[i - 1][j], temp[i][j - 1], temp[i - 1][j - 1])+1;

			}
		return temp[length1][length2];
	}

	private static int min(int i, int j, int k) {
		// TODO Auto-generated method stub
		if (i < j && i < k)
			return i;
		else if (j < i && j < k)
			return j;
		else
			return k;

	}
}
