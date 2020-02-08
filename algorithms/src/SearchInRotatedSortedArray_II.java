/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
 */
public class SearchInRotatedSortedArray_II {

	public static void main(String[] args) {
		int[] n = {2,5,6,0,0,1,2};
		int target = 3;
		boolean res=false;
		int s=0;int e=n.length-1;
		while(s<=e) {
			int m= s + (e-s)/2;
			if(target==n[m]) {
				res=true;
				break;
			}else if(n[s]>n[m]) {			//Right side is sorted
				if(n[m] < target && target <=n[e]) {
					s=m+1;
				}else {
					e=m-1;
				}
			}else if(n[s]<n[m]) {			//Left side is sorted
				if(n[s]<=target && target < n[m]) {
					e=m-1;
				}else {
					s=m+1;
				}
			}else {
				s++;
			}
			
		}
		System.out.println(res);
	}

}
