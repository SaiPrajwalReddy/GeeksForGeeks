package Recursion;

public class FloodFillAlgo {

	public static void main(String[] args) {
		int screen[][] = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 }, { 1, 0, 0, 1, 1, 0, 1, 1 },
				{ 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 2, 2, 0 },
				{ 1, 1, 1, 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1, 2, 2, 1 }, };
		int x = 0, y = 0, newC = 3;
		int prevC = screen[0][0];
		floodFillAlgo(screen, x, y, prevC, newC);

		System.out.println("Array with new colors updated");
		for (int i = 0; i < 8; i++) {
			System.out.println();
			for (int j = 0; j < 8; j++) {
				System.out.print(screen[i][j] + " ");
			}
		}

	}

	private static void floodFillAlgo(int[][] screen, int x, int y, int prevC, int newC) {
		// TODO Auto-generated method stub
		if (x < 0 || x >= 8 || y < 0 || y >= 8)
			return;

		if (screen[x][y] != prevC)
			return;
		screen[x][y] = newC;

		floodFillAlgo(screen, x + 1, y, prevC, newC);
		floodFillAlgo(screen, x, y + 1, prevC, newC);
		floodFillAlgo(screen, x - 1, y, prevC, newC);
		floodFillAlgo(screen, x, y - 1, prevC, newC);
	}
}
