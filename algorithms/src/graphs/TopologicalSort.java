package graphs;
import java.util.*;
public class TopologicalSort {

	public static void main(String[] args) {
		int numOfCourses=3;
		int[][] prerequisites=new int[][] {{1,0},{2,1}};
		TopologicalSort test=new TopologicalSort();
		int[] ans=test.findOrder(numOfCourses, prerequisites);

	}
	 public int[] findOrder(int numCourses, int[][] prerequisites) {
	        int[] indegree = new int[numCourses];
	        Queue<Integer> q = new LinkedList<>();
	        
	        for(int i=0;i<prerequisites.length;i++){
	            int[] pair = prerequisites[i];
	            indegree[pair[0]]++;
	        }
	         List<Integer> order = new ArrayList<>();
	        
	        for(int i=0;i<indegree.length;i++){
	            if(indegree[i]==0){
	                q.offer(i);
	            } 
	        }
	      
	        while(!q.isEmpty()){
	            int course=q.poll();
	            order.add(course);
	            for(int i=0;i<prerequisites.length;i++){
	                int[] pair=prerequisites[i];
	                if(pair[1]==course){
	                    indegree[pair[0]]--;
	                    if(indegree[pair[0]]==0)
	                        order.add(pair[0]);
	                }
	            }
	        }
	         if(order.size()<numCourses){
	            return new int[0];
	        }else{
	             int[] arr = new int[numCourses];
	             for(int i=0;i<order.size();i++){
	                 arr[i]=order.get(i);
	             }
	             return arr;
	         }
	        
	        
	    }
}
