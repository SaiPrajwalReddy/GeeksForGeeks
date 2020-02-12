package Graphs;

import java.util.LinkedList;

public class DetectCycleInDirectedGraph {

	static class Graph {

		int vertices;
		LinkedList<Integer> arr[] = null;

		Graph(int v) {
			vertices = v;
			arr = new LinkedList[vertices];
			for (int i = 0; i < vertices; i++)
				arr[i] = new LinkedList<Integer>();

		}

		public void addEdge(int u, int v) {
			arr[u].add(v);
		}

		public void detectCycle() {
			// TODO Auto-generated method stub
			boolean[] visited = new boolean[vertices];
			boolean[] recStack = new boolean[vertices];
			boolean cyclic = false;

			for (int i = 0; i < vertices; i++) {

				if (isCyclic(visited, i, recStack)) {
					System.out.println("Given graph is cyclic");
					cyclic = true;
					break;
				}

			}
			if (!cyclic)
				System.out.println("Given graph is Acyclic");
		}

		private boolean isCyclic(boolean[] visited, int i, boolean[] recStack) {
			// TODO Auto-generated method stub
			

			if (recStack[i])
				return true;
			
			if (visited[i])
				return false;

			visited[i] = true;
			recStack[i] = true;

			LinkedList<Integer> temp = arr[i];

			for (Integer k : temp) {

				if (isCyclic(visited, k, recStack))
					return true;

			}
			recStack[i] = false;

			return false;

		}
	}

	public static void main(String args[]) {

		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		graph.detectCycle();
	}

}
