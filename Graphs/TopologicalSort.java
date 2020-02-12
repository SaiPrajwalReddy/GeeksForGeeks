package Graphs;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	static class Graph {

		int vertices;
		LinkedList<Integer> arr[] = null;
		Stack<Integer> sortResult = new Stack<Integer>();

		Graph(int v) {
			vertices = v;
			arr = new LinkedList[vertices];
			for (int i = 0; i < vertices; i++)
				arr[i] = new LinkedList<Integer>();

		}

		public void addEdge(int u, int v) {
			arr[u].add(v);
		}

		public void topologicalSort() {
			// TODO Auto-generated method stub
			boolean visited[] = new boolean[vertices];
			for (int i = 0; i < vertices; i++) {
				if (!visited[i])
					DFS(i, visited);
			}

			while (!sortResult.isEmpty())
				System.out.print(sortResult.pop() + " ");
		}

		private void DFS(int i, boolean[] visited) {
			// TODO Auto-generated method stub
			visited[i] = true;
			LinkedList<Integer> temp = arr[i];
			for (Integer k : temp) {
				if (!visited[k])
					DFS(k, visited);
			}

			sortResult.add(i);
		}
	}

	public static void main(String args[]) {
		// Create a graph given in the above diagram
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		g.topologicalSort();
	}
}
