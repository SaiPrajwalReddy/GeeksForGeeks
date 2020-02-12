package Arrays;

public class BooleanMatrixQuestion {

	public static void printMatrix(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println("");
		}
	}

	// Driver function to test the above function
	public static void main(String args[]) {

		int mat[][] = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
		printMatrix(mat);

		modifyMatrix(mat);

		System.out.println("Matrix After Modification :");
		printMatrix(mat);

	}

	private static void modifyMatrix(int[][] mat) {
		// TODO Auto-generated method stub
		boolean rowFlag = false;
		boolean colFlag = false;

		for (int i = 0; i < mat.length; i++) {
			if (mat[0][i] == 1)
				rowFlag = true;
		}

		for (int i = 0; i < mat.length; i++) {
			if (mat[i][0] == 1)
				colFlag = true;
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {

				if (mat[i][j] == 1) {
					mat[i][0] = 1;
					mat[0][j] = 1;
				}

			}
		}
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if (mat[i][0] == 1 || mat[0][j] == 1)
					mat[i][j] = 1;
			}
		}

		if (rowFlag)
			for (int i = 0; i < mat.length; i++)
				mat[0][i] = 1;
		if (colFlag)
			for (int i = 0; i < mat.length; i++)
				mat[i][0] = 1;

	}
}
