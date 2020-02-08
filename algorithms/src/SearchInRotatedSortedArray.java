/* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
*/

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] n = {6,7,8,9,1,2,3,4};
		int res = -1;int target = 3;
		int s = 0;int e=n.length-1;
		while(s<=e) {
			int m = s+ (e-s)/2;			//use s + (e-s)/2 to avoid overflow
			if(n[m]== target) {
				res=m;break;
			}
			else if(n[s] > n[m]) {	//Right side is sorted
				if(n[m] < target && target <=n[e]) {
					s=m+1;
				}else
					e=m-1;
			}else {				//Left side is sorted
				if(n[s]<=target && target < n[m]) {
					e=m-1;
				}else {
					s=m+1;
				}
			}
		}
		System.out.println(res);
	}

}
