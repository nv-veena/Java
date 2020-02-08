package graphs;
/*This question can be simplified to three conditions:

TopSort order exists
Whether the TopSort order is the only one (Uniqueness of Topological sort, Hamilton path, see https://en.wikipedia.org/wiki/Topological_sorting#Uniqueness)
the only top sort order constructed should be equal to the org.
index == org.length (check condition 3) && index == map.size() (check all the vertex in the graph has been visited, so the top sort order exists, check condition 1)

How to check only one order? queue.size() should always be one, then only one element at a time has indegree to be 0, so you only have one choice (check condition 2)
https://leetcode.com/problems/sequence-reconstruction/
*/
import java.util.*;
public class UniqueTopologicalSortExistsDAG {

	public static void main(String[] args) {
		
		int[] org = new int[] {1,2,3}; 
		List<List<Integer>> lst = new ArrayList<>();
		lst.add(Arrays.asList(1,2));lst.add(Arrays.asList(1,3));lst.add(Arrays.asList(2,3));
		UniqueTopologicalSortExistsDAG test=new UniqueTopologicalSortExistsDAG();
		System.out.println(test.sequenceReconstruction(org, lst));

	}
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		Map<Integer,Set<Integer>> map = new HashMap<>();
		Map<Integer,Integer> indegree=new HashMap<>();
		for(List<Integer> seq:seqs) {
			for(int i=0;i<seq.size()-1;i++) {
				map.putIfAbsent(seq.get(i), new HashSet<>());
				indegree.putIfAbsent(seq.get(i),0);
				
				map.putIfAbsent(seq.get(i+1), new HashSet<>());
				indegree.putIfAbsent(seq.get(i+1),0);				
				
				if(map.get(seq.get(i)).add(seq.get(i+1)))
					indegree.put(seq.get(i+1), indegree.get(seq.get(i+1))+1);
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int item:indegree.keySet()) {
			if(indegree.get(item)==0) {
				q.offer(item);
			}
		}
		int idx=0;
		while(!q.isEmpty()) {
			int size=q.size();
			if(size>1)return false;
			int curr=q.poll();
			if(idx==org.length || curr!=org[idx++])return false;
			for(int adj:map.get(curr)) {
				indegree.put(adj,indegree.get(adj)-1);
				if(indegree.get(adj)==0)
					q.offer(adj);
			}
			
		}
		return idx==org.length && idx==map.size();
	}
}
