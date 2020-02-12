package Graphs;

import java.util.LinkedList;


public class DepthFirstTraversal {
	
	static class Graph {

		int vertices;
		LinkedList<Integer> arr[] = null;

		Graph(int v) {
			vertices = v;
			arr = new LinkedList[vertices];
			for (int i = 0; i < vertices; i++) {
				arr[i] = new LinkedList<Integer>();
			}

		}

		void addEdge(int u, int v) {
			arr[u].add(v);
		}

		public void DFS(int i) {
			// TODO Auto-generated method stub
			boolean[] visited = new boolean[vertices];
			DFSUtil(i,visited);
		}

		private void DFSUtil(int i, boolean[] visited) {
			// TODO Auto-generated method stub
			if(visited[i] == true)
				return;
			
			System.out.print(i+" ");
			visited[i] = true;
			LinkedList<Integer> temp = arr[i];
			for(Integer k : temp)
			{
				if(visited[k] == false)
					DFSUtil(k,visited);
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

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);
	}
}
