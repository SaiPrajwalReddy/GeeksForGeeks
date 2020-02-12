package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

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

		public void BFS(int i) {
			// TODO Auto-generated method stub
			Queue<Integer> q = new LinkedList<Integer>();
			boolean visited[] = new boolean[vertices];
			q.add(i);
			while (!q.isEmpty()) {
				
				int vertex = q.peek();
				System.out.print(vertex + " ");
				visited[vertex] = true;
				q.poll();
			
				LinkedList<Integer> temp = arr[vertex];
				for (Integer k : temp) {					
					if (!visited[k])
						q.add(k);
				}
			}
		}
	}

	public static void main(String args[]) {

		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}

}
