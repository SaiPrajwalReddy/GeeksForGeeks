package Graphs;

public class DijkstrasAlgo {

	public static void main(String[] args) {

		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		DijkstrasAlgo t = new DijkstrasAlgo();
		t.dijkstra(graph, 0);
	}

	private void dijkstra(int[][] graph, int source) {
		// TODO Auto-generated method stub
		boolean included[] = new boolean[9];
		int distance[] = new int[9];

		for (int i = 0; i < 9; i++) {
			included[i] = false;
			distance[i] = Integer.MAX_VALUE;

		}

		distance[source] = 0;

		for (int v = 0; v < 9; v++) {
			int vertex = findMin(distance, included);

			included[vertex] = true;

			for (int k = 0; k < 9; k++) {
				if (graph[vertex][k] > 0 && !included[k] 
						&& distance[k] > distance[vertex] + graph[vertex][k]) {
					distance[k] = distance[vertex] + graph[vertex][k];
				}
			}

		}

		for (int i = 0; i < 9; i++)
			System.out.println("Shortest distance for vertex " + i + " is " + distance[i]);
	}

	private int findMin(int[] distance, boolean[] included) {
		// TODO Auto-generated method stub
		int minIndex = -1;
		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < 9; i++) {
			if (!included[i]) {
				if (minDist >= distance[i]) {
					minDist = distance[i];
					minIndex = i;
				}
			}
		}
		return minIndex;
	}
}
