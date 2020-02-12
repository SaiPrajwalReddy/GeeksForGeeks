package Arrays;

public class InterleavedStrings {

	public static void main(String args[]) {
		if (test("XXY", "XXZ", "XXZXXXY"))
			System.out.println("Interleaved");
		else
			System.out.println("Not Interleaved");
		if (test("XY", "WZ", "WZXY"))
			System.out.println("Interleaved");
		else
			System.out.println("Not Interleaved");
		if (test("XY", "X", "XXY"))
			System.out.println("Interleaved");
		else
			System.out.println("Not Interleaved");
		if (test("YX", "X", "XXY"))
			System.out.println("Interleaved");
		else
			System.out.println("Not Interleaved");
		if (test("XXY", "XXZ", "XXXXZY"))
			System.out.println("Interleaved");
		else
			System.out.println("Not Interleaved");

	}

	private static boolean test(String string1, String string2, String string3) {
		// TODO Auto-generated method stub
		boolean table[][] = new boolean[string1.length()+1][string2.length()+1];

		for (int i = 0; i <= string1.length(); i++)
			for (int j = 0; j <= string2.length(); j++) {
				if (i == 0 && j == 0)
					table[i][j] = true;
				else if (i == 0) {
					if (string2.charAt(j - 1) == string3.charAt(j - 1))
						table[i][j] = table[i][j - 1];

				} else if (j == 0) {
					if (string1.charAt(i - 1) == string3.charAt(i - 1))
						table[i][j] = table[i - 1][j];

				} else if (string1.charAt(i - 1) == string3.charAt(i + j - 1)
						&& string2.charAt(j - 1) != string3.charAt(i + j - 1)) {
					table[i][j] = table[i - 1][j];

				} else if (string2.charAt(j - 1) == string3.charAt(i + j - 1)
						&& string1.charAt(i - 1) != string3.charAt(i + j - 1)) {
					table[i][j] = table[i][j - 1];
				} else if (string1.charAt(i - 1) == string3.charAt(i + j - 1)
						&& string2.charAt(j - 1) == string3.charAt(i + j - 1)) {
					table[i][j] = table[i - 1][j] || table[i][j - 1];
				}
			}

		return table[string1.length()][string2.length()];
	}
}
