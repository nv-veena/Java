package december2018;

import java.util.ArrayList;
import java.util.List;



public class BFSAdjacencyMatrix {
	private static Queue<Node1> queue;
	static ArrayList<Node1> nodes = new ArrayList<>();
	BFSAdjacencyMatrix(){
		queue = new Queue<Node1>();
	}
	public static class Node1{
		int data;
		boolean visited;
		Node1(int data){
			this.data = data;
		}
	}
	public  void bfs(int adjacencyMatrix[][], Node1 node) {
		queue.add(node);
		node.visited=true;
		while (!queue.isEmpty())
		{	
			Node1 element = queue.remove();
			System.out.print(element.data + "t");
			List<Node1> neighbours = findNeighbours(adjacencyMatrix,element);
			for(int j=0;j<neighbours.size();j++) { 
				Node1 n=neighbours.get(j);
				if(n != null && !n.visited ) {
					queue.add(n);
					n.visited= true;
				}
			}
		}	
		
	}
	public ArrayList<Node1> findNeighbours(int adjacencyMatrix[][],Node1 node){
		int idx = nodes.indexOf(node);	//get index of the object 
		ArrayList<Node1> neighboursList = new ArrayList<>();
		for(int i=0;i<adjacencyMatrix[idx].length;i++) {
			if(adjacencyMatrix[idx][i] == 1) {
				neighboursList.add(nodes.get(i));
			}
		}
		return neighboursList;
	}
	public static void main(String[] args) {
		Node1 node40 = new Node1(40);
		Node1 node20 = new Node1(20);
		Node1 node10 = new Node1(10);
		Node1 node30 = new Node1(30);
		Node1 node50 = new Node1(50);
		Node1 node60 = new Node1(60);
		Node1 node70 = new Node1(70);
		
		nodes.add(node40);
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node30);
		nodes.add(node60);
		nodes.add(node50);
		nodes.add(node70);
		
		int[][] adjacency_matrix = {
				{0,1,1,0,0,0,0},
				{0,0,0,1,0,0,0},
				{0,1,0,1,1,1,0},
				{0,0,0,0,1,0,0},
				{0,0,0,0,0,0,1},
				{0,0,0,0,0,0,1},
				{0,0,0,0,0,0,0},
						
		};
		BFSAdjacencyMatrix bfsAdjMatrix = new BFSAdjacencyMatrix();
		System.out.println("The BFS traversal usinf adjacency matrix ");
		bfsAdjMatrix.bfs(adjacency_matrix,node40);
	}

}
