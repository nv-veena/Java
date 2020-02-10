package heaps;
/* https://leetcode.com/problems/reduce-array-size-to-the-half/
 * Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
 */
import java.util.*;

public class ReduceArraySizeToTheHalf {

	public static void main(String[] args) {
		int[] arr = {3,3,3,3,5,5,5,5,2,7};
		ReduceArraySizeToTheHalf test=new ReduceArraySizeToTheHalf();
		System.out.println(test.minSetSize(arr));
	}
	 public int minSetSize(int[] arr) {
		 Map<Integer, Integer> map = new HashMap<>();
	       for (int num : arr) {
			 map.put(num, map.getOrDefault(num, 0) + 1);
		   }
	       PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)->(b-a));
	        pq.addAll(map.values());
	        int ans=0;int numbers=0;
	        while(ans<arr.length/2){
	            numbers++;
	            ans+=pq.poll();
	        }
	        return numbers;
	    }
}
