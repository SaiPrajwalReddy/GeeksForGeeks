package Arrays;

public class SpiralTraversal {

	public static void main(String args[]) {
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		printSpiralOrder(a);
	}

	private static void printSpiralOrder(int[][] a) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, m = 6, n = 3;
		while (i < n && j < m) {
			for (int k = j; k < m; k++) {
				System.out.print(a[i][k] + " ");
			}
			i++;
			for (int k = i; k < n; k++) {
				System.out.print(a[k][m - 1] + " ");
			}
			m--;
			if (i < n) {
				for (int k = m - 1; k >= j; k--) {
					System.out.print(a[n - 1][k] + " ");
				}
				n--;
			}
			if (j < m) {
				for (int k = n - 1; k >= i; k--) {
					System.out.print(a[k][j] + " ");
				}
				j++;
			}
		}

	}

}
