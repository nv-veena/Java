package dijkstra;
/* https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 * There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.
Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
Output: 3
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
 * 
 */
import java.util.*;

public class CityWithSmallestNumberofNeighborsAtThresholdDist {
	public int findTheCity(int[][] edges,int distanceThreshold,int n) {
		
		 Map<Integer, List<int[]>> g = new HashMap<>();
		 
		   //Prepare a Map of Graph with key being source City, Value being 
		   //array of integer referring to destination and the distance to the destination from source city
	        for(int i=0;i<n;i++){
	            g.put(i,new ArrayList<>());
	        }
	        for(int[] e : edges){
	            g.get(e[0]).add(new int[]{e[1], e[2]});
	            g.get(e[1]).add(new int[]{e[0], e[2]});
	        }
	        
	        //For all the cities, prepare a n * n matrix with infinite distance from source to destination
	       int[][] dist=new int[n][n];
	       for(int i=0;i<n;i++){
	           Arrays.fill(dist[i],10001);
	           dist[i][i]=0;   //If source and destination cities are the same then distance=0
	       }
	        
	        for(int city = 0; city < n; city++){
	            dijsktra(city, g, n,dist[city]);
	        }
	        
	        
	       int result = -1;		//return the city with smallest number of cities as neighbours within threshold distance 
	                             
	       int reachableCities = n; //assume each city can reach all remaining cities
	        for(int i=0;i<n;i++){
	            int count = 0;
	            for(int j=0;j<n;j++){
	                if(i==j)continue;
	                
	                //if cost from city i -> j <= distanceThreshold then count the city
	                if(dist[i][j] <= distanceThreshold){
	                    count++;
	                }
	            }
	            if(count <= reachableCities){
	                reachableCities = count;
	                result = i;
	            }
	        }
	        //return the highest numbered city with smallest number of neighbour cities within threshold distance
	        return result;
	}
	
	
	public void dijsktra(int sourceCity, Map<Integer, List<int[]>> g, int n,int[] costs){
       //Prepare PriorityQueue and fill costs[city] array with minimum cost to go 
		//to the destination from sourceCity
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> costs[a] - costs[b]);
        queue.add(sourceCity);
        while (!queue.isEmpty()){
            int currentCity = queue.poll();
            List<int[]> neighbours = g.get(currentCity);
            
            //Iterate through all neighbours of the sourceCity
            //and check the cost to go to destination city from source City 
            for(int[] c: neighbours){
                int toCity = c[0], distance = c[1];
                if(costs[toCity] > costs[currentCity] + distance){
                	//set the cost to the destination city with smallest cost
                	//from source city
                    costs[toCity] = costs[currentCity] + distance;
                    queue.add(toCity);   
                }
            }
        }
    }

}
