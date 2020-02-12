package Graphs;

public class FloydWarshall {

	public static void main(String[] args) {

		int graph[][] = { { 0, 5, 99999, 10 }, { 99999, 0, 3, 99999 }, { 99999, 99999, 0, 1 },
				{ 99999, 99999, 99999, 0 } };
		FloydWarshall a = new FloydWarshall();

		// Print the solution
		a.floydWarshall(graph);
	}

	private void floydWarshall(int[][] graph) {
		// TODO Auto-generated method stub
		int dist[][] = new int[4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				dist[i][j] = graph[i][j];

		for (int k = 0; k < 4; k++)
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}

		for (int i = 0; i < 4; i++) {
			System.out.println();
			for (int j = 0; j < 4; j++)
				System.out.print(dist[i][j] + " ");
		}
	}
}
