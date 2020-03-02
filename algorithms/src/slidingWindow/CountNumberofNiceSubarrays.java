package slidingWindow;
/* https://leetcode.com/problems/count-number-of-nice-subarrays/submissions/
 * Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.

Example 1:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 */
public class CountNumberofNiceSubarrays {

	public static void main(String[] args) {
		CountNumberofNiceSubarrays test = new CountNumberofNiceSubarrays();
		int[] nums = new int[] {2,2,2,1,2,2,1,2,2,2};int k=2;
		System.out.println(test.numberOfSubarrays(nums, k));

	}
	 public int numberOfSubarrays(int[] nums, int k) {
		  int low=0,answer=0,oddCnt=0;
		  for(int hi=0;hi<nums.length;hi++) {
			  if(nums[hi]%2!=0)			//Keep increasing high and increase oddCount aslong as array has odd
				  oddCnt++;
			  if(oddCnt==k) {			//if oddCount reaches k then there is 1 way to count this as nice subarray
				  answer++;
			  }
			  
			  //This condition checks for low index array values with odd value 
			  while(low<hi && oddCnt>k) {
				  //this condition of oddCnt>k will be reached when high index keeps increasing
				  //and oddCnt keeps  increasing
				  if(nums[low]%2!=0) {	//if low index has oddCnt, then reduce oddCnt and bring it back to k
					  oddCnt--; 
				  }
				  low++;
			  }
			  
			  //what is low index values are even ? in that case check iddCnt==k
			  //and keep increasing answer because of low index array values being even
			  for(int m=low;oddCnt==k && m<hi && nums[m]%2==0;m++) { 
				  answer++;
			 }
		  }
		  return answer;
	}
}
