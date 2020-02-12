package Recursion;

public class NumOfPath {

	public static void main(String args[]) {

		System.out.println(numOfPaths(3, 3));
	}

	private static int numOfPaths(int i, int j) {

		if (i == 1 || j == 1)
			return 1;

		return numOfPaths(i - 1, j) + numOfPaths(i, j - 1);
	}
}
